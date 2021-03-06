package com.ino.blogdemo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ino.blogdemo.mapper.BlogMapper;

@Service
public class BlogService {
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Transactional
    public List<Map<String, Object>> getBlogList() {
		List<Map<String, Object>> blogList = blogMapper.getBlogList();
    	return blogList;
    }
	
	@Transactional
	public Map<String, Object> getBlogDetail(int id) {
		Map<String, Object> obj = blogMapper.getBlogDetail(id);
		return obj;
	}
	
	@Transactional
	public void insert(String title, String content) {
		blogMapper.insert(title, content);
	}
	
}
