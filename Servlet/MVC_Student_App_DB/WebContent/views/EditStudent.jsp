<%@page import="com.mvc.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Student student = (Student)request.getAttribute("student");
        	String firstName = student.getFirstName();
        	String lastName = student.getLastName();
        	String college_id = student.getCollegeId();
        	String roll_no = student.getRollNo()+"";
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
<div>
<a href="/MVC_Student_App_DB/showstudent" align="right">Home</a>
<a onclick="clearStorage()" href="/MVC_Student_App_DB/logout" align="right">Logout</a>
</div>
	<form method="post" action="/MVC_Student_App_DB/editstudent?id=<%=roll_no%>" >
		<div>
			<label>First Name</label>
			<input type="text" value="<%= firstName==null ?"": firstName%>" name="first_name"/>
		</div>
		
		<div>
			<label>Roll No</label>
			<input disabled type="number" value="<%= roll_no==null ?"": roll_no%>" name="roll_no"/>
		</div>
		
		<div>
			<label>Last Name</label>
			<input type="text"  name="last_name" value="<%=lastName==null ?"": lastName%>"/>
		</div>
		<div>
			<label>CGPA</label>
			<input type="number" name="cgpa" value="<%=cgpa==null ?"": cgpa%>"/>
		</div>
		
		<div>
			<label>College ID</label>
			<input disabled type="number" name="college_id" value="<%=college_id==null ?"": college_id%>"/>
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
	
		<script>


	function clearStorage(){
		localStorage.setItem("username", "");
	}
	</script>
</body>
</html>