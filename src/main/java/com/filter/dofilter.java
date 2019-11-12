package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class dofilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("过滤器销毁。。。。。");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器正在工作。。。。");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//通过上下文关系对象把请求和响应扔出去给容器
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化。。。。。");
		
	}

}
