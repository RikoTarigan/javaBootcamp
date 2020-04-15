package com.Kuesioner.Quiz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Kuesioner.Quiz.models.QuestionaireHeader;

@Repository
public interface QuestionaireHeaderRepository extends JpaRepository<QuestionaireHeader, String>{
	@Query(value = "select qd.question_detail_id, qd.answ1, qd.answ2, qd.answ3, qd.answ4, qd.key_answ, qd.point, " + 
			"qd.question_desc, qd.question_header_code from questionaire_detail qd inner join " + 
			"questionaire_header qh on qd.question_header_code = qh.question_header_code " + 
			"where qh.question_header_code=:paramQuiz", nativeQuery = true)
	
	public List<Object[]> getdata(@Param("paramQuiz") String str);
	
}
