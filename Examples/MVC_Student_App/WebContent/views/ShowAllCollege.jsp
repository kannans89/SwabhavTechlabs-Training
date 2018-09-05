<%@page import="java.util.List"%>
<%@page import="com.mvc.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<College> colleges = (List<College>)request.getAttribute("colleges");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>All Colleges</h1>
<div>
	<%
		for(College college: colleges){
			out.println("<div>");
			out.println("<p>");
			out.println("Name: "+college.getName());
			out.println("</p>");
			
			out.println("<p>");
			out.println("ID: "+college.getCollege_id());
			out.println("</p>");
			
			out.println("<p>");
			out.println("Location: "+college.getLocation());
			out.println("</p>");
			out.println("</div>");
		}
	%>
</div>
</body>
</html>