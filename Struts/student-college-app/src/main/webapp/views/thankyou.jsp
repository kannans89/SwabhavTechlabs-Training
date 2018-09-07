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
<h3>Thank you for Registering</h3>

<div>
<h4>Your registration information</h4>
<p><s:property value="userBean"/></p>
</div>
<p><a href="/Welcome-Struts-App/index.html">Return to home page</a></p>

</body>
</html>