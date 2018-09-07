<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<s:head />
</head>
<body>
	<h2>Add Student</h2>
	<s:form action="addstudenttodb">
		<s:textfield name="studentBean.firstName" value="" label="Name"></s:textfield>
		<s:textfield name="studentBean.roll_no" label="Roll No"></s:textfield>
		<s:textfield name="studentBean.id" label="ID"></s:textfield>
		<s:textfield name="studentBean.cgpi" label="CGPI"></s:textfield>
		<s:select label="Select your college ID" headerKey="-1"
			headerValue="Select College ID" list="colleges" name="college_name"/>
		<s:radio label="Gender" name="studentBean.gender" list="genders"
			value="defaultGender"></s:radio>
		<s:submit value="Add Student"></s:submit>
	</s:form>
</body>
</html>