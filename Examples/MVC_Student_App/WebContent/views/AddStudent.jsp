<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String firstName = (String)request.getAttribute("firstName");
    	String lastName = (String)request.getAttribute("lastName");
    	String cgpa = (String)request.getAttribute("cgpa");
    	String college_id = (String) request.getAttribute("college_id");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.red{
	color: red;
	}
</style>
</head>
<body>
	<h1 align="center">Add Student</h1>
	<a href="" align="right">Logout</a>
	<form action="/MVC_Student_App/addstudent" method="post">
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
		<div>
			<label>College ID</label>
			<input type="text" name="college_id" value="<%=college_id==null ?"": college_id%>"/>
		</div>
		
		<div class=red>
		<%
			if(request.getAttribute("error") != null){
				out.println("<p >"+(String)request.getAttribute("error")+"</p>");
			}
		%>
		</div>
		
		<input type="submit" value="Add"/>
	</form>
</body>
</html>