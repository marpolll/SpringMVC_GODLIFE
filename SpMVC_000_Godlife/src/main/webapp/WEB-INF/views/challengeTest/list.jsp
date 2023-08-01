<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<table class="main list">

	<tr>
		<th>챌린지</th>
		<th>시작</th>
		<th>종료</th>
		<th>횟수</th>

	</tr>
	<c:choose>
		<c:when test="${not empty CHALLS}">
			<c:forEach items="${CHALLS}" var="CHALL">
				<tr>
					<td><a href="${rootPath}/challenge/${CHALL.c_code}/detail">
							${CHALL.c_title} </a></td>
					<td>${CHALL.c_start}</td>
					<td>${CHALL.c_end}</td>
					<td>${CHALL.c_count}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="5">챌린지정보 없음</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>
<div class="main pagination">
	<ul>
		<c:forEach begin="1" end="10" var="PAGE">
			<li>${PAGE}</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>