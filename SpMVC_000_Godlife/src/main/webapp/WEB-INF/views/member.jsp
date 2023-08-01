<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="ver_0042" var="ver" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>갓생살기</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia&effect=fire"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
  integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
  crossorigin="anonymous" />
  
<link href="${rootPath}/res/css/main.css?${ver}" rel="stylesheet">
<link href="${rootPath}/res/css/member.css?${ver}" rel="stylesheet">

<script> 
	var rootPath = "${rootPath}";
</script>
<script src="${rootPath}/res/js/member/login.js?${ver}"></script>
<script src="${rootPath}/res/js/member/join.js?${ver}"></script>
<script src="${rootPath}/res/js/member/findid.js?${ver}"></script>
</head>
<body>
	<c:if test="${empty BODY}">
		<%@ include file="/WEB-INF/views/member/login.jsp" %>
	</c:if>
	<c:if test="${BODY == 'JOIN'}">
		<%@ include file="/WEB-INF/views/member/join.jsp" %>
	</c:if>
	<c:if test="${BODY == 'FINDID'}">
		<%@ include file="/WEB-INF/views/member/findId.jsp" %>
	</c:if>
 	<c:if test="${BODY == 'FINDPW'}">
		<%@ include file="/WEB-INF/views/member/findPw.jsp" %>
	</c:if>
</body>
</html>