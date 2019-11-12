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
                * �û�����
     * 
     * **/
	//1���û�ע��
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
	//2����ѯ�����û����û��б�
	@RequestMapping(value="us_findusall.do")
	public String findLoAll(HttpServletRequest request, HttpServletResponse response) {
		List<login> lost=diIBiz.findLoAll();//ѧ������
		Map<String,Object> map=new HashMap<String,Object>();
		int maxrows=lost.size();
		System.out.println("ttttttttt:"+maxrows);
		map.put("rows",lost);
		map.put("total", maxrows);
		String jsonstr=JSONObject.toJSONString(map);
		AjAxUtils.printString(response, jsonstr);
		return null;
	}
	//3���û���¼
	@RequestMapping(value="us_log.do")
	public String findunup(HttpServletRequest request, HttpServletResponse response, login lo) {
		login us=diIBiz.findunup(lo);
		if(us!=null){
			int jur=Integer.parseInt(us.getJur());
			if(jur>1&&jur<20){
				AjAxUtils.printString(response, ""+2);//��ͨ����Ա���ɽ�����ɾ�Ĳ�
			  }else if(jur>20){
				  AjAxUtils.printString(response, ""+3);//��������Ա
			  }else{
				  AjAxUtils.printString(response, ""+1);//ֻ�ܽ��в鿴
			  }
		}else{
			AjAxUtils.printString(response, ""+10);
		}
		
		return null;
	}
	//4���޸�����1������ԭ�û��������룬���ƥ��ɹ������ظ�����¼��ID
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
	//5���޸�����2������ID�޸�����
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
	//6��ͨ��ѧ����������һ������(�鿴�ɼ�)
	@RequestMapping(value="sc_fbna.do")
	public String FindByNa(HttpServletRequest request, HttpServletResponse response, String sname) {
		System.out.println("//6��ͨ��ѧ����������һ������(�鿴�ɼ�)");
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
	//7��ͨ��ID��Ȩ��
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
	//8������IDɾ�û�
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
	//9����������1������ԭ�û��������ƥ��ɹ������ظ�����¼��id���ܱ�����  
	
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
	//10����������2�������ܱ��𰸣����ƥ��ɹ������ظ�����¼��id
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
	//11����������3������ID�޸�����
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
	 * �ɼ�����
	 * **/
	
	//1������ѧ������ͼƬ�ϴ��ģ�
	@RequestMapping(value="st_add.do")
	public String addst(HttpServletRequest request, HttpServletResponse response, Student st) {
		//��ȡ��·��
		String path=request.getRealPath("/");
		//��ȡ�ڴ��е���Ƭ����
		MultipartFile mu=st.getPic();
		if(mu!=null&&!mu.isEmpty()){
			//��ȡ�ϴ��ļ�����
			String pna=mu.getOriginalFilename();
			//����
			if(pna.lastIndexOf(".")!=-1){//���ں�׺
				String ext=pna.substring(pna.lastIndexOf("."));//��ȡ��׺
				//�жϺ�׺
				if(ext.equalsIgnoreCase(".jpg")){
					//������
					String newpname=new Date().getTime()+ext;
					//�����ļ�����ָ��·������ʵ����һ����ָ��·���µĿյ�ͼƬ�ļ���
					File fi=new File(path+ "/picture/" +newpname);
					st.setSpicture(newpname);
					try {
						//���ļ������Ƶ��ļ�������
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
	//2�����ӳɼ�
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
	//3����
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
	//4��ɾ
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
	//5������ͼһ��
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
	//6������ͼ���У���ʱ���ã�
	@Override
	public String FindAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	//7��������ѧ��/�γ̣��ϲ���
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
	//8�������пγ̣���ʱ���ã�
	@RequestMapping(value="le_findleall.do")
	public String FindLeAll(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	/**
	 * ��ҳ--չʾ�������У�
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
	 * dataGrid�ܹ����ܵ�keyֻ����������:
	 * total����������
     * rows�����ص�����
	 * **/


}
