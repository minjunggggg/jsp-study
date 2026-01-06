package com.example.jspstudy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jspstudy.dao.UserDAO;
import com.example.jspstudy.dto.User;

public class JoinServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 한글 깨짐 방지
		req.setCharacterEncoding("UTF-8");

		// 1. 파라미터 받기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");

		UserDAO dao = new UserDAO();

		// 2. 아이디 중복 체크
		if (dao.isIdExists(id)) {
			resp.sendRedirect("join.jsp?error=1");
			return;
		}

		// 3. DTO에 담기
		User user = new User();
		user.setId(id);
		user.setPassword(pw);
		user.setName(name);

		// 4. DB 저장
		boolean success = dao.insertUser(user);

		if (success) {
			resp.sendRedirect("login.jsp");
		} else {
			resp.sendRedirect("join.jsp?error=2");
		}
	}
}
