package com.servlet;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Lession;
import com.bean.Score;
import com.bean.Student;
import com.bean.login;

/**
 * 
 * ���Ʋ�ӿ�
 * 
 * **/

public interface IAction {

	/***
	 * �û������ķ���
	 * */
	
	//1���û�ע��
	public String doadd(HttpServletRequest request, HttpServletResponse response, login lo);
	//2����ѯ�����û�
	public String findLoAll(HttpServletRequest request, HttpServletResponse response);
	//3���û���¼
	public String findunup(HttpServletRequest request, HttpServletResponse response, login lo);
	//4���޸�����1������ԭ�û��������룬���ƥ��ɹ������ظ�����¼��ID
	public String useupdate1(HttpServletRequest request, HttpServletResponse response, login lo);
	//5���޸�����2������ID�޸�����
	public String useupdate2(HttpServletRequest request, HttpServletResponse response, login lo);
	//6��ͨ��ѧ����������һ������
	public String FindByNa(HttpServletRequest request, HttpServletResponse response, String sname);
	//7��ͨ��ID��Ȩ��
	public String updatejur(HttpServletRequest request, HttpServletResponse response, String uid);
	//8������IDɾ�û�
	public String del2(HttpServletRequest request, HttpServletResponse response, String uid);
	//9����������1������ԭ�û��������ƥ��ɹ������ظ�����¼��id���ܱ�����
	public String fogotpw1(HttpServletRequest request, HttpServletResponse response, login lo);
	//10����������2�������ܱ��𰸣����ƥ��ɹ������ظ�����¼��id
	public String fogotpw2(HttpServletRequest request, HttpServletResponse response, login lo);
	//11����������3������ID�޸�����
	public String fogotpw3(HttpServletRequest request, HttpServletResponse response, login lo);
	
	/**
	 * �ɼ�����
	 * 
	 * **/
	//1������ѧ������ͼƬ�ϴ��ģ�
	public String addst(HttpServletRequest request, HttpServletResponse response, Student st);
	//2�����ӳɼ�
	public String add(HttpServletRequest request, HttpServletResponse response, Score sc);
	//3����
	public String update(HttpServletRequest request, HttpServletResponse response, Score sc);
	//4��ɾ
	public String del(HttpServletRequest request, HttpServletResponse response, String scoid);
	//5������ͼһ��
	public String FindById(HttpServletRequest request, HttpServletResponse response, String scoid);
	//6������ͼ����
	public String FindAll(HttpServletRequest request, HttpServletResponse response);
	//7��������ѧ��
	public String FindStAll(HttpServletRequest request, HttpServletResponse response);
	//8�������пγ�
	public String FindLeAll(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 *��ҳ 
	 *
	 * **/
	public String maxrows(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows);
	
}
