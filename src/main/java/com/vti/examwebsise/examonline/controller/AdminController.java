package com.vti.examwebsise.examonline.controller;

import com.vti.examwebsise.examonline.entity.Question;
import com.vti.examwebsise.examonline.entity.User;
import com.vti.examwebsise.examonline.service.QuestionRepo;
import com.vti.examwebsise.examonline.service.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    QuestionRepo questionRepo;

    @GetMapping("/users")
    public String viewAllUser(Model model){
        List<User> users = userRepo.findAll();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/questions")
    public String viewAllQuestion(Model model){
        List<Question> questions = questionRepo.findAll();
        model.addAttribute("questions",questions);
        return "questions";
    }
    @GetMapping("/question/new")
    public String newQuestion(Model model){
        model.addAttribute("question",new Question());
        return "question_form";
    }
}
