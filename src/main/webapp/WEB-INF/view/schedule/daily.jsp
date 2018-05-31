<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/diaryform.css"/>">
<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#nowDate").change(function(){
			var value = $("#nowDate").val();
			value = value.split("-");
			var month = value[0]+""+value[1]+""+value[2];
			var url = "<c:url value='/daily/"+month+"'/>";
			location.href=url;
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
				<div class="tag-h"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag-h"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div><!--  
			--><div id="center-page">
				<c:choose>
					<c:when test="${day == 1}">
						<c:choose>
							<c:when test="${month == 1}">
								<a href="<c:url value="/daily/${((year-1)*10000)+1231}"/>">◀</a> 
							</c:when>
							<c:otherwise>
								<a href="<c:url value="/daily/${(year*10000)+((month-1)*100)+preCalDate}"/>">◀</a>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<a href="<c:url value="/daily/${(year*10000)+(month*100)+day-1}"/>">◀</a> 
					</c:otherwise>
				</c:choose>
						<input type="date" id="nowDate" name="nowDate" value="${now}" />
							
				<c:choose>
					<c:when test="${day == lastDate}">
						<c:choose>
							<c:when test="${month == 12}">
								<a href="<c:url value="/daily/${((year+1)*10000)+101}"/>">▶</a> 
							</c:when>
							<c:otherwise>
								<a href="<c:url value="/daily/${(year*10000)+((month+1)*100)+1}"/>">▶</a>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<a href="<c:url value="/daily/${(year*10000)+(month*100)+day+1}"/>">▶</a> 
					</c:otherwise>
				</c:choose>
			
				<div id="todo-list">
					<table>
						
						<tr>
							<th>NO.</th>
							<th>TODO</th>
						</tr>
						<c:set var="i">0</c:set>
						<c:forEach items="${dailySchedule}" var="sc">
							<c:set var="i">${i+1}</c:set>
							<tr>
							<td>${i}</td>
							<td><a href="<c:url value="/schedule/view/${sc.scheduleId}"/>">${sc.scheduleTitle}</a></td>
							
							</tr>
						</c:forEach>
						<tr><td colspan="3"><a href="<c:url value="/daily/write/${(year*10000)+(month*100)+date}"/>">추가하기</a></td></tr>
						
					</table>
				</div>
				<div id="daily-memo">
					<p>오늘의 일기</p>
					<c:forEach items="${dailySchedule}" var="sc">
						<p>${sc.scheduleMemo}</p>
					</c:forEach>
					<p><a href="<c:url value="/daily/dairy/${(year*10000)+(month*100)+date}"/>">쓰기</a></p>
				</div>
				
			</div><!--
			--><div id="right-bookmark">
				<div class="tag-h"><a href="<c:url value="/"/>">Profile</a></div>
				<div class="tag-h"><a href="<c:url value="/monthly"/>">Monthly</a></div>
				<div class="tag-h"><a href="<c:url value="/weekly"/>">Weekly</a></div>
				<div class="tag"><a href="<c:url value="/daily"/>">Daily</a></div>
				<div class="tag"><a href="<c:url value="/memo"/>">Memo</a></div>
			</div>
		</div>
	</div>
</body>
</html>