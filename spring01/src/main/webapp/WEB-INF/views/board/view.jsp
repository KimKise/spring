<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물보기</title>
<script>
$(document).ready(function(){
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/board/board_delete.do"
		document.form1.submit();
		}
	});
	
	$("#btnUpdate").click(function(){
		var writer=document.form1.writer.value;
		var content=document.form1.content.value;
		var title=document.form1.title.value;		//name으로 찾을때
		//var title=$("#title").val(); 				//id로 찾을때
		if(writer==""){
			alert("이름을 입력하세요");
			document.form1.writer.focus();
			return;
		}
		if(content==""){
			alert("내용을 입력하세요");
			document.form1.content.focus();
			return;
		}
		if(title==""){
			alert("제목을 입력하세요");
			document.form1.title.focus();
			return;
		}
		//수정 주소
		document.form1.action="${path}/board/board_update.do"
		//폼에 입력한 데이터를 서버로 전송함
		document.form1.submit();
	});
});
</script>

</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시물 보기</h2>
<form name="form1" method="post" >
<div>
	작성일자 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/> 
	<!-- 날짜형식 yyyy 4자리 연도 MM월 dd일 a 오전/오후
	HH 24시간제 hh 12시간제 mm분 ss초 -->
</div>
<div>
	조회수 : ${dto.viewcnt}
</div>
<div>
	제목
	<input name="title" size="80" id="title"  placeholder="제목을 입력하세요" value="${dto.title}">
</div>
<div>
	내용
	<textarea name="content" rows="3" cols="80" placeholder="내용을 입력하새요">${dto.content}</textarea>
</div>
<div>
	이름
	<input name="writer" placeholder="이름을 입력하세요" value="${dto.writer}" >
</div>
<div  style=" width: 700px; text-align: center">
<!-- 게시물 번호를 hidden으로 처리  -->
	<input type="hidden" name="bno" value="${dto.bno}">
	<button type="button" id="btnUpdate">수정</button>
	<button type="button" id="btnDelete">삭제</button>
</div>
</form>
</body>
</html>