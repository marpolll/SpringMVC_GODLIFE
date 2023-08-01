<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<div class="section">
	<div class="container">
		<div class="row full-height justify-content-center">
			<div class="col-12 text-center align-self-center py-5">
				<div class="section pb-5 pt-5 pt-sm-2 text-center">
					<div class="card-3d-wrap mx-auto">
						<div class="card-3d-wrapper">
							<div class="card-front">
								<div class="center-wrap3">
									<div class="section text-center">
										<form method="post" class="main sinput">

											<div>
												<label>제목</label> <input name="s_title" placeholder="제목"
													value="${SINP.s_title}" />
											</div>

											<div>
												<label>작성일</label> <input name="s_write" placeholder="작성일"
													value="${SINP.s_write}" />
											</div>

											<div>
												<label>시작일</label> <input name="s_sdate" type="date"
													placeholder="시작일" value="${SINP.s_sdate}" />
											</div>

											<div>
												<label>종료일</label> <input name="s_edate" type="date"
													placeholder="종료일" value="${SINP.s_edate}" />
											</div>
											
											<div>
												<label>내용</label> <input name="s_memo" placeholder="내용"
													value="${SINP.s_memo}" />
											</div>

											<div>
												<label></label>
												<button class="button sinput" type="button">추가하기</button>
											</div>
										</form>
										<p class="mb-0 mt-4 text-center"></p>
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