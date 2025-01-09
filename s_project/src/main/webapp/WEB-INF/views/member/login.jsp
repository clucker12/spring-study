<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../default/header.jsp" %>
	<h3>로그인 페이지 입니다</h3> <br>
	<form action="logincheck" method="post">
		<input type="text" name="id"> <br>
		<input type="password" name="pwd"> <br>
		<input type="submit" value="로그인"> <br>
	</form>
	<a href="register">회원가입</a>
	<%@ include file="../default/footer.jsp" %>
</body>
</body>
</html>