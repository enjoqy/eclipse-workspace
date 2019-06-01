package com.news.service.impl;

import java.util.List;

import com.news.dao.NewsDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.pojo.News;
import com.news.service.NewsService;

public class NewsServiceImpl implements NewsService {
	NewsDao newsDao = new NewsDaoImpl();
	
	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}

	public News getNewsById(Integer id) {
		return newsDao.getNewsById(id);
	}

	public boolean addNews(News news) {
		if(newsDao.addNews(news) > 0){
			return true;
		}
		return false;
	}

	public boolean delNews(Integer id) {
		if(newsDao.delNews(id) > 0){
			return true;
		}
		return false;
	}

	public boolean updateNews(News news) {
		if(newsDao.updateNews(news) > 0){
			return true;
		}
		return false;
	}

//	获得新闻总数
	public Integer getNewsCount() {
		return newsDao.getNewsCount();
	}

//	分页查询
	public List<News> getNewsByPage(Integer pageIndex, Integer pageSize) {
		return newsDao.getNewsByPage((pageIndex - 1) * pageSize, pageSize);
	}

}
