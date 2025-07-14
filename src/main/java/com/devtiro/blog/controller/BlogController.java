package com.devtiro.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

    @GetMapping("/host")
    public String getHost(){
        try {
           return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unknown Host";
        }
    }

}
