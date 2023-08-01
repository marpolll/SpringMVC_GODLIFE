<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<div class="section">
	<div class="container">
		<div class="row full-height justify-content-center">
			<div class="col-12 text-center align-self-center py-5">
				<div class="section pb-5 pt-5 pt-sm-2 text-center">
					<h6 class="mb-0 pb-3">
						<span class="dadate">기간 </span><span class="cocount">횟수</span>
					</h6>
					<input class="checkbox" type="checkbox" id="reg-log" name="reg-log" />
					<label for="reg-log"></label>

					<div class="card-3d-wrap mx-auto">
						<div class="card-3d-wrapper">
							<div class="card-front">
								<div class="center-wrap">
									<div class="section text-center">
										<form method="post" class="main cinput">

											<div>
												<label>제목</label> <input name="c_title" placeholder="제목"
													value="${CINP.c_title}" />
											</div>

											<div>
												<label>작성일</label> <input name="c_write" placeholder="작성일"
													value="${CINP.c_write}" />
											</div>

											<div>
												<label>시작일</label> <input name="c_sdate" type="date"
													placeholder="시작일" value="${CINP.c_sdate}" />
											</div>

											<div>
												<label>종료일</label> <input name="c_edate" type="date"
													placeholder="종료일" value="${CINP.c_edate}" />
											</div>
											
											<div>
												<label>내용</label> <input name="c_memo" placeholder="내용"
													value="${CINP.c_memo}" />
											</div>

											<div>
												<label></label>
												<button class="button cinput" type="button">추가하기</button>
											</div>
										</form>
										<p class="mb-0 mt-4 text-center"></p>
									</div>
								</div>
							</div>
							<div class="card-back">
								<div class="center-wrap">
									<div class="section text-center">
										<form method="post" class="main coinput">

											<div>
												<label>제목</label> <input name="c_title" placeholder="제목"
													value="${CINP.c_title}" />
											</div>

											<div>
												<label>작성일</label> <input name="c_write" placeholder="작성일"
													value="${CINP.c_write}" />
											</div>
											
											<div>
												<label>목표횟수</label> <input name="c_achieve" 
													placeholder="종료일" value="${CINP.c_achieve}" />
											</div>
											
											<div>
												<label>내용</label> <input name="c_memo" placeholder="내용"
													value="${CINP.c_memo}" />
											</div>
											<div>
												<label></label>
												<button class="button coinput" type="button">추가하기</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>