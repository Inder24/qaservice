package com.edtech.qaservice.controller;

import com.edtech.qaservice.model.QuestionItem;
import com.edtech.qaservice.service.QuestionService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edtech/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("author/{author}")
    public String createQuestionIntoDynamoDB(@PathVariable(value = "author") String author, @RequestBody QuestionItem questionItem) {
        try {
            questionItem.setAuthor(author);
            questionService.postQuestionByQuestionItem(questionItem);
            return "Successfully inserted question into QAService table";
        } catch (Exception e) {
            return "Failed to inserted into DynamoDB table due to " + e.getMessage();
        }

    }

    @GetMapping("id/{id}")
    public QuestionItem getQuestionByAuthorAndDate(@PathVariable(value = "id") String id)
    {
        return questionService.getQuestionById(id);
    }
}
