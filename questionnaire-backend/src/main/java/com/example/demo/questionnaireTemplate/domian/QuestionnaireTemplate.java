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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questionnaire_template")
public class QuestionnaireTemplate {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "questionnaireTemplate", cascade = CascadeType.ALL)
    private Set<Question> questions =new HashSet<>();

    public QuestionnaireTemplate(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
