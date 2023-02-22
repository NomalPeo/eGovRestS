<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ckecked(){
		var regex = /^[A-Za-z0-9+]*$/; 
		var name = document.getElementById("name");
		var id = frm.id.value;
		var nickName = document.getElementById("nickName");
		var pwd = frm.pwd.value;
		console.log(name);
		if(name.value.length==0	){
			alert("이름을 입력해주세요");
			return false;
		}
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
		if(!regex.test(name.value)){
			alert("이름 규격이 맞지 않습니다. 다시 입력해주세요.");
			console.log(name.value);
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
	<form name="frm" action="userWriteSave.do" method="POST">
		<table border="1" style="margin:200px auto auto auto; text-align: center; ">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>닉네임</th>
				<th>비번</th>
			</tr>
			<tr>
				<td><input id="name" type="text" name="name"></td>
				<td><input id="id" type="text" name="id"></td>
				<td><input id="nickName" type="text" name="nickName"></td>
				<td><input id="pwd" type="text" name="pwd"></td>
			</tr>
			<tr><td colspan="4"><button type="submit" onclick="return ckecked();">작성</button>
				<button type="button" onclick="location='/main.do';">목록</button>
			</td>
			</tr>
		</table>
	</form>
</body>
</html>