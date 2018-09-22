<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Login yourself!</h3>
	<a href="/">Home</a>
	<div>
		<s:form action="loginuser">
			<s:textfield type="email" name="email" label="Email"></s:textfield>
			<s:textfield type="password" name="password" label="Password"></s:textfield>
			<s:submit value="Login" />
		</s:form>
	</div>

</body>
</html>