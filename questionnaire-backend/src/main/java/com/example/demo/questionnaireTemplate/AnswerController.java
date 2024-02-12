package com.example.demo.questionnaireTemplate;

import com.example.demo.questionnaireTemplate.domian.AnswerRepository;
import com.example.demo.questionnaireTemplate.domian.dto.QuestionnaireTemplateDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/answer")
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerController {
    private QuestionnaireTemplateService service;

    @PostMapping
    public HttpEntity<?> addAnswers(@RequestBody Map<Long, String> answers){
        service.addAnswers(answers);
        return ResponseEntity.ok().build();
    }
}
