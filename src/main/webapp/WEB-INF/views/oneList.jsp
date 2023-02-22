<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
if(!${msg}==null}){
	alert(${msg});
}
function ckecked(){
	var regex = /^[A-Za-z0-9+]*$/; 
	var id = frm.id.value;
	var nickName = document.getElementById("nickName");
	var pwd = frm.pwd.value;
	if(id == ""){
		alert("아이디 입력해주세요");
		return false;
	}
	if(nickName.value.length==0	){
		alert("닉네임을 입력해주세요");
		return false;
	}
	if(pwd == ""){
		alert("비밀번호를 입력해주세요");
		return false;
	}
	if(!regex.test(id)){
		alert("아이디 규격이 맞지 않습니다. 다시 입력해주세요.");
		console.log(name.value);
		return false;
	}
	if(!regex.test(nickName.value)){
		alert("닉네임 규격이 맞지 않습니다. 다시 입력해주세요.");
		console.log(name.value);
		return false;
	}
	if(!regex.test(pwd)){
		alert("비밀번호 규격이 맞지 않습니다. 다시 입력해주세요.");
		console.log(name.value);
		return false;
	}
	
	return frm.submit;
	
}

</script>
</head>
<body>

	<table border="1"
		style="width: 200px; text-align: center; margin: 200px auto auto auto;">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>닉네임</th>
			<th>비번</th>
		</tr>
			<form name="update" action="userUpdate.do" method="post">
				<input type="hidden" name="_method" value="PUT">
				<tr>
					<td><input type="text" name="name" value="${list1.name }" readonly="readonly"/></td>
					<td><input type="text" id="id" name="id" value="${list1.id }"/></td>
					<td><input type="text" id="nickName" name="nickName" value="${list1.nickName }"/></td>
					<td><input type="text" id="pwd" name="pwd" value="${list1.pwd }"/></td>
				</tr>
				<tr>
					<td colspan="4">
					<button type="submit" onclick="return ckecked();">수정</button>
					<button type="button" onclick="location='/main.do';">목록</button>
					</td>
				</tr>
			</form>
			
	</table>
</body>
</html>