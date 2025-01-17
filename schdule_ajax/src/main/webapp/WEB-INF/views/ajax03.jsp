<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getTest() {
		console.log(111)
		$.ajax({
			url : "rest", type : "get",
			dataType : "json",
			success : function(data) {
				$("#span").html(data.key)
			}, error : function() {
				console.log("문제 발생")
			}
		})
	}
	
	function postTest() {
		console.log(111)
		$.ajax({
			url : "rest", type : "post",
			dataType : "json",
			success : function(data) {
				$("#span").html(data.key)
			}, error : function() {
				console.log("문제 발생")
			}
		})
	}
	
	function putTest() {
		console.log(111)
		$.ajax({
			url : "rest", type : "put",
			dataType : "json",
			success : function(data) {
				$("#span").html(data.key)
			}, error : function() {
				console.log("문제 발생")
			}
		})
	}
	
	function deleteTest() {
		console.log(111)
		$.ajax({
			url : "rest", type : "delete",
			dataType : "json",
			success : function(data) {
				$("#span").html(data.key)
			}, error : function() {
				console.log("문제 발생")
			}
		})
	}
</script>

</head>
<body>
	<span id="span"></span> <hr>
	<button onclick="getTest()">getTest</button>
	<button onclick="postTest()">postTest</button>
	<button onclick="putTest()">putTest</button>
	<button onclick="deleteTest()">deleteTest</button>
</body>
</html>

























