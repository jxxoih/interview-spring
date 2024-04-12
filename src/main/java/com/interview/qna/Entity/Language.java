package com.interview.qna.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "language_mapping")
public class Language {

    @Id
    private int l_id;
    private String l_text;
    private int l_type;
}
