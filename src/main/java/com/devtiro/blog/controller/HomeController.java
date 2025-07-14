package com.devtiro.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class HomeController {
     @GetMapping("/")
     public  String home(Model model){
         try {
             String hostname = InetAddress.getLocalHost().getHostName();
             model.addAttribute("hostname", hostname);
         } catch (UnknownHostException e) {
             model.addAttribute("hostname", "Unknown Host");
         }
         return "index";
     }
}
