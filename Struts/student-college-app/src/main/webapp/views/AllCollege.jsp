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

<h1>List of students</h1><span>Logged in user <s:property value="#session.username"/></span>
<a href="/student-college-app/logout">Logout</a>
<a href="/student-college-app/index.html">Home</a>
<div>
<s:iterator value="college">
	<p>ID: <s:property value="id"/></p>
	<p>Name: <s:property value="name" /></p>
	<p>Location: <s:property value="loc" /></p>
	<hr/>
</s:iterator>
</div>
</body>
</html>