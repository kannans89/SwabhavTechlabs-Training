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
<h2>EDit Student</h2>
	<s:form action="updatestudent">
		<s:textfield name="firstName" value="%{firstName}" label="Name"></s:textfield>
		<s:textfield name="roll_no" value="%{roll_no}" label="Roll No"></s:textfield>
		<s:textfield readonly="true" name="id" value="%{id}" label="ID"></s:textfield>
		<s:textfield name="cgpi" value="%{cgpi}" label="CGPI"></s:textfield>
		<s:textfield name="col_id" value="%{col_id}" label="College ID"></s:textfield>
		<s:radio label="Gender" value="%{gender}" name="gender" list="genders"></s:radio>
		<s:submit value="Add Student"></s:submit>
	</s:form>
</body>
</html>