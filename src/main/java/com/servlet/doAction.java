package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.bean.Lession;
import com.bean.Score;
import com.bean.Student;
import com.bean.login;
import com.bean.page;
import com.biz.IBiz;
import com.util.AjAxUtils;
@Controller
public class doAction implements IAction {
    @Resource(name="doIBiz")
	private IBiz diIBiz;
    
	public IBiz getDiIBiz() {
		return diIBiz;
	}

	public void setDiIBiz(IBiz diIBiz) {
		this.diIBiz = diIBiz;
	}
    /**
                * 用户管理
     * 
     * **/
	//1、用户注册
	@RequestMapping(value="us_add.do")
	public String doadd(HttpServletRequest request, HttpServletResponse response, login lo) {
		boolean flag=diIBiz.doadd(lo);
		if(flag) {
			AjAxUtils.printString(response, ""+1);
		}else {
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//2、查询所有用户（用户列表）
	@RequestMapping(value="us_findusall.do")
	public String findLoAll(HttpServletRequest request, HttpServletResponse response) {
		List<login> lost=diIBiz.findLoAll();//学生集合
		Map<String,Object> map=new HashMap<String,Object>();
		int maxrows=lost.size();
		System.out.println("ttttttttt:"+maxrows);
		map.put("rows",lost);
		map.put("total", maxrows);
		String jsonstr=JSONObject.toJSONString(map);
		AjAxUtils.printString(response, jsonstr);
		return null;
	}
	//3、用户登录
	@RequestMapping(value="us_log.do")
	public String findunup(HttpServletRequest request, HttpServletResponse response, login lo) {
		login us=diIBiz.findunup(lo);
		if(us!=null){
			int jur=Integer.parseInt(us.getJur());
			if(jur>1&&jur<20){
				AjAxUtils.printString(response, ""+2);//普通管理员，可进行增删改查
			  }else if(jur>20){
				  AjAxUtils.printString(response, ""+3);//超级管理员
			  }else{
				  AjAxUtils.printString(response, ""+1);//只能进行查看
			  }
		}else{
			AjAxUtils.printString(response, ""+10);
		}
		
		return null;
	}
	//4、修改密码1，输入原用户名，密码，如果匹配成功，返回该条记录的ID
	@RequestMapping(value="us_update1.do")
	public String useupdate1(HttpServletRequest request, HttpServletResponse response, login lo) {
		login us=diIBiz.useupdate1(lo);
		String jsonstr=JSONObject.toJSONString(us);
		System.out.println("11111111111:"+jsonstr);
		if(us!=null){
			AjAxUtils.printString(response, jsonstr);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//5、修改密码2，根据ID修改密码
	@RequestMapping(value="us_update2.do")
	public String useupdate2(HttpServletRequest request, HttpServletResponse response, login lo) {
		boolean flag=diIBiz.useupdate2(lo);
		if(flag) {
			AjAxUtils.printString(response, ""+1);
		}else {
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//6、通过学生姓名查找一个集合(查看成绩)
	@RequestMapping(value="sc_fbna.do")
	public String FindByNa(HttpServletRequest request, HttpServletResponse response, String sname) {
		System.out.println("//6、通过学生姓名查找一个集合(查看成绩)");
		List<Score> lsc=diIBiz.FindByNa(sname);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lsc", lsc);
		if(lsc!=null&&lsc.size()>0){
		String jsonstr=JSONObject.toJSONString(map);
		AjAxUtils.printString(response, jsonstr);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//7、通过ID改权限
	@RequestMapping(value="us_updatejur.do")
	public String updatejur(HttpServletRequest request, HttpServletResponse response, String uid) {
		boolean flag=diIBiz.updatejur(uid);
		if(flag) {
			AjAxUtils.printString(response, ""+1);
		}else {
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//8、根据ID删用户
	@RequestMapping(value="us_del2.do")
	public String del2(HttpServletRequest request, HttpServletResponse response, String uid) {
		boolean flag=diIBiz.del2(uid);
		if(flag) {
			AjAxUtils.printString(response, ""+1);
		}else {
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//9、忘记密码1，输入原用户名，如果匹配成功，返回该条记录的id和密保问题  
	
	@RequestMapping(value="us_fopw1.do")
	public String fogotpw1(HttpServletRequest request, HttpServletResponse response, login lo) {
		login us=diIBiz.fogotpw1(lo);
		String jsonstr=JSONObject.toJSONString(us);
		if(us!=null){
			AjAxUtils.printString(response, jsonstr);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//10、忘记密码2，输入密保答案，如果匹配成功，返回该条记录的id
	@RequestMapping(value="us_fopw2.do")
	public String fogotpw2(HttpServletRequest request, HttpServletResponse response, login lo) {
		login us=diIBiz.fogotpw2(lo);
		String jsonstr=JSONObject.toJSONString(us);
		if(us!=null){
			AjAxUtils.printString(response, jsonstr);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//11、忘记密码3，根据ID修改密码
	@RequestMapping(value="us_fopw3.do")
	public String fogotpw3(HttpServletRequest request, HttpServletResponse response, login lo) {
		boolean flag=diIBiz.fogotpw3(lo);
		if(flag) {
			AjAxUtils.printString(response, ""+1);
		}else {
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}

	
	
	/**
	 * 成绩管理
	 * **/
	
	//1、增加学生（带图片上传的）
	@RequestMapping(value="st_add.do")
	public String addst(HttpServletRequest request, HttpServletResponse response, Student st) {
		//获取根路径
		String path=request.getRealPath("/");
		//获取内存中的照片对象
		MultipartFile mu=st.getPic();
		if(mu!=null&&!mu.isEmpty()){
			//获取上传文件名称
			String pna=mu.getOriginalFilename();
			//改名
			if(pna.lastIndexOf(".")!=-1){//存在后缀
				String ext=pna.substring(pna.lastIndexOf("."));//截取后缀
				//判断后缀
				if(ext.equalsIgnoreCase(".jpg")){
					//新名字
					String newpname=new Date().getTime()+ext;
					//创建文件对象，指定路径（其实就是一个在指定路径下的空的图片文件）
					File fi=new File(path+ "/picture/" +newpname);
					st.setSpicture(newpname);
					try {
						//将文件流复制到文件对象中
						FileUtils.copyInputStreamToFile(mu.getInputStream(), fi);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		boolean flag=diIBiz.addst(st);
		if(flag){
			AjAxUtils.printString(response, ""+1);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//2、增加成绩
	@RequestMapping(value="sc_add.do")
	public String add(HttpServletRequest request, HttpServletResponse response, Score sc) {
		boolean flag=diIBiz.add(sc);
		if(flag){
			AjAxUtils.printString(response, ""+1);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//3、改
	@RequestMapping(value="sc_up.do")
	public String update(HttpServletRequest request, HttpServletResponse response, Score sc) {
		boolean flag=diIBiz.update(sc);
		if(flag){
			AjAxUtils.printString(response, ""+1);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//4、删
	@RequestMapping(value="sc_delSc.do")
	public String del(HttpServletRequest request, HttpServletResponse response, String scoid) {
		boolean flag=diIBiz.del(scoid);
		if(flag){
			AjAxUtils.printString(response, ""+1);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//5、查视图一条
	@RequestMapping(value="sc_findsc.do")
	public String FindById(HttpServletRequest request, HttpServletResponse response, String scoid) {
		Score sc=diIBiz.FindById(scoid);
		String jsonstr=JSONObject.toJSONString(sc);
		if(sc!=null){
			AjAxUtils.printString(response, jsonstr);
		}else{
			AjAxUtils.printString(response, ""+0);
		}
		return null;
	}
	//6、查视图所有（暂时无用）
	@Override
	public String FindAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	//7、查所有学生/课程（合并）
	@RequestMapping(value="st_findstleall.do")
	public String FindStAll(HttpServletRequest request, HttpServletResponse response) {
		List<Student> lst=diIBiz.FindStAll();
		List<Lession> les=diIBiz.FindLeAll();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("lst", lst);
		map.put("les", les);
		String jsonstr=JSONObject.toJSONString(map);
		System.out.println(jsonstr);
		AjAxUtils.printString(response, jsonstr);
		
		return null;
	}
	//8、查所有课程（暂时无用）
	@RequestMapping(value="le_findleall.do")
	public String FindLeAll(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	/**
	 * 分页--展示（查所有）
	 * **/
	@RequestMapping(value="sc_page.do")
	public String maxrows(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		page pa=new page();
		page=(page==null||page<1?page=pa.getPage():page);
		rows=(rows==null||rows<1?rows=pa.getRows():rows);
		int maxrows=diIBiz.maxPage(rows);
		if(rows>10) rows=10;
		List<Score> lsc=diIBiz.findPageList(page, rows);
		map.put("page", page);
		map.put("rows", lsc);
		map.put("total",maxrows);
		String jsonstr=JSONObject.toJSONString(map);
		AjAxUtils.printString(response, jsonstr);
		return null;
	}
	/**
	 * dataGrid能够接受的key只有下面两个:
	 * total：数据总数
     * rows：返回的数据
	 * **/


}
