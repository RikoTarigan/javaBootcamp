package com.Kuesioner.Quiz.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kuesioner.Quiz.models.QuestionaireDetail;
import com.Kuesioner.Quiz.models.QuestionaireHeader;
import com.Kuesioner.Quiz.repositories.QuestionaireDetailRepository;
import com.Kuesioner.Quiz.repositories.QuestionaireHeaderRepository;

@Service
public class QuizService {

	@Autowired
	private QuestionaireDetailRepository questionDetailRepo;
	@Autowired
	private QuestionaireHeaderRepository questionHeaderRepo;	
	
	public List<QuestionaireDetail> getAllQuestion()
	{
		return questionDetailRepo.findAll();
	}
	
	public boolean cek(String id, String answer) {
		boolean flag = false;
		Optional<QuestionaireDetail> x = questionDetailRepo.findById(id);
		if(x.isPresent())
		{
			if(x.get().getKeyAnsw().equals(answer))
				flag = true;
		}
		return flag;
	}
	public int scoreQuestion(String id)
	{
		return new Integer(questionDetailRepo.findById(id).get().getPoint());
	}
	public List<QuestionaireHeader> getAllQuestionTipe()
	{
		return questionHeaderRepo.findAll();
	}
	
	public List<LinkedHashMap<String, Object>>  getAllQuestionByType(String questionHeaderCode)
	{		
		List<Object[]> lstDatas = questionHeaderRepo.getdata(questionHeaderCode);
		List<LinkedHashMap<String, Object>> data = new ArrayList<LinkedHashMap<String,Object>>();
		LinkedHashMap<String, Object> map=null;
		
		for(Object[] obj:lstDatas)
		{
			map = new LinkedHashMap<String, Object>();
			map.put("questionDetailId", obj[0]);
			map.put("answ1", obj[1]);
			map.put("answ2", obj[2]);
			map.put("answ3", obj[3]);
			map.put("answ4", obj[4]);
			map.put("keyansw", obj[5]);
			map.put("point", obj[6]);
			map.put("questionDesc", obj[7]);
			map.put("questionHeaderCode", obj[8]);
			data.add(map);
		}
		return data;
	}
}
