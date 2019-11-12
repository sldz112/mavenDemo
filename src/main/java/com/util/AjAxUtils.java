package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.serializer.PropertyFilter;

public class AjAxUtils {
	/**
	 * 输入响应到客户端
	 * */
	public static void printString(HttpServletResponse response,String s){
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		
		try {
			out=response.getWriter();
			out.print(s);//输出响应
			
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * 过滤属性,
	 * 
	 * 防止如果用的是结果集映射出现死循环，（因为fastjion会扫描并自动将对象变成JSON格式的，比如之前的例子中，student实体类中有一个clazz对象，而clazz实体类中有一个student集合
	 * 这时候如果用fastjson扫描会出现死循环，
	 * */
	//方法名可以换，其余不行  【固定写法】
	public static PropertyFilter filterProperts(final String...propNames){
		PropertyFilter propertyFilter=new PropertyFilter() {
			
			public boolean apply(Object arg0, String propertyName, Object arg2) {
				for (String pname : propNames) {
					if(propertyName.equals(pname)){
						return false;//过滤
					}
				}
				return true;
			}
		};
		
		return propertyFilter;
	}
	
	
	
	
	
	
}
