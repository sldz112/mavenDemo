package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class Student {//定义学生类（学生表）
private String stuid;
private String sname;
private String sclazz;
private String spicture;
private MultipartFile pic;
public Student(String stuid, String sname, String sclazz, String spicture) {
	super();
	this.stuid = stuid;
	this.sname = sname;
	this.sclazz = sclazz;
	this.spicture = spicture;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String stuid, String sname, String sclazz, String spicture, MultipartFile pic) {
	super();
	this.stuid = stuid;
	this.sname = sname;
	this.sclazz = sclazz;
	this.spicture = spicture;
	this.pic = pic;
}
public String getStuid() {
	return stuid;
}
public void setStuid(String stuid) {
	this.stuid = stuid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSclazz() {
	return sclazz;
}
public void setSclazz(String sclazz) {
	this.sclazz = sclazz;
}
public String getSpicture() {
	return spicture;
}
public void setSpicture(String spicture) {
	this.spicture = spicture;
}
public MultipartFile getPic() {
	return pic;
}
public void setPic(MultipartFile pic) {
	this.pic = pic;
}
}
