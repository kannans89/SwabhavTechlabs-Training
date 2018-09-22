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
<h1>Edit Employee</h1>
<div>
	<s:form action="updateemployee">
		<s:textfield name="updateEmployeeBean.first_name" value="%{employeeBean.first_name}" label="First Name"></s:textfield>
		<s:textfield name="updateEmployeeBean.last_name" value="%{employeeBean.last_name}" label="Last Name"></s:textfield>
		<s:textfield name="updateEmployeeBean.contact" value="%{employeeBean.contact}" label="Contact"></s:textfield>
		<s:textfield name="updateEmployeeBean.salary" value="%{employeeBean.salary}" label="Salary"></s:textfield>
		<s:submit>Add Employee</s:submit>
	</s:form>
</div>
</body>
</html>