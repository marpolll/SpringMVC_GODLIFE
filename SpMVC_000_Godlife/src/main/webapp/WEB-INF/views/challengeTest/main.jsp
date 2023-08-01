<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<script>

</script>
<div class="phone_size">
	<h2>6월</h2>
	<table class="container">
		<thead>
			<tr>
				<th><h1>일</h1></th>
				<th><h1>월</h1></th>
				<th><h1>화</h1></th>
				<th><h1>수</h1></th>
				<th><h1>목</h1></th>
				<th><h1>금</h1></th>
				<th><h1>토</h1></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
			</tr>

		</tbody>
	</table>

	<c:choose>
		<c:when test="${not empty CHALLENGES}">
			<c:forEach items="${CHALLENGES}" var="CHALLENGE">
				<div class="progress">
					<div class="challenge">
						<progress value="${CHALLENGE.c_count}"
							max="100" class="challenge pg${CHALLENGE.c_seq }" id="e"></progress>
						<span class="challenge">${CHALLENGE.c_title}</span> 
						<span id="c_count" class="challenge ct${CHALLENGE.c_seq }">${CHALLENGE.c_count}</span>
						<span>${CHALLENGE.c_achieve}</span>
						<button class="button_add" data-id="${CHALLENGE.c_seq }">+</button>
<!-- 						<span class="icon"> 
							<i class="fa fa-share-alt" aria-hidden="true"></i>
						</span> -->
					</div>

				</div>
				<%-- <tr>
					<td>${CHALLENGE.c_seq}</td>
					<td>${CHALLENGE.c_pcode}</td>
					<td>${CHALLENGE.c_title}</td>
					<td>${CHALLENGE.c_memo}</td>
					<td>${CHALLENGE.c_achieve}</td>
					<td>${CHALLENGE.c_count}</td>

				</tr> --%>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div>챌린지를 등록해 주세요!!</div>
		</c:otherwise>
	</c:choose>

<!-- 	 -->