<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/diaryform.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/weekly.css"/>">
<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#nowDate").change(function(){
			var value = $("#nowDate").val();
			value = value.split("-");
			var month = value[0]+""+value[1];
			var url = "<c:url value='/weekly/"+month+"'/>";
			location.href=url;
		});
	});
</script>
<script type="text/javascript"></script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/template/main.jsp" />
		<div>
			<div id="left-bookmark">
				<div class="tag"><a href="<c:url value="/"/>">Profile</a></div>
				<div class="tag"><a href="<c:url value="/monthly"/>">Monthly</a></div>
				<div class="tag-h"><a href="<c:url value="/weekly"/>">Weekly</a></div>
				<div class="tag-h"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag-h"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div><!--  
			--><div id="center-page">
				<div style="text-align: center"> 
					<c:choose>
						<c:when test="${(monthYear-1)%100 != 0}">
							<a href="<c:url value="/weekly/${monthYear-1}"/>">◀</a> 
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/weekly/${monthYear-89}"/>">◀</a> 
						</c:otherwise>
					</c:choose>
							<input type="month" id="nowDate" name="nowDate" value="${now}" />
					<c:choose>
						<c:when test="${(monthYear+1)%100 < 13 }">
							<a href="<c:url value="/weekly/${monthYear+1}"/>">▶</a> 
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/weekly/${monthYear+89}"/>">▶</a> 
						</c:otherwise>
					</c:choose>
				</div>
				<table id="week-todo">
					<c:forEach begin="1" end="${weekth}" var="week">
						<tr>
							<th class="week-th">${week}주차</th>
							<th class="do-list">
								<c:set var="w">${week}</c:set>
								<c:forEach items="${weeklySchedule[w]}" var="sc">
									<p><a href="<c:url value="/schedule/view/${sc.scheduleId}"/>">${sc.scheduleTitle}</a></p>
								</c:forEach>
								
							</th>
							<th><a href="<c:url value="/weekly/write/${monthYear}/${week}"/>">추가하기</a></th>
						</tr>
					</c:forEach>
					
				</table>
				
			</div><!--
			--><div id="right-bookmark">
				<div class="tag-h"><a href="<c:url value="/"/>">Profile</a></div>
				<div class="tag-h"><a href="<c:url value="/monthly"/>">Monthly</a></div>
				<div class="tag"><a href="<c:url value="/weekly"/>">Weekly</a></div>
				<div class="tag"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div>
		</div>
	</div>
</body>
</html>