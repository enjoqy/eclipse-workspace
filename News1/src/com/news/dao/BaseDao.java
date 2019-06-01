package com.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.util.ConfigManager;

public class BaseDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 创建连接的公共方法
	public void getConnection() {
//		使用属性文件
		String driver = ConfigManager.getConfigManager().getValue("driver");
		String url = ConfigManager.getConfigManager().getValue("url");
		String username = ConfigManager.getConfigManager().getValue("username");
		String password = ConfigManager.getConfigManager().getValue("password");
		try {
			// 1.加载数据库驱动
			Class.forName(driver);
			// 2.创建连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭资源的公共方法
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	增删改的公共方法
//	insert into news(title,content,author,type,st) values (?,?,?,?,1)
//	object{a,b,c,d}
	public Integer update(String sql,Object[] obj){
		Integer i = 0;
		this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
//			循环添加参数
			for(int j=0; j<obj.length; j++){
				pstmt.setObject(j+1, obj[j]);
			}
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
//	查询的公共方法
	public ResultSet select(String sql,Object[] obj){
		this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			for(int j=0; j<obj.length; j++){
				pstmt.setObject(j+1, obj[j]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
