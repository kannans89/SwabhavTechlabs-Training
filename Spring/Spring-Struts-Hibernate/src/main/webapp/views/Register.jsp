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
	<h3>Register yourself!</h3>
	<div>
		<s:form action="registeruser">
			<s:textfield type="text" name="userBean.first_name" label="First Name"></s:textfield>
			<s:textfield type="text" name="userBean.last_name" label="Last Name"></s:textfield>
			<s:textfield type="email" name="userBean.email" label="Email"></s:textfield>
			<s:textfield type="password" name="userBean.password" label="Password"></s:textfield>
			<s:radio name="userBean.gender" list="genderList" value="defaultValue"
				label="Gender"></s:radio>
			<s:textfield type="date" name="userBean.dob" label="DOB"></s:textfield>
			<s:submit type="submit" value="Register"/>
		</s:form>
	</div>
</body>
</html>