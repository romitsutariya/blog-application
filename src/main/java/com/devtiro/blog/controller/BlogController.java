package com.devtiro.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BlogController {
    @GetMapping(path = {"/check"})
    public String check(){
        return "Application is up and running...!";
    }

    @GetMapping(path = {"/greeting"})
    public String greeting(){
        return "Ready!!!";
    }

}
