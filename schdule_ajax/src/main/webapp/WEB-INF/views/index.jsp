<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getList() {
		$.ajax({
			url : "members", type : "get", dataType : "json",
			success : function(list) {
				console.log(list)
				//let html = "<b>아이디</b> : " + list[0].name + "<br>"
				//html += "<b>나이<b> : " + list[0].age
				let html = "";
				for(let i =  0; i < list.length; i++){
					html += "<b>아이디</b> : " +
					"<a onclick='getInfo(\""+ list[i].name+"\")'>"+ list[i].name+"</a><br>";
					html += "<b>나이</b> : " + list[i].age+"<hr>";
				}
				$("#list").html(html)
			}, error : function() {
				alert("문제 발생")
			}
		})
	}
	function getInfo(username) {
		// alert(username + "실행")
		$.ajax({
			url : "members/"+username, type : "get",dataType : "json",
			success : function(data) {
				console.log("info data : ", data);
				let html = "이름 : " + data.name + "<br>";
				html += "age : " +data.age + "<br>";
				html += "<button onclick = 'del(\""+username+"\")'> 삭제 </button>";
				html += "<button onclick = 'viewForm(\""+username+"\")'> 수정 </button>";
				$("#list").html(html)
			},
			error : function() {
				alert("문제발생");
			}
		})
	}
	function del(username) {
		// alert(username +"삭제")
		$.ajax({
			url : "members/"+username, type : "delete",dataType : "json",
			success : function(data) {
				console.log("삭제 data : ", data);
				if(data == 1){
					alert(username + "삭제 성공")
					getList()
				}else{
					alert(username + "삭제 실패!!!")
				}
			},
			error : function() {
				alert("문제발생");
			}
		})
	}
	function viewForm(username) {
		console.log("view : ",username)
		//<input type="text" id="id" name="id"> <br>
		//<input type="text" id="pwd" name="pwd"> <br>
		// <button onclick="reg()">가입</button>
		// </form>`;
		
		let html = `
			<form id="fr">
				
				<input type="text" id="name" name="name"> <br>
				<input type="text" id="age" name="age"> <br>
				
			
		
		if(username == undefined){
			//alert("회원가입")
		}else{
			alert("수정")
		}
		
		
		$("#list").html(html)
	}
</script>

</head>
<body>
	
	<span id="list"></span>
	<hr>
	<button onclick="getList()">모든 목록</button>
	<button onclick="viewForm()">회원가입</button>
</body>
</html>
















