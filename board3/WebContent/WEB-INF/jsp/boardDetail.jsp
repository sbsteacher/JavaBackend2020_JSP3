<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
	${loginUser.i_user }, ${data.i_user }
	<c:if test="${loginUser.i_user == data.i_user }">
		<div>
			<button>수정</button>
			<a href="/boardDel?i_board=${data.i_board}"><button>삭제</button></a>
		</div>
	</c:if>
	<div>
		<button onclick="doLike(${data.i_board})">
			<span id="markLike">♡</span>좋아요
		</button>
	</div>
	<div>
		${msg }
	</div>
	<div>
		${data.title }, ${data.ctnt }, ${data.r_dt }, ${data.userNm }
	</div>
	<script>
		function doLike(i_board) {
			axios.get('/boardLike', {
				params: {
					i_board:i_board
				}
			}).then(function(res) {
				if(res.data.result == 1) {
					markLike.innerHTML = '♥'
				} else {
					markLike.innerHTML = '♡'
				}
				//console.log(JSON.stringify(res))
			})
		}
	</script>
</body>
</html>