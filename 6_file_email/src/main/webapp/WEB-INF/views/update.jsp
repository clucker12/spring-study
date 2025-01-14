<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>파일 수정</h3>
    <form action="${contextPath}/update" method="post" enctype="multipart/form-data">
        <input type="text" name="id" value="${id}" readonly="readonly"> <br>
        <input type="text" name="name" value="${name}"> <br>
        
        <!-- 기존 파일명 표시 -->
        <input type="hidden" name="filename" value="${filename}">
        <p>현재 파일: ${filename}</p>
        
        <!-- 새 파일을 선택하는 input 필드 -->
        <input type="file" name="file"> <br>

        <input type="submit" value="수정"> <br>
    </form>
    <hr>
    <a href="${contextPath}/views">목록 보기</a>
</body>
</html>