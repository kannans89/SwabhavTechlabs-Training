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
<a href="/MVC_Student_App_DB/showstudent" align="right">Home</a>
<a onclick="clearStorage()" href="/MVC_Student_App_DB/logout" align="right">Logout</a>
</div>
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
			
			out.println("<a href=\"/MVC_Student_App_DB/showstudents?cid="+college.getCollege_id()+"\">Show students</a>");
			out.println("</div>");
			out.println("<hr/>");
		}
	%>
</div>
	<script>


	function clearStorage(){
		localStorage.setItem("username", "");
	}
	</script>
</body>
</html>