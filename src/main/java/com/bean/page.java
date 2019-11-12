package com.bean;

import java.util.List;

/***
 * 分页实体类
 * 
 * */
public class page {
private int page=1;//当前页(初始设置等于一)
private int maxPage;//最大页数
private int rows=5;//每页展示数据条数（初始设置等于5）
private List<?> pagelist;//分页查询展示的记录集合
public page() {
	super();
	// TODO Auto-generated constructor stub
}
public page(int page, int maxPage, int rows, List<?> pagelist) {
	super();
	this.page = page;
	this.maxPage = maxPage;
	this.rows = rows;
	this.pagelist = pagelist;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getMaxPage() {
	return maxPage;
}
public void setMaxPage(int maxPage) {
	this.maxPage = maxPage;
}
public int getRows() {
	return rows;
}
public void setRows(int rows) {
	this.rows = rows;
}
public List<?> getPagelist() {
	return pagelist;
}
public void setPagelist(List<?> pagelist) {
	this.pagelist = pagelist;
}

}
