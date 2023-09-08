package com.vti.examwebsise.examonline.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "exams")
@NoArgsConstructor
@AllArgsConstructor
public class Exam extends IdBasedEntity {
    @Column(nullable = false)
    private float mark;

    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "exams_answers",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private List<Answer> answers = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "exams_questions",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    List<Question> questions = new ArrayList<>();

}
