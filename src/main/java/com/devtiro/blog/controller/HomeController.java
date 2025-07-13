package com.devtiro.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
     @GetMapping
     public  String home(){
         return "<H1>Blog Application</h1>";
     }
}
