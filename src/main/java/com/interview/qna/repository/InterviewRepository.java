package com.interview.qna.repository;

import com.interview.qna.Entity.Language;
import com.interview.qna.Entity.Member;
import com.interview.qna.Entity.Question;
import com.interview.qna.dto.LanguageDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InterviewRepository {

    private final EntityManager em;

    public Member findMember() {
        return em.find(Member.class, 1);
    }

    public List<Language> findLanguage() {
        return em.createQuery("select l from Language l where l.l_type < 99", Language.class)
                .getResultList();
    }

    public List<Question> findQuestions(int q_type) {
        return em.createQuery("select q from Question q where q.use_state > 0 and q.q_type = :q_type ORDER BY RAND()", Question.class)
                .setParameter("q_type", q_type)
                .getResultList();
    }
    public List<Question> findQuestionsTypeOfAll(int q_type) {
        return em.createQuery("select q from Question q where q.use_state > 0 and q.q_type IN (1,2,3) ORDER BY RAND()", Question.class)
                .getResultList();
    }

}
