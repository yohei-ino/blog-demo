package com.ino.blogdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ino.blogdemo.form.BlogForm;
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
    
    @RequestMapping(value = "/blog/post")
    public String blogPost(Model model) {
    	BlogForm blogForm = new BlogForm();
    	model.addAttribute("blogForm", blogForm);
    	return "/blog/post";
    }
    
    @RequestMapping(value = "/blog/confirm")
    public String blogConfirm(BlogForm form, Model model) {
    	model.addAttribute("blogForm", form);
    	return "/blog/confirm";
    }
    
    @RequestMapping(value = "/blog/detail/{id}")
    public String blogDetail(@PathVariable("id") int id, Model model) {
    	/** DBより記事の詳細な情報を取得 */
    	Map<String, Object> blogDetail = blogService.getBlogDetail(id);
    	model.addAttribute("blogDetail", blogDetail);
    	return "/blog/detail";
    }
    
}
