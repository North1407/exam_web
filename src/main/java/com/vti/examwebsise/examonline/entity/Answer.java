package com.vti.examwebsise.examonline.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "anwers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends IdBasedEntity {

    @Column(nullable = false)
    private String content;
    @Column(name = "is_correct")
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


    public Answer(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(content, answer.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
