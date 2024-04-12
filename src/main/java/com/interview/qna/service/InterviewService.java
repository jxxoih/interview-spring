package com.interview.qna.service;

import com.interview.qna.Entity.Language;
import com.interview.qna.Entity.Member;
import com.interview.qna.Entity.Question;
import com.interview.qna.dto.LanguageDto;
import com.interview.qna.dto.MemberDto;
import com.interview.qna.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    @Autowired
    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public JSONObject pwdCheck(String inputPwd) throws JSONException {
        Member member = interviewRepository.findMember();
        String pwd = member.getM_password();

        boolean result = pwd.equals(inputPwd);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);

        return jsonObject;
    }

    public List<Language> getLanguage() throws Exception {
        List<Language> languages = interviewRepository.findLanguage();

        return languages;
    }

    public List<Question> getQuestion(int q_type) {
        List<Question> questions;
        if(q_type == 0) {
            questions = interviewRepository.findQuestionsTypeOfAll(q_type);
        } else {
            questions = interviewRepository.findQuestions(q_type);
        }

        return questions;

    }
}
