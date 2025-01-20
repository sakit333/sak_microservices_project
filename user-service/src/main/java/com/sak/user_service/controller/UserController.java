package com.sak.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sak.user_service.repository.UserRepository;

import com.sak.user_service.entity.User;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @GetMapping("/signup") 
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup.html";
    }

    @PostMapping("/signup")
    public User signupUser(@ModelAttribute User user) {
        return UserRepository.save(user);
    }
}
