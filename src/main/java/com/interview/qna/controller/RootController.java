package com.interview.qna.controller;

import com.interview.qna.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class RootController {

    private final InterviewService interviewService;

    @Autowired
    public RootController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("/")
    public String getTest() {
        return "Hello JPA";
    }
}
