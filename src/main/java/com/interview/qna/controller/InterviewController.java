package com.interview.qna.controller;

import com.interview.qna.Entity.Language;
import com.interview.qna.Entity.Question;
import com.interview.qna.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InterviewController {

    private final InterviewService interviewService;

    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("/auth")
    public String auth(
            @RequestParam Map<String, Object> map
    ) throws Exception {
        String inputPwd = map.get("arg[m_pwd]").toString();

        JSONObject result = interviewService.pwdCheck(inputPwd);

        return result.toString();
    }

    @GetMapping("/language")
    public List<Language> getLanguage() throws Exception {
        List<Language> result = interviewService.getLanguage();

        return result;
    }

    @GetMapping("/interview")
    public List<Question> getQuestion(
            @RequestParam Map<String, Object> map
    ) {
        int q_type = Integer.parseInt(map.get("arg[q_type]").toString());

        List<Question> result = interviewService.getQuestion(q_type);

        return result;
    }
}
