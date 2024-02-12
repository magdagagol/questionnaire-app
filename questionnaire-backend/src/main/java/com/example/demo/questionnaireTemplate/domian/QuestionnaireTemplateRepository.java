package com.example.demo.questionnaireTemplate.domian;

import com.example.demo.questionnaireTemplate.domian.QuestionnaireTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionnaireTemplateRepository extends JpaRepository<QuestionnaireTemplate, Long> {

    QuestionnaireTemplate save (QuestionnaireTemplate template);

    List<QuestionnaireTemplate> findAll();

}
