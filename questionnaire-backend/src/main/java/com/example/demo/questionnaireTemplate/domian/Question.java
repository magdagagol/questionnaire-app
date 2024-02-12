package com.example.demo.questionnaireTemplate.domian;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questionnaire_question")
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<>();
    private String type;

    @ManyToOne()
    @JoinColumn(name = "questionnaire_template_id")
    @JsonIgnore
    private QuestionnaireTemplate questionnaireTemplate;

    public Question(String title, String type, QuestionnaireTemplate questionnaireTemplate) {
        this.title = title;
        this.type = type;
        this.questionnaireTemplate = questionnaireTemplate;
    }
}
