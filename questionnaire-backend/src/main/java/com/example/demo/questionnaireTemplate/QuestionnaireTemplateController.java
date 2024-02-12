package com.example.demo.questionnaireTemplate;

import com.example.demo.questionnaireTemplate.domian.QuestionnaireTemplate;
import com.example.demo.questionnaireTemplate.domian.dto.QuestionnaireTemplateDto;
import com.example.demo.questionnaireTemplate.query.QuestionnaireBasicInfoQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/template")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionnaireTemplateController {
    private QuestionnaireTemplateService service;
    @PostMapping
    public HttpEntity<?> createTemplate(@RequestBody QuestionnaireTemplateDto dto){
        service.createTemplate(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public HttpEntity<List<QuestionnaireBasicInfoQuery>> getTemplates(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public HttpEntity<?> getTemplate(@PathVariable Long id){
        return ResponseEntity.ok(service.findTemplate(id));
    }
}
