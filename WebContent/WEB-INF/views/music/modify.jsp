<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>곡 정보 수정 페이지</title>
		<link rel="stylesheet" href="/resources/css/music.css">
	</head>
	<body>
		<h1>곡 정보 수정></h1>
		<form action="/music/modify" method="post">
			<fieldset>
				<legend>곡 정보 수정</legend>
				<ul>
					<li>
						<label>곡명</label>
						<input type="text" value="${music.musicTitle }" name="title">
					</li>
					<li>
						<label>가수명</label>
						<input type="text" value="${music.musicSinger }" name="singer">
					</li>
					<li>
						<label>발매일</label>
						<input type="text" value="${music.musicRelease }" name="release">
					</li>
					<li>
						<label>재생시간</label>
						<input type="text" value="${music.musicTime }" name="time">
					</li>
					<li>
						<label>기획사</label>
						<input type="text" value="${music.musicAgency }" name="agency">
					</li>
				</ul>
			</fieldset>
			<div class="btn-area">
				<input type="submit" value="수정">
				<input type="reset" value="초기화">
			</div>
		</form>
	</body>
</html>