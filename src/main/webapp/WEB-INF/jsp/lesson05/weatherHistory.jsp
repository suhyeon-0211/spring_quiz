<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
	<link rel="stylesheet" href="/css/weather_style.css" style="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="d-flex background-bar">
			<div>
				<div class="logo">
					<img src="/images/logo.jfif" alt="logo" width="200">
				</div>
				<nav>
					<ul class="nav flex-column">
						<li class="nav-item"><a href="/lesson05/weather_history" class="nav-link text-light font-weight-bold">날씨</a></li>
						<li class="nav-item"><a href="/lesson05/weather_input" class="nav-link text-light font-weight-bold">날씨입력</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-light font-weight-bold">테마 날씨</a></li>
						<li class="nav-item"><a href="#" class="nav-link text-light font-weight-bold">관측 기후</a></li>
					</ul>
				</nav>
			</div>
			<div class="background-white w-100 border-bottom border-secondary">
				<h1 class="pl-4 pt-3">과거 날씨</h1>
				<table class="table text-center mx-4 mt-4">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${weatherList}" var="weather">
							<tr>
								<td><fmt:formatDate value="${weather.date}" pattern="yyyy년 MM월 dd일" /></td>
								<td>
									<c:choose>
										<c:when test="${weather.weather eq '비'}">
											<img src="/images/rainy.jpg" alt="rainy">
										</c:when>
										<c:when test="${weather.weather eq '구름조금'}">
											<img src="/images/partlyCloudy.jpg" alt="partlyCloudy">
										</c:when>
										<c:when test="${weather.weather eq '흐림'}">
											<img src="/images/cloudy.jpg" alt="cloudy">
										</c:when>
										<c:when test="${weather.weather eq '맑음'}">
											<img src="/images/sunny.jpg" alt="sunny">
										</c:when>
									</c:choose>
								</td>
								<td>${weather.temperatures}°C</td>
								<td>${weather.precipitation}mm</td>
								<td>${weather.microDust}</td>
								<td>${weather.windSpeed}km/h</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<footer class="d-flex">
			<div>
				<img src="/images/logo.jfif" alt="logo" width="200">
			</div>
			<div class="pt-3 pl-3">
				<small class="text-secondary">
					(07062) 서울시 동작구 여의대방로 16길 61<br>
					Copyright@2020 KMA. All Rights RESERVED.
				</small>
			</div>
		</footer>
	</div>
</body>
</html>