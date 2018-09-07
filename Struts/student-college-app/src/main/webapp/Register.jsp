<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<s:head/>
</head>
<body>
<h2>Register</h2>
<s:form action="register">
	<s:textfield name="userBean.firstName" label="First Name"></s:textfield>
	<s:textfield name="userBean.lastName" label="Last Name"></s:textfield>
	<s:textfield name="userBean.age" label="Age"></s:textfield>
	<s:textfield type="email" name="userBean.email" label="Email"></s:textfield>
	<s:textfield type="password" name="userBean.password" label="Password"></s:textfield>
	<s:submit value="Register"></s:submit>
</s:form>
</body>
</html>