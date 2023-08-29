package com.ktxdev.memoics.controller;

import com.ktxdev.memoics.dtos.UserDto;
import com.ktxdev.memoics.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "users/register";
    }

    @PostMapping("register")
    public String register(@Valid UserDto userDto, Errors errors) {
        if (errors.hasErrors()) {
           return  "users/register";
        }

        userService.register(userDto);
        return "redirect:/login";
    }
}
