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
	<h1>Add Employee</h1>
	<a href="/">Home</a>
	<a href="/Spring-Struts-Hibernate/logout">Logout</a>
	<s:form action="addtodb">
		<s:textfield name="employeeBean.first_name" label="First Name"></s:textfield>
		<s:textfield name="employeeBean.last_name" label="Last Name"></s:textfield>
		<s:textfield name="employeeBean.contact" label="Contact"></s:textfield>
		<s:textfield name="employeeBean.salary" label="Salary"></s:textfield>
		<s:submit>Add Employee</s:submit>
	</s:form>
</body>
</html>