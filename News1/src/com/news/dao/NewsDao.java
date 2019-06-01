package com.news.dao;

import java.util.List;

import com.news.pojo.News;

public interface NewsDao {
//	查询所有新闻
	public List<News> getNewsList();
	
//	添加新闻
	public Integer addNews(News news);
	
//	删除新闻
	public Integer delNews(Integer id);
	
//	根据ID查询新闻
	public News getNewsById(Integer id);
	
//	修改新闻
	public Integer updateNews(News news);

//	获得数据总量
	public Integer getNewsCount();
	
//	分页查询新闻
	public List<News> getNewsByPage(Integer from,Integer pageSize);
}
