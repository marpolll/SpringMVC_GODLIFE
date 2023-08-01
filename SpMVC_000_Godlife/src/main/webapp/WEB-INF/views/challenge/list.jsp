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
						<span class="dadate">챌린지 </span><span class="cocount">일정</span>
					</h6>
					<input class="checkbox" type="checkbox" id="reg-log" name="reg-log" />
					<label for="reg-log"></label>

					<div class="card-3d-wrap mx-auto">
						<div class="card-3d-wrapper">
							<div class="card-front">
								<div class="center-wrap2">
									<div class="section text-center">
										<table class="challenge list">

											<tr>
												<th>챌린지</th>
												<th>시작</th>
												<th>종료</th>
												<th>목표횟수</th>

											</tr>
											<c:forEach items="${CHALLS}" var="CHALL">
												<tr data-id="${CHALL.c_seq}">
													<td>${CHALL.c_title}</td>
													<td>${CHALL.c_sdate}</td>
													<td>${CHALL.c_edate}</td>
													<td>${CHALL.c_achieve}</td>
												</tr>
											</c:forEach>
										</table>
										<div class="list pagination">
											<ul>

												<c:if test="${PAGI.firstPageNum > 1}">

													<li><a href="${rootPath}/challenge/list?page=1">&#124;&lt;</a>
													</li>

													<li><a
														href="${rootPath}/challenge/list?page=${PAGI.pageNum -1} ">
															&lt;</a></li>

												</c:if>

												<c:forEach begin="${PAGI.firstPageNum}"
													end="${PAGI.lastPageNum}" var="PAGE">

													<li class="${PAGI.pageNum == PAGE ? 'active' : ''}"><a
														href="${rootPath}/challenge/list?page=${PAGE}&search=${SEARCH}">${PAGE}</a></li>

												</c:forEach>

												<li><a
													href="${rootPath}/challenge/list?page=${PAGI.pageNum + 1}">
														&gt;</a></li>


												<c:if test="${PAGI.lastPageNum < PAGI.finalPageNum}">


													<li><a
														href="${rootPath}/challenge/list?page=${PAGI.finalPageNum}">&#124;&gt;</a>
													</li>

												</c:if>
											</ul>
										</div>

										<div class="list challenge search">
											<form>
												<input name="page" hidden="hidden" value="${PAGI.pageNum}" />
												<input name="search" placeholder="챌린지를 검색하세요" />
												<button>검색</button>
											</form>
										</div>
										<p class="mb-0 mt-4 text-center"></p>
									</div>
								</div>
							</div>
							<div class="card-back">
								<div class="center-wrap2">
									<div class="section text-center">
										<table class="schedule list">

											<tr>
												<th>일정</th>
												<th>시작</th>
												<th>종료</th>

											</tr>
											<c:forEach items="${SCHAS}" var="SCHA">
												<tr data-id="${SCHA.s_seq}">
													<td>${SCHA.s_title}</td>
													<td>${SCHA.s_sdate}</td>
													<td>${SCHA.s_edate}</td>
												</tr>
											</c:forEach>
											
										</table>
										<div class="list pagination">
											<ul>

												<c:if test="${PAGI.firstPageNum > 1}">

													<li><a href="${rootPath}/challenge/slist?page=1">&#124;&lt;</a>
													</li>

													<li><a
														href="${rootPath}/challenge/slist?page=${PAGI.pageNum -1} ">
															&lt;</a></li>

												</c:if>

												<c:forEach begin="${PAGI.firstPageNum}"
													end="${PAGI.lastPageNum}" var="PAGE">

													<li class="${PAGI.pageNum == PAGE ? 'active' : ''}"><a
														href="${rootPath}/challenge/slist?page=${PAGE}&search=${SEARCH}">${PAGE}</a></li>

												</c:forEach>

												<li><a
													href="${rootPath}/challenge/slist?page=${PAGI.pageNum + 1}">
														&gt;</a></li>


												<c:if test="${PAGI.lastPageNum < PAGI.finalPageNum}">


													<li><a
														href="${rootPath}/challenge/slist?page=${PAGI.finalPageNum}">&#124;&gt;</a>
													</li>

												</c:if>
											</ul>
										</div>

										<div class="list challenge search">
											<form>
												<input name="page" hidden="hidden" value="${PAGI.pageNum}" />
												<input name="search" placeholder="일정을 검색하세요" />
												<button>검색</button>
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
</div>
