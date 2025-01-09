<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h3 {
		text-align: center
	}
	.header{
		font-size: 36px; /* 폰트 사이즈 크게 설정 */
 		font-family: 'Arial', sans-serif; /* 원하는 폰트로 설정 (예: Arial) */
  		color: #D2B48C; /* 연한 갈색 색상 설정 (#D2B48C는 연한 갈색 코드) */
	}
	.menu{
		text-align: right;
	}
	.footer{
		font-size: 18px; /* 폰트 크기 설정 */
  		font-family: 'Verdana', sans-serif; /* 원하는 폰트로 설정 (예: Verdana) */
  		color: #FFB6C1; /* 연핑크 색상 설정 */
	}
	.main {
	    text-align: center; /* 텍스트 가운데 정렬 */
	    margin: 15px; /* 외부 여백을 15px로 설정 */
	    padding-bottom : 50px
	}
	.login{
		
	}
</style>
</head>
<body>
	<h3 class="header">CRAE LAB</h3><hr>
	<div class=menu>
		<a href="${contextPath}">home</a>
		<a href="memberinfo">회원정보</a>
		<c:choose>
			<c:when test="${login != null}">
			 	<a href="logout">logout</a>
			 </c:when>
			<c:otherwise>
				<a href="${contextPath}/login">login</a>
			</c:otherwise>
		</c:choose>
		<hr>
	</div>
	
</body>
</html>