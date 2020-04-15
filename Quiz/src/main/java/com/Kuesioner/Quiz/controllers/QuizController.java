package com.Kuesioner.Quiz.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kuesioner.Quiz.models.QuestionaireDetail;
import com.Kuesioner.Quiz.models.QuestionaireHeader;
import com.Kuesioner.Quiz.services.QuizService;

@Controller
public class QuizController {
	
	@Autowired
	private QuizService kuiservis;
	int Score = 0;
	List<LinkedHashMap<String, Object>> allQuestion=null;
	
	@GetMapping("begin")
	public String testEndPoint(Model model)
	{
		List<QuestionaireHeader> qe = kuiservis.getAllQuestionTipe();
		model.addAttribute("questionheader", qe);
		return "starting";
	}
	
	@GetMapping("backtokategori")
	public String backtokategori()
	{
		return "redirect:begin";
	}
	
	@RequestMapping(value = "starkuis",method=RequestMethod.POST)
	public String startKuis(Model model,HttpServletRequest request)
	{
		String questionHeaderCode="";
		String []questionIds = request.getParameterValues("questionType");
		try
		{
			for(String questionId:questionIds)
			{
				//System.out.println(questionId);
				questionHeaderCode = questionId;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		allQuestion = kuiservis.getAllQuestionByType(questionHeaderCode);

		List<QuestionaireDetail> data = kuiservis.getAllQuestion();
		//System.out.println(data.get(0).getAnsw1());
		model.addAttribute("question", kuiservis.getAllQuestion());
		//model.addAttribute("hai","haidlas");
		return "redirect:start";
	}
	
	
	
	@GetMapping("start")
	public String start(Model model)
	{
		if(allQuestion==null)
		{
			model.addAttribute("flag", false);
		}	
		else
		{		
			model.addAttribute("flag", true);
			Score=0;
			List<QuestionaireDetail> data = kuiservis.getAllQuestion();
			model.addAttribute("question",allQuestion);
		}
		return "quiz";
	}
	
	
	@RequestMapping(value = "submit",method=RequestMethod.POST)
	public String submit(HttpServletRequest request,Model model) {
		String []questionIds = request.getParameterValues("questionId");
		Score=0;
		String id="",answer="";
		try {
			for(String questionId:questionIds)
			{
				String []answerIds = request.getParameterValues("answer_" + questionId);
				id=questionId;
				for(String ans : answerIds)
				{
					answer = ans;
					//map = new LinkedHashMap<String, String>();
					//System.out.println(ans);
					//map.put(questionId, ans);
					//jawaban.add(new LinkedHashMap<String, String>().put)
				}
				//jawaban.add(map);
				if(kuiservis.cek(id, answer))
				{
					Score+=kuiservis.scoreQuestion(questionId);
				}
			}
		} 
		catch (Exception ex) {
	      //ignore
	    }
		//System.out.println(Score);
		model.addAttribute("score1",Score);
		return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String score(Model model)
	{
		model.addAttribute("score",Score);
		return "score";
	}
}
