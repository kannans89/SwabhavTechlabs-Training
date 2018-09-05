<%@page import="com.mvc.model.College"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	College college = (College) request.getAttribute("college");
    	String id = college.getCollege_id();
    	String name = college.getName();
    	String location = college.getLocation();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>College details</h1>
<div>
<%
	out.println("<p>Name: "+name+"</p>");
	out.println("<p>ID: "+id+"</p>");
	out.println("<p>Location: "+location+"</p>");
%>
</div>
</body>
</html>