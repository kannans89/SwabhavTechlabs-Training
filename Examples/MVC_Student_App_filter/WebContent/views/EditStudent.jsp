<%@page import="com.mvc.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Student student = (Student)request.getAttribute("student");
    	String firstName = student.getFirstName();
    	String lastName = student.getLastName();
    	int id = student.getId();
    	
    	String cgpa = student.getCgpa()+"";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Edit Student</h1>
	<form method="post" action="/MVC_Student_App/editstudent?id=<%=id%>" >
		<div>
			<label>First Name</label>
			<input type="text" value="<%= firstName==null ?"": firstName%>" name="first_name"/>
		</div>
		
		<div>
			<label>Last Name</label>
			<input type="text"  name="last_name" value="<%=lastName==null ?"": lastName%>"/>
		</div>
		<div>
			<label>CGPA</label>
			<input type="number" name="cgpa" value="<%=cgpa==null ?"": cgpa%>"/>
		</div>
		
		<div class=red>
		<%
			if(request.getAttribute("error") != null){
				out.println("<p >"+(String)request.getAttribute("error")+"</p>");
			}
		%>
		</div>
		
		<input type="submit" value="Update"/>
	</form>
</body>
</html>