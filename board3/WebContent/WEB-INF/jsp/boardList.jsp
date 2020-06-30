<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>		
		${loginUser.nm}님 환영합니다! 
		<a href="/boardReg"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>
					<td>${item.i_board}</td>
					<td>${item.title }</td>
					<td>${item.r_dt }</td>
					<td>${item.userNm }</td>
				</tr>
			</c:forEach>
		</table>
	</div> 
</body>
</html>



