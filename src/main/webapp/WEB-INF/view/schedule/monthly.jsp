<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/diaryform.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/monthly.css"/>">
<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#nowDate").change(function(){
			var value = $("#nowDate").val();
			value = value.split("-");
			var month = value[0]+""+value[1];
			var url = "<c:url value='/monthly/"+month+"'/>";
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
				<div class="tag">
					<a href="<c:url value="/"/>">Profile</a>
				</div>
				<div class="tag-h">
					<a href="<c:url value="/monthly"/>">Monthly</a>
				</div>
				<div class="tag-h">
					<a href="<c:url value="/weekly"/>">Weekly</a>
				</div>
				<div class="tag-h">
					<a href="<c:url value="/daily"/>">Daily</a>
				</div>
				<div class="tag-h">
					<a href="<c:url value="/memo"/>">Memo</a>
				</div>
			</div>
			<!--  
			-->
			<div id="center-page">
				<div style="text-align: center"> 
					<c:choose>
						<c:when test="${(monthYear-1)%100 != 0}">
							<a href="<c:url value="/monthly/${monthYear-1}"/>">◀</a> 
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/monthly/${monthYear-89}"/>">◀</a> 
						</c:otherwise>
					</c:choose>
							<input type="month" id="nowDate" name="nowDate" value="${now}" />
					<c:choose>
						<c:when test="${(monthYear+1)%100 < 13 }">
							<a href="<c:url value="/monthly/${monthYear+1}"/>">▶</a> 
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/monthly/${monthYear+89}"/>">▶</a> 
						</c:otherwise>
					</c:choose>
				</div>
				<table id="month-calander">
					<tr>
						<th>SUN</th>
						<th>MON</th>
						<th>TUE</th>
						<th>WED</th>
						<th>THR</th>
						<th>FRI</th>
						<th>SAT</th>
					</tr>
					<tr>
						<c:set var="i" value="0"></c:set>
						<c:forEach begin="1" end="${startDay-1}" var="temp">
							<td style="background-color: white;"> &nbsp;</td>
							<c:set var="i" value="${temp}"></c:set>
							<!-- newline -->
						</c:forEach>
						
						<c:forEach begin="1" end="${endDay}" var="temp2">
							
								<td valign='top' align='left' width='90px' height='90px'
									style="background-color: #FFFFFF;" nowrap>
									<!-- 일자찍기 --> 
									
									<p>${temp2}</p>
									<c:set var="scDate">${monthYear*100+temp2}</c:set>
									<a href="<c:url value="/daily/${scDate}"/>">
									<c:forEach items="${monthlySchedule[scDate]}" var="sc">
										<p>${sc.scheduleTitle}</p>
									</c:forEach>
									</a>

								</td>
							
							<c:set var="i" value="${i+1}" />
							<c:choose>
								<c:when test="${i==7}">
									<c:if test="${temp2<= endDay}">
										<tr>
									</c:if>
									<c:set var="i" value="0"></c:set>
								</c:when>
							</c:choose>
							
						</c:forEach>
					</tr>
				</table>
			</div>
			<!--
			-->
			<div id="right-bookmark">
				<div class="tag-h">
					<a href="<c:url value="/"/>">Profile</a>
				</div>
				<div class="tag">
					<a href="<c:url value="/monthly"/>">Monthly</a>
				</div>
				<div class="tag">
					<a href="<c:url value="/weekly"/>">Weekly</a>
				</div>
				<div class="tag">
					<a href="<c:url value="/daily"/>">Daily</a>
				</div>
				<div class="tag">
					<a href="<c:url value="/memo"/>">Memo</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>