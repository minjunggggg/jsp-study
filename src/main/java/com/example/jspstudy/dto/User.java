package com.example.jspstudy.dto;

public class User {
//	1. 변수(데이터 넣는 칸)
	private String id;
	private String password;
	private String name;

//	2. id 꺼내고 넣기
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	3. password 꺼내고 넣기
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	4. name 꺼내고 넣기
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
