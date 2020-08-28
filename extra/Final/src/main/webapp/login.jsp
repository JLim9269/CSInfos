<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title><spring:message code="message.user.login.title"/></title>
<script>
	function chk(){
		var id = document.forms[0].id.value;
		var pw = document.forms[0].password.value;
		if(id==""){
			alert("아이디를 입력하세요");
			document.forms[0].id.focus();
			return false;
		}
		if(pw==""){
			alert("비밀번호를 입력하세요");
			document.forms[0].password.focus();
			return false;
		}
		location.href="updateInfo.do?id="+id+"&password="+pw;
	}
</script>
</head>
<body>
<center>
	<h1><spring:message code="message.user.login.title"/></h1>
	<a href="?lang=en"><spring:message code="message.user.login.language.en"/></a>&nbsp;&nbsp;
	<a href="?lang=ko"><spring:message code="message.user.login.language.ko"/></a>
	<hr>
	<form action="login.do"method="post">
		<table border="1"cellpadding="0"cellspacing="0">
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.id"/></td>
				<td><input name="id" value="${user.id}"></td>
			</tr>
			<tr>
				<td bgcolor="orange"><spring:message code="message.user.login.password"/></td>
				<td><input type="password"name="password"value="${user.password}"></td>
			</tr>
			<tr>
				<td colspan="2"align="center">
					<input type="submit"value='<spring:message code="message.user.login.loginBtn"/>'>
					<input type="button"value='<spring:message code="message.user.login.registBtn"/>'onclick="location.href='register.do'">
					<input type="button"value='<spring:message code="message.user.login.updateBtn"/>'onclick="return chk()">
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>