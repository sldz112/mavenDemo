package com.bean;
//用户登录表(douser)
public class login {
private String uid;
private String uname;
private String upw;
private String jur;
private String ques;
private String ans;
public login(String uid, String uname, String upw, String jur, String ques, String ans) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.upw = upw;
	this.jur = jur;
	this.ques = ques;
	this.ans = ans;
}
//用于用户注册的构造方法
public login(String uname, String upw, String ques, String ans) {
	super();
	this.uname = uname;
	this.upw = upw;
	this.ques = ques;
	this.ans = ans;
}
//用于登录的构造方法
public login(String uname, String upw) {
	super();
	this.uname = uname;
	this.upw = upw;
}



//用于修改密码的构造方法
public login(String uid, String uname, String upw) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.upw = upw;
}

public login() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUpw() {
	return upw;
}
public void setUpw(String upw) {
	this.upw = upw;
}
public String getJur() {
	return jur;
}
public void setJur(String jur) {
	this.jur = jur;
}
public String getQues() {
	return ques;
}
public void setQues(String ques) {
	this.ques = ques;
}
public String getAns() {
	return ans;
}
public void setAns(String ans) {
	this.ans = ans;
}

}
