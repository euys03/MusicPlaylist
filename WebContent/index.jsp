<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 선언문 작성 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>플레이리스트 페이지</title>
    <link rel="stylesheet" href="/resources/css/music.css">
</head>
<body>
    <h1>플레이리스트 웹</h1>
    <h2>♬ 나만의 플레이리스트를 만들어보세요 ♬</h2>

    <div class="addbtn">
        <button><a href="/music/addMusic">곡 추가</a></button>
        <button><a href="/music/list">내 플레이리스트</a></button>
    </div>
    
</body>
</html>