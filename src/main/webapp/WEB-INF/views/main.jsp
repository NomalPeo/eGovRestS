<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	const list = ${list1};
	console.log(list);
</script>
</head>
<body>
	<table border="1" style="width:300px; text-align: center; margin:200px auto auto auto;">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>닉네임</th>
			<th>비번</th>
			<th>삭제</th>
		<tr>
		<c:if test="${empty list1 }">
			<tr>
				<td colspan="5">글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="list" items="${list1 }">
			<tr>
				<td><c:out value="${list.name }"/></td>
				<td><a href="/oneList.do?id=${list.id }"><c:out value="${list.id }"/></a></td>
				<td><c:out value="${list.nickName }"/></td>
				<td><c:out value="${list.pwd }"/></td>
				
				<td>
					<form action="/userDel.do" method="POST">
						<input type="hidden" name="_method" value="DELETE">
						<input type="hidden" name="id" value="${list.id}">
						<input type="submit" value="삭제"> 
					</form>
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td style="text-align: center;" colspan="5"><button type="button" onclick="location='/userWrite.do';">글작성</button></td>
			</tr>
	</table>
</body>
</html>