<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		$("#btnWrite").click(function(){
			//페이지 주소 변경(이동)
			location.href="${path}/board/board_write.do"
		})
	})
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시판</h2>

<!-- 검색폼  -->
<form name="form1" method="post" action="${path}/board/board_list.do">
	<select name="search_option">
		<option value="all">이름+내용+제목</option> 
		<option value="writer">이름</option>
		<option value="content" selected>내용</option>
		<option value="title">제목</option>
	</select>	
	<input name="keyword">
	<input type="submit" value="조회">
	<button type="button" id="btnWrite">글쓰기</button>
</form>


<table border="1" width=600px>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
<c:forEach var="row" items="${list}">
	<tr>
		<td>${row.bno}</td>
		<td>
			<a href="${path}/board/board_view.do?bno=${row.bno}">${row.title}</a>
		</td>
		<td>${row.writer}</td>
		<td><fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${row.viewcnt}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>