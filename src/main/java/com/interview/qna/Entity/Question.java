package com.interview.qna.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question {
    @Id
    private int q_id;
    private String i_question;
    private String i_answer;
    private int q_type;
    private int use_state;
}
