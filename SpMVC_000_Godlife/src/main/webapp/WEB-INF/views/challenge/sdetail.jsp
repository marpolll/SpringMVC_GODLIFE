<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<article class="sdetail data">
	
	<div>
		<strong>제목</strong><span>${SINP.s_title}</span>
	</div>
	
	<div>
		<strong>작성일</strong><span>${SINP.s_write}</span>
	</div>
	
	<div>
		<strong>시작</strong><span>${SINP.s_sdate}</span>
	</div>
	
	<div>
		<strong>종료</strong><span>${SINP.s_edate}</span>
	</div>
	
	<div>
		<strong>내용</strong><span>${SINP.s_memo}</span>
	</div>
	
</article>

<article class="sdetail button">

	<div>
		<button class="sdetail supdate" data-id="${SINP.s_seq}">수정</button>
		<button class="sdetail sdelete" data-id="${SINP.s_seq}">삭제</button>
	</div>

</article>

</body>
</html>