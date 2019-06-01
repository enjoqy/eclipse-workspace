package com.news.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.BaseDao;
import com.news.dao.NewsDao;
import com.news.pojo.News;
import com.news.util.ConfigManager;

public class NewsDaoImpl implements NewsDao {
	BaseDao baseDao = new BaseDao();
	// 查询新闻列表
	public List<News> getNewsList() {
		List<News> list = new ArrayList<News>();
		String sql = "select * from news where st = 1";
		Object[] obj = {};
		ResultSet rs = baseDao.select(sql, obj);
		try {
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setType(rs.getString("type"));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseDao.close();
		return list;
	}

	// 添加新闻
	public Integer addNews(News news) {
		String sql = "insert into news(title,content,author,type,st) values (?,?,?,?,1)";
		Object[] obj = {news.getTitle(),news.getContent(),news.getAuthor(),news.getType()};
		Integer i = baseDao.update(sql, obj);
		baseDao.close();
		return i;
	}

	public Integer delNews(Integer id) {
		String sql = "update news set st = 0 where id = ?";
		Object[] obj = {id};
		Integer i = baseDao.update(sql, obj);
		baseDao.close();
		return i;
	}

	public News getNewsById(Integer id) {
		News news = new News();
		String sql = "select * from news where id = ?";
		Object[] obj = {id};
		ResultSet rs = baseDao.select(sql, obj);
		try {
			while(rs.next()) {
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseDao.close();
		return news;
	}

	public Integer updateNews(News news) {
		String sql = "update news set title=?,content=?,"
				+" author=?,type=? where id = ?";
		Object[] obj = {news.getTitle(),news.getContent(),news.getAuthor(),news.getType(),news.getId()};
		Integer i = baseDao.update(sql, obj);
		baseDao.close();
		return i;
	}

//	获得数据总量
	public Integer getNewsCount() {
		String sql = "select count(1) from news where st = 1";
		Object[] obj = {};
		Integer count = 0;
		ResultSet rs = baseDao.select(sql, obj);
		try {
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseDao.close();
		return count;
	}

//	分页查询
	public List<News> getNewsByPage(Integer from,Integer pageSize) {
		List<News> list = new ArrayList<News>();
		String sql = "select * from news where st = 1"
				+ " limit ? ,?";
		Object[] obj = {from , pageSize};
		ResultSet rs = baseDao.select(sql, obj);
		try {
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setType(rs.getString("type"));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		baseDao.close();
		return list;
	}

}
