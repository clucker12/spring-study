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
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:if test="${list.size() != 0 }">
			<c:forEach var = "d" items="${list }">
				<tr>
					<td>${d.name }</td>
					<td>${d.age }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${list.size() == 0 }">
			<tr>
				<td colspan="2"><b>목록 없음</b></td>
			</tr>
			
		</c:if>	
	</table>
<hr>
	<c:if test="${list.size() != 0 }">
		목록들 존재
	</c:if>
	<c:if test="${list.size() == 0 }">
		목록 없음
	</c:if>

	size : ${ list.size() }
	
<hr>
	jstl페이지 <br>
	num : ${num } <br>
	<c:if test="${num >= 100}">
		100과 같거나 크다 <br>
	</c:if>
	<c:if test="${num > 80}">
		80보다 크다 <br>
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${num >= 100}"> 100<br></c:when>
		<c:when test="${num > 80}">  80<br></c:when>
		<c:otherwise>else문</c:otherwise>
	</c:choose>
	<hr>
	<c:forEach var="i" begin="10" end="16" step="2">
		${i },
	</c:forEach>
</body>
</html>