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

<article class="detail data">

	<div>
		<strong>제목</strong><span>${CINP.c_title}</span>
	</div>
	
	<div>
		<strong>작성일</strong><span>${CINP.c_write}</span>
	</div>
	
	<div>
		<strong>시작</strong><span>${CINP.c_sdate}</span>
	</div>
	
	<div>
		<strong>종료</strong><span>${CINP.c_edate}</span>
	</div>
	
	<div>
		<strong>목표횟수</strong><span>${CINP.c_achieve}</span>
	</div>
	
	<div>
		<strong>실행횟수</strong><span>${CINP.c_count}</span>
	</div>
	
	<div>
		<strong>내용</strong><span>${CINP.c_memo}</span>
	</div>
	
	<div>
		<strong>공유</strong><span>${CINP.c_share}</span>
	</div>
	
	<div>
		<strong>사용여부</strong><span>${CINP.c_useyn}</span>
	</div>
	
</article>

<article class="detail button">

	<div>
		<button class="detail update" data-id="${CINP.c_seq}">수정</button>
		<button class="detail delete" data-id="${CINP.c_seq}">삭제</button>
	</div>

</article>

</body>
</html>