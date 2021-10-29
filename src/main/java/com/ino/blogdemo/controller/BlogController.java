package com.ino.blogdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ino.blogdemo.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
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
    	/** DBより記事の一覧情報を取得 */
    	List<Map<String, Object>> blogList = blogService.getBlogList();
    	model.addAttribute("blogList", blogList);
    	return "/blog/index";
    }
    
}
