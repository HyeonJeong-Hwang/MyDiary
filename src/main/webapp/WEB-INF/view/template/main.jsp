<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/diaryform.css"/>">
</head>
<body>

	<div id="wrapper">
		
		<div id="header" style="background-color: #FFA7A7">
			<div id="nickname-view">${sessionScope.__USER__.nickname}(${sessionScope.__USER__.email }) / 
				<a href="<c:url value="/logout"/>">로그아웃</a>
				<a href="<c:url value="/delete/member"/>">탈퇴하기</a>
			</div>
			<div id="diary-title"><h1>${sessionScope.__USER__.nickname }의 다이어리</h1></div>
		</div>
		
	</div>


</body>
</html>