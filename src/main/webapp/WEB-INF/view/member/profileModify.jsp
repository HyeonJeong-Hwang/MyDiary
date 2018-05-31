<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/diaryform.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/profile.css"/>">
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#profileBtn").click(function(){
			$("#profileForm").attr({
				"method" : "post",
				"action" : "<c:url value="/profile/modify"/>"
			}).submit();
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/template/main.jsp" />
		<div>
			<div id="left-bookmark">
				<div class="tag-h"><a href="<c:url value="/"/>">Profile</a></div>
				<div class="tag-h"><a href="<c:url value="/monthly"/>">Monthly</a></div>
				<div class="tag-h"><a href="<c:url value="/weekly"/>">Weekly</a></div>
				<div class="tag-h"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag-h"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div><!--  
			--><div id="center-page">
				
				<div id="profile-region">
					<form:form modelAttribute="profileForm" enctype="multipart/form-data">
						<p>Image : 
							<input type="file" id="profile-img" name="file" value="${profile.profilePicture}"/>
						</p>
						<p>Name : 
							<input type="text" id="name" name="name" value="${profile.name}" />
						</p>
						<p>Like : 
							<input type="text" id="like" name="likeThing" value="${profile.likeThing}"/>
						</p>
						<p>Hate : 
							<input type="text" id="hate" name="hateThing" value="${profile.hateThing}"/>
						</p>
						<p>Memo : 
							<textarea id="memo" name="profileMemo" rows="10" cols="30">${profile.profileMemo}</textarea>
						</p>
						
						<p><input type="button" id="profileBtn" value="수정완룡"/></p>
					</form:form>
				</div>
				
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