package com.bean;

import java.util.List;

/***
 * ��ҳʵ����
 * 
 * */
public class page {
private int page=1;//��ǰҳ(��ʼ���õ���һ)
private int maxPage;//���ҳ��
private int rows=5;//ÿҳչʾ������������ʼ���õ���5��
private List<?> pagelist;//��ҳ��ѯչʾ�ļ�¼����
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
