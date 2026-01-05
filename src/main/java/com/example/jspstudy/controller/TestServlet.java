package com.example.jspstudy.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestServlet {
	public static void main(String[] args) {
        System.out.println("테스트 출력");

		String url = "jdbc:mysql://localhost:3306/jspstudy?serverTimezone=UTC";
		String user = "root";
		String password = "root1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("✅ DB 연결 성공!");
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
