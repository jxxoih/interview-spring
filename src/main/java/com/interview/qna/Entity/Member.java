package com.interview.qna.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {
    @Id
    private int m_idx;
    private String m_id;
    private String m_password;
}
