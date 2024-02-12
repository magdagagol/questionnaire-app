package com.example.demo.questionnaireTemplate.domian.dto;

import com.example.demo.questionnaireTemplate.domian.Question;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
public class QuestionnaireTemplateDto {
    private String title;
    private String description;
    private Set<Question> questions;
}
