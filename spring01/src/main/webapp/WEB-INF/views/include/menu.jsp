<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


<div style="text-align: center;">
	<a href="${path}/member/list.do">회원관리</a>
	<a href="${path}/board/board_list.do">게시판</a>
</div>


<hr>