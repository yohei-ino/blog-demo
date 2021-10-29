package com.ino.blogdemo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogMapper {
	@Select("SELECT id, title, content FROM blog_contents")
	List<Map<String, Object>> getBlogList();
}
