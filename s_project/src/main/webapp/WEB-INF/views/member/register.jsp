<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원등록</h3> <br>
	<form action="memberinsert" method="post">
		<input type="text" name="id" placeholder="아이디"> <br>
		<input type="password" name="pwd" placeholder="비밀번호"> <br>
		<input type="text" name="addr" placeholder="주 소 "> <br>
		<input type="submit" value="회원가입"> <br>
	</form>
</body>
</html>