<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<%-- ajax를 사용하려면 더 많은 함수가 있는 jquery js를 포함해야한다. --%>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" class="form-control" id="name" name="name">
		</div>
		<div class="form-group">
			<label for="url">주소</label>
			<input type="text" class="form-control" id="url" name="url">
		</div>
		<button type="button" class="btn btn-success w-100" id="addBtn">추가</button>
	</div>
	
	<script>
		$(document).ready(function() {
			$('#addBtn').on('click', function(e) {
				let name = $('input[name=name]').val().trim();
				let url = $('input[name=url]').val().trim();
				if (name == '') {
					alert("제목을 입력하세요.");
					return;
				}
				if (url == '') {
					alert("주소를 입력하세요.");
					return;
				}
				if (!url.includes("http") && !url.includes("https")) {
					alert("주소를 다시 확인하여 입력하세요.");
					return;
				}
				
				$.ajax({
					type: 'POST'
					, url: '/lesson06/quiz01/add_url'
					, data: {
						'name' : name
						, 'url' : url
					}
					, success : function(data) {
						alert(data);
						location.href = "/lesson06/quiz01/after_add_url";
					}
					, error : function(e) {
						alert("에러 " + e);
					}
				});
			});
		});
	</script>
</body>
</html>