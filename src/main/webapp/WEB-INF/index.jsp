<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="topRow">
			<div class="goldDiv">
				<h1>Your Gold:</h1>
				<p class="gold">${gold }</p>
			</div>
			<div>
				<a class="restart" href="/clear">Start Over</a>
			</div>
		</div>
		<div class="boxWrapper">
			<div class="box">
				<h1>Farm</h1>
				<p>(earns 10-20 gold)</p>
				<a class="goldBtn" href="/farm">Find Gold!</a>
			</div>
			<div class="box">
				<h1>Cave</h1>
				<p>(earns 5-10 gold)</p>
				<a class="goldBtn" href="/cave">Find Gold!</a>
			</div>
			<div class="box">
				<h1>House</h1>
				<p>(earns 2-5 gold)</p>
				<a class="goldBtn" href="/house">Find Gold!</a>
			</div>
			<div class="box">
				<h1>Quest</h1>
				<p>(earns/takes 0-50 gold)</p>
				<a class="goldBtn" href="/quest">Find Gold!</a>
			</div>
		</div>
		<h1>Activities</h1>
		<div class="output">
			<c:forEach var="item" items="${activities }">
			<c:choose>
				<c:when test="${item.contains('earned')}">
					<p class="earned"><c:out value="${item }"/></p>
				</c:when>
				<c:otherwise>
					<p class="failed"><c:out value="${item }"/></p>
				</c:otherwise>
			</c:choose>
			</c:forEach>
		</div>
	</div>
</body>
</html>