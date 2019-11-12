package com.bean;

public class Lession {//定义课程类（课程表）
private String lid;
private String lname;
public Lession(String lid, String lname) {
	super();
	this.lid = lid;
	this.lname = lname;
}
public Lession() {
	super();
	// TODO Auto-generated constructor stub
}
public String getLid() {
	return lid;
}
public void setLid(String lid) {
	this.lid = lid;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}

}
