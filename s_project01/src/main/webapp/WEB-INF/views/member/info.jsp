<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="/WEB-INF/views/default/header.jsp" %>
 id : ${member.id}<br>
 pwd : ${member.pwd}<br>
 addr : ${member.addr}<br>
</body>
</html>