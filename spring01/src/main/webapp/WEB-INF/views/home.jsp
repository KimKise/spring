<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<%
String path = request.getContextPath();
%>
<!--
	json의 형식
	{변수명 : 값, 변수명: 값}
	{name : "냉장고", price : 500000}	
 -->
<script>
function doF(){
	$.ajax({
		type:"post",
		url: "<%=path%>/part1_ch05/doF", 
		success: function(result){		/*url 호출하고 받아와서  */
			console.log(result);		/*result가 여기서 json이다  */
			
		
			$("#result").text(result.name+","+result.price)	/* 출력  result.name-> json.변수명 */
		}
	})
}
</script>
</head>
<body>
<a href="<%=path%>/part1_ch05/doA">doA</a><br>
<a href="<%=path%>/part1_ch05/doB">doB</a><br>
<a href="<%=path%>/part1_ch05/doC">doC</a><br>
<a href="<%=path%>/part1_ch05/doD">doD</a><br>
<a href="javascript:doF()">doF</a>
<div id="result"></div>
</body>
</html>