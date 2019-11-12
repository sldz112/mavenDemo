package com.bean;

public class Score {//定义成绩表类（视图scview类），javaBean类
private String scoid;
private String score;
private String studentid;
private String lessionid;
private String sname;
private String sclazz;
private String spicture;
private String lname;
public Score() {
	super();
	// TODO Auto-generated constructor stub
}
public Score(String scoid, String score, String studentid, String lessionid, String sname, String sclazz,
		String spicture, String lname) {
	super();
	this.scoid = scoid;
	this.score = score;
	this.studentid = studentid;
	this.lessionid = lessionid;
	this.sname = sname;
	this.sclazz = sclazz;
	this.spicture = spicture;
	this.lname = lname;
}
public String getScoid() {
	return scoid;
}
public void setScoid(String scoid) {
	this.scoid = scoid;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
public String getLessionid() {
	return lessionid;
}
public void setLessionid(String lessionid) {
	this.lessionid = lessionid;
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
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}



}
