package com.example.jspstudy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private final String URL = "jdbc:mysql://localhost:3306/jspstudy?serverTimezone=UTC";
	private final String USER = "root";
	private final String PASSWORD = "root1234";

	// 로그인 체크
	public boolean login(String id, String pw) {
		String sql = "SELECT id FROM users WHERE id = ? AND password = ?";
		try {
			//	드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			//	DB 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//	SQL 준비
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			//	실행
			ResultSet rs = pstmt.executeQuery();
	        System.out.println("SQL 실행: id=" + id + ", pw=" + pw);

			boolean result = rs.next();
	        System.out.println("로그인 결과 = " + result);

			//	자원 정리
			rs.close();
			pstmt.close();
			conn.close();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
