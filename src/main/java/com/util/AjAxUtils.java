package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.serializer.PropertyFilter;

public class AjAxUtils {
	/**
	 * ������Ӧ���ͻ���
	 * */
	public static void printString(HttpServletResponse response,String s){
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		
		try {
			out=response.getWriter();
			out.print(s);//�����Ӧ
			
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * ��������,
	 * 
	 * ��ֹ����õ��ǽ����ӳ�������ѭ��������Ϊfastjion��ɨ�貢�Զ���������JSON��ʽ�ģ�����֮ǰ�������У�studentʵ��������һ��clazz���󣬶�clazzʵ��������һ��student����
	 * ��ʱ�������fastjsonɨ��������ѭ����
	 * */
	//���������Ի������಻��  ���̶�д����
	public static PropertyFilter filterProperts(final String...propNames){
		PropertyFilter propertyFilter=new PropertyFilter() {
			
			public boolean apply(Object arg0, String propertyName, Object arg2) {
				for (String pname : propNames) {
					if(propertyName.equals(pname)){
						return false;//����
					}
				}
				return true;
			}
		};
		
		return propertyFilter;
	}
	
	
	
	
	
	
}