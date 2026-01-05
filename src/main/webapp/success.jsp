<%@ page contentType="text/html; charset=UTF-8"%>
<%
String loginId = (String) session.getAttribute("loginId");
if (loginId == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>로그인 성공</title>
</head>

<body>
	<h2>로그인 성공!</h2>
	<p>
		<b><%=loginId%></b>님 환영합니다.
	</p>

	<a href="logout.jsp">로그아웃</a>
</body>
</html>