package com.example.javatravel.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("userRoles", SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .toString());
        return "home";
    }
//rejestracja nowego usera @PostMapping
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/client")
    public String client() {
        return "client";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
