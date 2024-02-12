package com.example.demo.questionnaireTemplate.query;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "questionnaire_template")
public class QuestionnaireBasicInfoQuery {
    @Id
    private Long id;
    private String title;
    private String description;
}
