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
	<h3>College details</h3>
	<p>
		Name:
		<s:property value="college.name" />
	</p>
	<p>
		ID:
		<s:property value="college.id" />
	</p>
	<p>
		LOcation:
		<s:property value="college.loc" />
	</p>
</body>
</html>