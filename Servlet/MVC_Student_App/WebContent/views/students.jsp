<%@page import="java.io.PrintWriter"%>
<%@page import="com.mvc.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Students List</h1>

<div style="float:right">
	<a href="/MVC_Student_App/addstudent">Add Student</a>
</div>
<%
	List<Student> students = (List<Student>) request.getAttribute("students");
	
	for(Student student:students){
		out.println("<div>");
		out.println("<p>");
		out.println("First Name: "+student.getFirstName());
		out.println("</p>");
		out.println("<p>");
		out.println("Last Name: "+student.getLastName());
		out.println("</p>");
		out.println("<p>");
		out.println("CGPA: "+student.getCgpa());
		out.println("</p>");
		out.println("<p>");
		out.println("<a href=\"/MVC_Student_App/showcollege?cid="+student.getCollegeId()+"\">College ID: "+student.getCollegeId()+"</a>");
		out.println("</p>");
		out.println("</div>");
		out.println("<div>");
		
		out.println("<a href=\"/MVC_Student_App/editstudent?id="+student.getId()+"\">Edit</a>");
		out.println("</div>");
		out.println("<hr/>");
		
	}
%>
</body>
</html>