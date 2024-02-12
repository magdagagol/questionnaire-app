package com.example.demo.questionnaireTemplate;

import com.example.demo.questionnaireTemplate.domian.*;
import com.example.demo.questionnaireTemplate.domian.dto.QuestionnaireTemplateDto;
import com.example.demo.questionnaireTemplate.query.QuestionnaireBasicInfoQuery;
import com.example.demo.questionnaireTemplate.query.QuestionnaireBasicInfoRepositoryQuery;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Transactional
public class QuestionnaireTemplateService {

    QuestionnaireTemplateRepository repository;
    QuestionnaireBasicInfoRepositoryQuery query;
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;

    void createTemplate(QuestionnaireTemplateDto dto){
        QuestionnaireTemplate questionnaireTemplate = repository.saveAndFlush(new QuestionnaireTemplate(dto.getTitle(), dto.getDescription()));
        dto.getQuestions().forEach(e -> {
            Question question = questionRepository.saveAndFlush(new Question(e.getTitle(), e.getType(), questionnaireTemplate));
            e.getAnswers().forEach(a -> answerRepository.save(new Answer(a.getLabel(), a.getValue(), question)));
        });
    }

    List<QuestionnaireBasicInfoQuery> findAll(){
       return query.findAll();
    }

    QuestionnaireTemplate findTemplate(Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    void addAnswers(Map<Long, String> answers){
        answers.forEach((key, value) -> {
            Answer answer = answerRepository.findById(key).orElseThrow(EntityNotFoundException::new);
            String v = answer.getValue() + '|'  + value;
            answer.setValue(v);
        });
    }
}
