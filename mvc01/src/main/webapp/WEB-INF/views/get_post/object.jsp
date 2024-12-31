<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	object페이지 <br>
	<!--member.name은 객체의 속성을 이용하는방법  -->
	name : ${member.name} <br>
	<!--member.getage는 메서드를 이용하는방법  -->
	age : ${member.getage()}<br>
	<a href="index">index이동</a>
</body>
</html>