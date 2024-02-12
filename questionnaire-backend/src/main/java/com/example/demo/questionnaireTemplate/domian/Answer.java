package com.example.demo.questionnaireTemplate.domian;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questionnaire_answer")
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    private String value;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    public Answer(String label, String value, Question question) {
        this.label = label;
        this.value = value;
        this.question = question;
    }
}
