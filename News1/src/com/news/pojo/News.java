package com.news.pojo;
/**
 * 新闻实体类
 * @author Ted
 *
 */
public class News {
	private Integer id;
	private String title;
	private String content;
	private String author;
	private String type;
	private Integer st;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSt() {
		return st;
	}
	public void setSt(Integer st) {
		this.st = st;
	}
	
}
