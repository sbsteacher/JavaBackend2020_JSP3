<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<form id="frm" action="/join" method="post" onsubmit="return chk()">
			<div><input type="text" name="cid" placeholder="아이디"></div>
			<div><input type="password" name="cpw" placeholder="비밀번호"></div>
			<div><input type="password" name="recpw" placeholder="비밀번호 확인"></div>
			<div><input type="text" name="nm" placeholder="이름"></div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
	<script>
		function chk() {
			if(frm.cid.value.length == 0) {
				alert('아이디를 입력해 주세요.')
				frm.cid.focus()
				return false
			} else if(frm.cpw.value == '') {
				alert('비밀번호를 입력해 주세요.')
				frm.cpw.focus()
				return false
			} else if(frm.cpw.value != frm.recpw.value) {
				alert('비밀번호를 확인해 주세요.')
				frm.cpw.focus()
				return false
			} else if(frm.nm.value.length == 0) {
				alert('이름을 입력해 주세요.')
				frm.nm.focus()
				return false
			}			
		}
	</script>
</body>
</html>