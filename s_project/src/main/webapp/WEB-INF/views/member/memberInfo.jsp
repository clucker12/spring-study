<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원정보</h3>
	<table border="1px">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>주소</th>
		</tr>
		<c:forEach  var="dto" items="${list }">
			<tr>
				<td><a href="info?id=${dto.id.replace(' ', '_')}">${dto.id}</a></td>
				<td>${dto.pwd }</td>
				<td>${dto.addr }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>