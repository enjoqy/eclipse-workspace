package com.news.service;

import java.util.List;

import com.news.pojo.News;

/**
 * 新闻管理改造 service层
 * @author Administrator
 *
 */
public interface NewsService {
//	查看所有新闻方法
	public List<News> getNewsList();
	
//	根据ID查看新闻
	public News getNewsById(Integer id);
	
//	添加新闻
	public boolean addNews(News news);
	
//	删除新闻
	public boolean delNews(Integer id);
	
//	修改新闻
	public boolean updateNews(News news);
	
//	获得新闻总数
	public Integer getNewsCount();
	
//	分页查询新闻
	public List<News> getNewsByPage(Integer pageIndex,Integer pageSize);
}
