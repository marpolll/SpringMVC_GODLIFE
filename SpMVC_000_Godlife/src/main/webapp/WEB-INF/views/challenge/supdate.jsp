<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<form method="post" class="main supdate">
		<article class="detail data">
		
		<div>
			<label>제목</label> <input name="s_title" value="${SINP.s_title}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>


		<div>
			<label>작성일</label> <input name="s_write" value="${SINP.s_write}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>

		<div>
			<label>시작일</label> <input name="s_sdate" value="${SINP.s_sdate}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>

		<div>
			<label>종료일</label> <input name="s_edate" value="${SINP.s_edate}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>

		<div>
			<label>내용</label> <input name="s_memo" value="${SINP.s_memo}" />
		</div>
		<div class="message b_name">
			<label></label><span></span>
		</div>
		
		</article>
		<article class="detail button">
		<div>
			<button class="button cinput" type="button">수정하기</button>
		</div>
		</article>
</form>
