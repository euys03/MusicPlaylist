<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>곡 추가 페이지</title>
	<link rel="stylesheet" href="/resources/css/music.css">
</head>
	<body>
		<h1>곡 추가</h1>
		<h3>추가할 곡의 정보를 입력하세요!</h3>
		
		<div id ="register-form">
			<form action="/music/addMusic" method="post">
				<fieldset>
					<legend> ♬ ♪ ♩ ♬ ♭ </legend>
					<ul id="music-register">
						<li>
							<lablel for="music-title">곡명</lablel>
							<input type="text" id="music-title" name="music-title">
						</li>
						<li>
							<lablel for="music-singer">가수명</lablel>
							<input type="text" id="music-singer" name="music-singer">
						</li>
						<li>
							<lablel for="music-release">발매일</lablel>
							<input type="text" id="music-release" name="music-release">
						</li>
						<li>
							<lablel for="music-time">재생시간</lablel>
							<input type="text" id="music-time" name="music-time">
						</li>
						<li>
							<lablel for="music-agency">기획사</lablel>
							<input type="text" id="music-agency" name="music-agency">
						</li>
					</ul>
				</fieldset>
				<div>
					<input type="submit" value="곡 추가하기">
					<input type="reset" value="초기화">
				</div>
			</form>
		</div>
		
	</body>
</html>