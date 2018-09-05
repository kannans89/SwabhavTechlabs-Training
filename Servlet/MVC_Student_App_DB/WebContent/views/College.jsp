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
<div>
<a href="/MVC_Student_App_DB/showstudent" align="right">Home</a>
<a onclick="clearStorage()" href="/MVC_Student_App_DB/logout" align="right">Logout</a>
</div>
<%
	out.println("<p>Name: "+name+"</p>");
	out.println("<p>ID: "+id+"</p>");
	out.println("<p>Location: "+location+"</p>");
%>
</div>

	<script>


	function clearStorage(){
		localStorage.setItem("username", "");
	}
	</script>
</body>
</html>