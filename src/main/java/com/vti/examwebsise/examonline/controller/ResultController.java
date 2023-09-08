package com.vti.examwebsise.examonline.controller;

import com.vti.examwebsise.examonline.entity.Answer;
import com.vti.examwebsise.examonline.entity.Exam;
import com.vti.examwebsise.examonline.entity.Question;
import com.vti.examwebsise.examonline.entity.User;
import com.vti.examwebsise.examonline.service.ExamRepo;
import com.vti.examwebsise.examonline.service.TopicRepo;
import com.vti.examwebsise.examonline.service.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/results")
public class ResultController {
    @Autowired
    ExamRepo examRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("")
    public String getAllResult(Model model, HttpServletRequest request){
        String username = request.getUserPrincipal().getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("exams",user.getExams());
        return "exam/results";
    }

    @GetMapping("/get/{id}")
    public String getResult(@PathVariable("id")Integer id, Model model){
        Exam exam = examRepo.getById(id);
//        Map<Question, Answer> myMap = new LinkedHashMap<>();
//        for(Answer a: exam.getAnswers()){
//            myMap.put(a.getQuestion(), a);
//        }
        model.addAttribute("result",exam);
        model.addAttribute("mark",exam.getMark());
        return "exam/result";
    }
}
