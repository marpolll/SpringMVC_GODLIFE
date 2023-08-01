<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="phone_size">
	<div class="search_box">
		<form>
			<input class="search_txt" type="text" name="search" id="search_input" value="${SEARCH}" placeholder="챌린지를 검색해보세요"/> 
			<button class="search_btn_box">
				<span class="search_btn">
					<i class="fas fa-search"></i>
				</span>
			</button>
		</form>
	</div>
	<div class="share container">
		<c:forEach  items="${CLIST}" var="LIST">
			<div class="share_box">
				<div class="share profile">
					<div class="profile_img">
						<img src="${rootPath}/res/image/temp.png" />
					</div>
					<div class="profile_text">
						<div>${LIST.u_nickname}</div>
					</div>
				</div>
				<div class="share content">
					<div class="text">${LIST.c_memo}</div>
					<div class="mession">
						<span>${LIST.c_title}</span>
					</div>
					<div class="share achieve">
						<div>
							시작일자 : ${LIST.c_sdate} <br>
							도전일자 : ${LIST.c_edate}
						</div>
						<div>
							목표횟수 : ${LIST.c_achieve}<br>
							성공횟수 : ${LIST.c_count}
						</div>
						<div>
						<c:forEach begin="1" end="${LIST.star}">
							<i class="fa fa-star" aria-hidden="true"></i>
						</c:forEach>
						<c:forEach begin="1" end="${5-LIST.star}">
							<i class="fa fa-star-o" aria-hidden="true"></i> 
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
<!-- 							<i class="fa fa-star-o" aria-hidden="true"></i> 
							<i class="fa fa-star-o" aria-hidden="true"></i> 
							<i class="fa fa-star-o" aria-hidden="true"></i> 
							<i class="fa fa-star-o" aria-hidden="true"></i> -->
	<!-- 
	
				<span class="profile_lv"> <i class="fa fa-user"
				aria-hidden="true"></i>
			</span>
			
			
			
			
			
				<div class="Attainment">
				<div>
					도전일자<br /> 30일
				</div>
				<div>
					성공일자<br /> 7일
				</div>
				<div class="Attainment_star">
					<i class="fa fa-star" aria-hidden="true"></i> <i
						class="fa fa-star-o" aria-hidden="true"></i> <i
						class="fa fa-star-o" aria-hidden="true"></i> <i
						class="fa fa-star-o" aria-hidden="true"></i> <i
						class="fa fa-star-o" aria-hidden="true"></i>
				</div>
			</div>
			<div class="good_btn">
				<i class="fa fa-thumbs-up" aria-hidden="true"></i>
			</div>
	
	
	
	
	<div class="share_box">
		<span class="profile_lv"> <i class="fa fa-user"
			aria-hidden="true"></i>
		</span>
		<div class="profile">
			<div class="profile_img img2"></div>
			<div class="profile_text">
				<div>닉네임</div>
				<div>절약하기 도전중!!</div>
			</div>
		</div>
		<div class="mession">
			<span>무지출 챌린지</span>
		</div>
		<div class="Attainment">
			<div>
				도전일자<br/> 30일
			</div>
			<div>
				성공일자<br/> 0일
			</div>
			<div class="Attainment_star">
				<i class="fa fa-star-o" aria-hidden="true"></i> <i
					class="fa fa-star-o" aria-hidden="true"></i> <i
					class="fa fa-star-o" aria-hidden="true"></i> <i
					class="fa fa-star-o" aria-hidden="true"></i> <i
					class="fa fa-star-o" aria-hidden="true"></i>
			</div>
		</div>
		<div class="good_btn">
			<i class="fa fa-thumbs-up" aria-hidden="true"></i>
		</div>
	</div>
	<div class="share_box">
		<span class="profile_lv"> <i class="fa fa-user"
			aria-hidden="true"></i>
		</span>
		<div class="profile">
			<div class="profile_img img3"></div>
			<div class="profile_text">
				<div>닉네임</div>
				<div>독서를 생활화 하자</div>
			</div>
		</div>
		<div class="mession">
			<span>책 한권 다읽기</span>
		</div>
		<div class="Attainment">
			<div>
				도전일자<br /> 30일
			</div>
			<div>
				성공일자<br /> 27일
			</div>
			<div class="Attainment_star">
				<i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star"
					aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i>
				<i class="fa fa-star" aria-hidden="true"></i> <i
					class="fa fa-star-o" aria-hidden="true"></i>
			</div>
		</div>
		<div class="good_btn">
			<i class="fa fa-thumbs-up" aria-hidden="true"></i>
		</div>
	</div> -->
</div>