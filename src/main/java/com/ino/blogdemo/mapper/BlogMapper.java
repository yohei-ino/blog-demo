package com.ino.blogdemo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BlogMapper {
	
	/** 記事一覧の取得 */
	@Select("SELECT id, title, content FROM blog_contents")
	List<Map<String, Object>> getBlogList();
	
	/** 記事詳細の取得 */
	@Select("SELECT id, title, content FROM blog_contents WHERE id=#{id}")
	Map<String, Object> getBlogDetail(int id);
	
	/** 
	 *    記事の新規登録: BlogMapper.xmlにてSQL定義。MyBatisにより実装。
	 */
	void insert(String title, String content);
	
}
