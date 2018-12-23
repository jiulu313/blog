package com.zhj.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }


}
