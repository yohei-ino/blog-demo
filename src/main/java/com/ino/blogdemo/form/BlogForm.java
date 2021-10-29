package com.ino.blogdemo.form;

import lombok.Data;

@Data
public class BlogForm {
	/** 記事タイトル */
    private String title;
    /** 投稿内容 */
    private String content;
}
