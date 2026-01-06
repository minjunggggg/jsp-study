package com.example.jspstudy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		System.out.println("요청 URI: " + uri);

		if (uri.contains("/login") || uri.contains("/join") || uri.contains("login.jsp") || uri.contains("join.jsp")
				|| uri.contains("/css") || uri.contains("/js")) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = req.getSession(false);
		Object loginUser = (session == null) ? null : session.getAttribute("loginUser");

	}

}
