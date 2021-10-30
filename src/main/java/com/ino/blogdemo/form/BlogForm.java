package com.ino.blogdemo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BlogForm {
	
	/** 記事タイトル */
	@NotBlank(message = "必須入力です")
	@Size(max = 5, message = "5文字以内で入力してください")
	private String title;
	
	
    /** 投稿内容 */
	@NotBlank(message = "必須入力です")
    private String content;
}
