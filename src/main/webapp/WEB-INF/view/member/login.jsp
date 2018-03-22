<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#loginBtn").click(function(){
			
			$("#loginForm").attr({
				"action" : "<c:url value="/login"/>",
				"method" : "POST"
			}).submit();
		});
	});
</script>
</head>
<body>

	<form id="loginForm">
		<div>
			<input type="text" id="email" name="email" placeholder="email" />
		</div>
		<div>
			<input type="password" id="password" name="password" placeholder="password" />
		</div>
		<div>
			<input type="button" id="loginBtn" value="Login" />
		</div>
	
	</form>
	
	<div>
		<a href="<c:url value="/signup"/>">회원가입</a>
	</div>

</body>
</html>