<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/template/main.jsp" />
		<div>
			<div id="left-bookmark">
				<div class="tag"><a href="<c:url value="/"/>">Profile</a></div>
				<div class="tag"><a href="<c:url value="/monthly"/>">Monthly</a></div>
				<div class="tag"><a href="<c:url value="/weekly"/>">Weekly</a></div>
				<div class="tag"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div><!--  
			--><div id="center-page">
				<div>${schedule.scheduleTitle}</div>
				<div>${schedule.scheduleBody}</div>
				<div><a href="<c:url value="/schedule/delete/${schedule.scheduleId}"/>">삭제하기</a></div>>
			</div><!--
			--><div id="right-bookmark">
				<div class="tag"><a href="<c:url value="/"/>">Profile</a></div>
				<div class="tag"><a href="<c:url value="/monthly"/>">Monthly</a></div>
				<div class="tag"><a href="<c:url value="/weekly"/>">Weekly</a></div>
				<div class="tag"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div>
		</div>
	</div>
</body>
</html>