package com.example.jspstudy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.jspstudy.dto.User;

public class UserDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/jspstudy?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root1234";

	// 로그인 체크
	public User login(String id, String pw) {
		User user = null;
		String sql = "SELECT * FROM users WHERE id = ? AND password = ?";

		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// SQL 준비
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			// 실행
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
			}

			// 자원 정리
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	// 아이디 중복 체크
	public boolean isIdExists(String id) {
		boolean exists = false;
		String sql = "SELECT id FROM users WHERE id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				exists = true;
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exists;
	}

	// 회원가입 저장
	public boolean insertUser(User user) {
		boolean success = false;
		String sql = "INSERT INTO users (id, password, name) VALUES (?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				success = true;
			}

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
}
