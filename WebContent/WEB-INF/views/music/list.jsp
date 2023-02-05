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
    <h1>MY PLAYLIST</h1>
    나의 재생목록을 확인해보세요!
    <table>
        <colgroup>
            <col style="width: '25%'; text-align: center;">
            <col style="width: '30%';">
            <col style="width: '20%';">
            <col style="width: '15%';">
            <col style="width: '10%';">
        </colgroup>
        <thead>
            <tr>
                <th>곡명</th>
                <th>가수명</th>
                <th>발매일</th>
                <th>재생시간</th>
                <th>기획사</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${mList }" var="music">
                <tr>
					<td>${music.musicTitle }</td>
					<td>${music.musicSinger }</td>
					<td>${music.musicRelease }</td>
					<td>${music.musicTime }</td>
					<td>${music.musicAgency }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="buttonTag">
        <button><a href="/music/addMusic">곡 추가</a></button>
		<button><a href="/music/modify">곡 수정</a></button>
		<button><a href="javascript:void(0);" onclick="removeCheck();">곡 삭제</a></button>
    </div>
    
    
    <script>
    function removeCheck() {
   		var mTitle = prompt("삭제할 곡의 제목을 입력하세요");

   		if(confirm("정말 해당 곡 (" + mTitle + ") 을 삭제하시겠습니까?")) {
   			
    		location.href="/music/remove?title=" + mTitle;   				
		}

    }
    </script>
    
</body>
</html>