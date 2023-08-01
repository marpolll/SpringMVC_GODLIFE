<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<nav class="side_bar">
	<a href="/app/challenge/" class="mainlogo"> 
		<img src="${rootPath}/res/image/www2.png" width="250px" />
	</a>
	<div id="godlife" class="title font-effect-fire">
		<a>갓생살기</a>
	</div>
	<div class="side_menu">
		<div class="inner_smenu">
			<ul>
				<li><a href="${rootPath}/challengeTest">챌린지</a></li>
				<li><a href="${rootPath}/challenge/cinsert">챌린지추가</a></li>
				<li><a href="${rootPath}/challenge/sinsert">일정추가</a></li>
				<li><a href="${rootPath}/challenge/list">일정보기</a></li>
				<li><a href="${rootPath}/challengeTest/share">공유</a></li>
				<li><a href="${rootPath}/logout">로그아웃</a></li>
			</ul>
		</div>
	</div>

	<div class="sfooter">
		<div class="sns_wrap">
			<a href="https://www.instagram.com/" target="_blank" class="sns_btn"
				id="insta"> <i class="fab fa-instagram"></i>
			</a> <a href="https://ko-kr.facebook.com/" target="_blank"
				class="sns_btn" id="facebook"> <i class="fab fa-facebook-square"></i>
			</a> <a href="https://www.youtube.com/" target="_blank" class="sns_btn"
				id="youtube"> <i class="fab fa-youtube"></i>
			</a> <a href="https://line.me/ko/" target="_blank" class="sns_btn"
				id="line"> <i class="fab fa-line"></i>
			</a>
		</div>
	</div>
</nav>