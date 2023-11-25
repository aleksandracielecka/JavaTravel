package com.example.javatravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
        @GetMapping("/")
        public String greeting() {
            return "index";
        }
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
