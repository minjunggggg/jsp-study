<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h2>로그인</h2>

	<%
	if ("1".equals(request.getParameter("error"))) {
	%>
	<p style="color: red;">아이디 또는 비밀번호가 틀렸습니다.</p>
	<%
	}
	%>

	<form action="<%=request.getContextPath()%>/login" method="post">
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="password" name="pw"><br>
		<button type="submit">로그인</button>
		<a href="<%=request.getContextPath()%>/join.jsp">회원가입</a>
	</form>

</body>
</html>
