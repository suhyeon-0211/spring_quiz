<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
	<link rel="stylesheet" href="/css/weather_style.css" style="text/css">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
				<h1 class="pl-4 pt-3">날씨 입력</h1>
				<form method="post" action="/lesson05/input">
					<div class="d-flex justify-content-between pl-5 pt-3 pb-3">
						<div class="row">
							<label for="date" class="col-form-label">날짜</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="date" name="date">
						    </div>
						</div>
						<div class="d-flex col-3">
							<label for="weather" class="col-form-label">날씨</label>
						    <div class="col-sm-8">
						      <select class="form-control" id="weather" name="weather">
						      	<option>맑음</option>
						      	<option>구름조금</option>
						      	<option>흐림</option>
						      	<option>비</option>
						      </select>
						    </div>
						</div>
						<div class="d-flex col-4 justify-content-end">
							<label for="microDust" class="col-form-label">미세먼지</label>
						    <div class="col-sm-8">
						      <select class="form-control" id="microDust" name="microDust">
						      	<option>좋음</option>
						      	<option>보통</option>
						      	<option>나쁨</option>
						      	<option>최악</option>
						      </select>
						    </div>
						</div>
					</div>
					<div class="d-flex justify-content-between pl-5">
						<div class="row col-4">
							<label for="temperatures" class="col-form-label">기온</label>
						    <div class="input-group col-sm-10">
							  <input type="text" class="form-control" id="temperatures" name=temperatures>
							  <span class="input-group-text">°C</span>
							</div>
						</div>
						<div class="row col-4">
							<label for="precipitation" class="col-form-label">강수량</label>
						    <div class="input-group col-sm-8">
							  <input type="text" class="form-control" id="precipitation" name="precipitation">
							  <span class="input-group-text">mm</span>
							</div>
						</div>
						<div class="row col-4">
							<label for="windSpeed" class="col-form-label">풍속</label>
						    <div class="input-group col-sm-10">
							  <input type="text" class="form-control" id="windSpeed" name="windSpeed">
							  <span class="input-group-text" id="basic-addon2">km/h</span>
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-end pt-2">
						<button type="submit" class="btn btn-success mr-4">저장</button>
					</div>
				</form>
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
	
	<script>
		$(document).ready(function(){
			$("#date").datepicker();
		});
		
	</script>
</body>
</html>