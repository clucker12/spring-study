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
	<table border="3">
		<tr>
			<th>id</th>
			<th>password</th>
			<th>name</th>
		</tr>
		<c:if test="${list.size() != 0 }">
			<c:forEach var = "d" items="${list }">
				<tr>
					<td>${d.id }</td>
					<td>${d.pwd }</td>
					<td>${d.name }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${list.size() == 0 }">
			<tr>
				<td colspan="3"><b>데이터 없음</b></td>
			</tr>
			
		</c:if>	
		<tr>
				<td colspan="3"><a href="/member/index">index 이동</a></td>
		</tr>
	</table>
</body>
</html>