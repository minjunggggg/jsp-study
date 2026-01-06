<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="<%=request.getContextPath()%>/join" method="post">
		아이디: <input type="text" name="id" required><br> <br>
		비밀번호: <input type="password" name="pw" required><br> <br>
		이름: <input type="text" name="name" required><br> <br>

		<button type="submit">가입</button>
		<a href="<%=request.getContextPath()%>/login.jsp">로그인</a>

	</form>
</body>
</html>