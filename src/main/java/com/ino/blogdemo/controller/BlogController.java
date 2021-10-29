package com.ino.blogdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@RequestMapping(value = "/")
    public String index() {
        return "redirect:home";
    }
	
    @RequestMapping(value = "/home")
    public String home() {
    	return "home";
    }
	
    @RequestMapping(value = "/blog")
    public String blog(Model model) {
    	return "/blog/index";
    }
    
}
