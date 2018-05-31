<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/signup.css"/>">
<script type="text/javascript"
	src="<c:url  value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#email").keyup(function(){
			var value = $(this).val();
			if(value != ""){
				$.post("<c:url value="/api/exists/email"/>", {
					email:value
				},function(response){
					console.log(response.response);
					console.log(value);
					if(response.response){
						$("#email").removeClass("valid");
						$("#email").addClass("invalid");
					}
					else{
						$("#email").removeClass("invalid");
						$("#email").addClass("valid");
					}
				});
			}
			
		});
		
		$("#password-confirm").keyup(function(){
			var value = $(this).val();
			var password = $("#password").val();
			
			if(value != password){
				$(this).removeClass("valid");
				$(this).addClass("invalid");
				$("#password").removeClass("valid");
				$("#password").addClass("invalid");
			}
			else{
				$(this).removeClass("invalid");
				$(this).addClass("valid");
				$("#password").removeClass("invalid");
				$("#password").addClass("valid");
			}
		})

		$("#signupBtn").click(function() {
			if($("#email").val()==""){
				alert("이메일 오디감");
				$("#email").focus();
				$("#email").addClass("invalid");
				return false;
			}
			if($("#email").hasClass("invalid")){
				alert("이메일 안 돼");
				$("#email").focus();
				return false;
			}
			else{
				$.post("<c:url value="/api/exists/email"/>", {
					email:$("#email").val()
				},function(response){
					if(response.response){
						alert("이메일을 사용할 수 없어");
						$("#email").focus();
						return false;
					}			
					if($("#password").val()==""){
						alert("비번 오디감");
						$("#password").focus();
						$("#password").addClass("invalid");
						return false;
					}
					if($("#password-confirm").val()==""){
						alert("비번확인 오디감");
						$("#password-confirm").focus();
						$("#password-confirm").addClass("invalid");
						return false;
					}
					if($("#nickname").val()==""){
						alert("닉네임 오디감");
						$("#nickname").focus();
						$("#nickname").addClass("invalid");
						return false;
					}
					if($("#birthday").val()==""){
						alert("생일 오디감");
						$("#birthday").focus();
						$("#birthday").addClass("invalid");
						return false;
					}
					$("#signupForm").attr({
						"action" : "<c:url value="/signup"/>",
						"method" : "post"
					}).submit();
					
				});				
			}

		});

	});
</script>
</head>
<body>


	<form:form modelAttribute="signupForm">
		<div>
			<input type="email" id="email" name="email" placeholder="email" value="${signupForm.email}" />
			<div><form:errors path="email" /></div>
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
			<input type="button" id="signupBtn" value="signup">
		</div>
	</form:form>

</body>
</html>