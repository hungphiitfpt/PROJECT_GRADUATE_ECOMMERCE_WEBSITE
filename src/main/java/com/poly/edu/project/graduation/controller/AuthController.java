package com.poly.edu.project.graduation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.edu.project.graduation.model.UserDto;
import com.poly.edu.project.graduation.model.UserEntity;
import com.poly.edu.project.graduation.services.UserService;

import java.util.List;

import javax.validation.Valid;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("indexok")
    public String home(){
        return "index";
    }

    @RequestMapping("/login")
    public String loginForm() {
        return "/admin-template/pages/samples/login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        UserEntity existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
     
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
    
            model.addAttribute("user", user);
            return "register";
        }
 
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
