<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<form method="post" class="main update">
	<article class="detail data">

		<div>
			<label>제목</label> <input name="c_title" value="${CINP.c_title}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>


		<div>
			<label>작성일</label> <input name="c_write" type="date" value="${CINP.c_write}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>

		<div>
			<label>시작일</label> <input name="c_sdate" type="date" value="${CINP.c_sdate}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>

		<div>
			<label>종료일</label> <input name="c_edate" type="date" value="${CINP.c_edate}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>

		<div>
			<label>목표횟수</label> <input name="c_achieve" value="${CINP.c_achieve}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>
		

		<div>
			<label>실행횟수</label> <input name="c_count" value="${CINP.c_count}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>

		<div>
			<label>내용</label> <input name="c_memo" value="${CINP.c_memo}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>
		
		<div>
			<label>공유</label> <input name="c_share" value="${CINP.c_share}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>
		
		<div>
			<label>사용여부</label> <input name="c_useyn" value="${CINP.c_useyn}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>
		
		
	</article>
	<article class="udetail button">
		<div>
			<button class="button cinput" type="button">수정하기</button>
		</div>
	</article>
</form>
