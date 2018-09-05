<%@page import="java.io.PrintWriter"%>
<%@page import="com.mvc.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%    	String username = (String)session.getAttribute("username");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Students List</h1>

<div>
<a href="/MVC_Student_App_DB/showstudent" align="right">Home</a>
<a onclick="clearStorage()" href="/MVC_Student_App_DB/logout" align="right">Logout</a>
</div>
<div style="float:right">
	<a href="/MVC_Student_App_DB/addstudent">Add Student</a>
</div>
<%
	List<Student> students = (List<Student>) request.getAttribute("students");
	
	for(Student student:students){
		
		out.println("<div>");
		out.println("<p>");
		out.println("Roll No: "+student.getRollNo());
		out.println("</p>");
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
		out.println("<a href=\"/MVC_Student_App_DB/showcollege?cid="+student.getCollegeId()+"\">College ID: "+student.getCollegeId()+"</a>");
		out.println("</p>");
		out.println("</div>");
		out.println("<div>");
		
		out.println("<a href=\"/MVC_Student_App_DB/editstudent?id="+student.getRollNo()+"\">Edit</a>");
		out.println("</div>");
		out.println("<hr/>");
		
	}
%>

<script>
	localStorage.setItem('username', '<%=username %>');
	console.log("Logged in user name is "+localStorage.getItem("username"));

	function clearStorage(){
		localStorage.setItem("username", "");
	}
</script>
</body>
</html>