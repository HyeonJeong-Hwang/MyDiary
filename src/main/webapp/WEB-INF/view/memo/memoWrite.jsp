<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/diaryform.css"/>">
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
	
		$("#writeBtn").click(function(){
			
			var mode = "${mode}";
			if(mode == "modify"){
				var url = "<c:url value="/modify/${memoVO.id}"/>"
			}
			else{
				var url = "<c:url value="/memo/write"/>"
			}
			
			var writeForm = $("#memoWriteForm");
			writeForm.attr({
				"method" : "Post",
				"action" : url
			});
			writeForm.submit()
		});
	});

</script>
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
				<div class="tag-h"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div><!--  
			--><div id="center-page">
				<div>
					<form:form modelAttribute="memoWriteForm">
						<div>
							제목 : <input type="text" id="title" name="memoTitle" placeholder="제목"
									value="${memo.memoTitle}"/>
						</div>
		
						<div>
							내용: <textarea rows="10" cols="30" id="body" name="memoBody" >${memo.memoBody}</textarea>
						</div>
						<input type="button" id="writeBtn" value="등록" />	
					</form:form>
				</div>
			</div><!--
			--><div id="right-bookmark">
				<div class="tag-h"><a href="<c:url value="/"/>">Profile</a></div>
				<div class="tag-h"><a href="<c:url value="/monthly"/>">Monthly</a></div>
				<div class="tag-h"><a href="<c:url value="/weekly"/>">Weekly</a></div>
				<div class="tag-h"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div>
		</div>	
	</div>
</body>
</html>