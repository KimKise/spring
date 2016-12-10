<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	//수정 버튼 클릭
	$("#btnUpdate").click(function(){
		document.form1.action="${path}/member/update.do";
		document.form1.submit();
	});
	//삭제 버튼 클릭
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/member/delete.do";
			document.form1.submit();
		}
	})
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>회원정보</h2>

<form name="form1" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input name="userid" value="${dto.userid}" readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userpw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input name="username" value="${dto.username}"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input name="email" value="${dto.email}"></td>
		</tr>
		<tr>
			<td>회원가입일자</td>
			<td>
				${dto.regdate}<%-- <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
			</td>
		</tr>
		<tr>
			<td>회원정보수정일자</td>
			<td>
				<fmt:formatDate value="${dto.updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="삭제" id="btnDelete">
				<div style="color:red">${message}</div> 
			</td>
		</tr>
	</table>
</form>
</body>
</html>