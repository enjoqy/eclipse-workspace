package com.news.util;
/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageUtil {
	
//	当前页码
	private Integer pageIndex; 
	
//	数据总数
	private Integer count;
	
//	每页显示数据量
	private Integer pageSize;
	
//	总页数
	private Integer pageCount;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount() {
		if((count % pageSize) == 0){
			this.pageCount = count / pageSize;
		}else{
			this.pageCount = count / pageSize + 1;
		}
	}
	
	
}
