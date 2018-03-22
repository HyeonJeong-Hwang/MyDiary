<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url  value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {

		$("#signupBtn").click(function() {
			$("#signupForm").attr({
				"action" : "<c:url value="/signup"/>",
				"method" : "post"
			}).submit();

		});

	});
</script>
</head>
<body>


	<form id="signupForm">
		<div>
			<input type="email" id="email" name="email" placeholder="email">
		</div>
		<div>
			<input type="password" id="password" name="password"
				placeholder="password">
		</div>
		<div>
			<input type="password" id="password-confirm"
				placeholder="passwordConfirm">
		</div>
		<div>
			<input type="text" id="nickname" name="nickname"
				placeholder="nickname">
		</div>
		
		<div>
			<input type="date" id="birthday" name="birthday"
				placeholder="birthday">
		</div>

		<div>
			<input type="button" id="signupBtn" value="SignUP">
		</div>
	</form>

</body>
</html>