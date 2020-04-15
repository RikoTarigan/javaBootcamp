package com.Kuesioner.Quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Kuesioner.Quiz.models.QuestionaireDetail;
@Repository
public interface QuestionaireDetailRepository extends JpaRepository<QuestionaireDetail, String> {

}
