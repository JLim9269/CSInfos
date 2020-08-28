<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title><spring:message code="message.user.login.registBtn"/></title>
<script>
	function chk(){
		var pass1 = document.forms[0].password.value;
		var pass2 = document.forms[0].password2.value;
		if(pass1!=pass2){
			alert("비밀번호가 서로 다릅니다.");
			document.forms[0].password.value = "";
			document.forms[0].password2.value = "";
			document.forms[0].password.focus();
			return false;
		}
	}
</script>
</head>
<body>
<center>
	<h1><spring:message code="message.user.login.registBtn"/></h1>
	<a href="?lang=en"><spring:message code="message.user.login.language.en"/></a>&nbsp;&nbsp;
	<a href="?lang=ko"><spring:message code="message.user.login.language.ko"/></a>
	<hr>
	<form action="register.do"method="post"onsubmit="return chk()">
		<table border="1"cellpadding="0"cellspacing="0">
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.id"/></td>
				<td><input name="id"required></td>
			</tr>
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.password"/></td>
				<td><input type="password"name="password"required></td>
			</tr>
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.passwordConfirm"/></td>
				<td><input type="password"name="password2"required></td>
			</tr>
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.name"/></td>
				<td><input name="name"required></td>
			</tr>
			<tr>
				<td colspan="2"align="center">
					<input type="submit"value='<spring:message code="message.user.login.registBtn"/>'>
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>