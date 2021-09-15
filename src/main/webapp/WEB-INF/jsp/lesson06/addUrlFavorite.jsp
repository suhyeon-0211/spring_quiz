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
			<div class="d-flex justify-content-between">
				<input type="text" class="form-control col-11" id="url" name="url">
				<button type="button" class="btn btn-primary" id="isDuplicationBtn">중복확인</button>
			</div>
			<div id="urlStatusArea"></div>
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
				if (!url.startsWith("http") && !url.startsWith("https")) {
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
					// ,dataType: 'json' // response body에 내려질 데이터 타입
					, success : function(data) {
						// AJAX 통신후 response body는 String 또는 JSON이 리턴되어야 한다.
						if (data.result == 'success') {
							location.href = "/lesson06/quiz01/after_add_url";	
						} else {
							alert("실패했습니다.");
						}
						
					}
					, error : function(e) {
						alert("에러 " + e);
					}
				});
			});
			
			$('#isDuplicationBtn').on('click', function() {
				let url = $('input[name=url]').val().trim();
				$('#urlStatusArea').empty();
				
				if (url == '') {
					$('#urlStatusArea').append("<small class='text-danger'>url을 입력해주세요</small>");
					return;
				}
				
				$.ajax({
					type : 'GET'
					, url : '/lesson06/quiz02/is_duplication'
					, data : {'url' : url}
					, success : function(data) {
						if (data.isDuplication) {
							$('#urlStatusArea').append("<small class='text-danger'>중복된 url입니다</small>");
						} else {
							$('#urlStatusArea').append("<small class='text-success'>저장 가능한 url입니다.</small>");
						}
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