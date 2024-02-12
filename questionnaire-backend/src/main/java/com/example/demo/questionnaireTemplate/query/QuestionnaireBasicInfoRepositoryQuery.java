package com.example.demo.questionnaireTemplate.query;

import com.example.demo.questionnaireTemplate.domian.QuestionnaireTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionnaireBasicInfoRepositoryQuery extends JpaRepository<QuestionnaireBasicInfoQuery, Long> {

    List<QuestionnaireBasicInfoQuery> findAll();
}
