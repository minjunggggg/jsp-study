package com.example.jspstudy.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.jspstudy.dao.UserDAO;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		UserDAO dao = new UserDAO();
		boolean isLogin = dao.login(id, pw);

		if (isLogin) {
			HttpSession session = req.getSession();
			session.setAttribute("loginId", id);
			resp.sendRedirect("success.jsp");
		} else {
			resp.sendRedirect("login.jsp?error=1");
		}

	}
}
