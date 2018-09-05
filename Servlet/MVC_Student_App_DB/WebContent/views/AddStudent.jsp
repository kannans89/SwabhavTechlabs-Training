<%@page import="com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String firstName = (String)request.getAttribute("firstName");
    	String lastName = (String)request.getAttribute("lastName");
    	String cgpa = (String)request.getAttribute("cgpa");
    	String college_id = (String) request.getAttribute("college_id");
    	String roll_no = (String) request.getAttribute("roll_no");
    	Map<String, String> colleges = (Map<String, String>) request.getAttribute("collegeNameIdMap");
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
	<a href="/MVC_Student_App_DB/showstudent" align="right">Home</a>
	<a onclick="clearStorage()" href="/MVC_Student_App_DB/logout" align="right">Logout</a>
	<form action="/MVC_Student_App_DB/addstudent" method="post">
		<div>
			<label>First Name</label>
			<input type="text" value="<%= firstName==null ?"": firstName%>" name="first_name"/>
		</div>
		
		<div>
			<label>Roll No</label>
			<input type="number" value="<%= roll_no==null ?"": roll_no%>" name="roll_no"/>
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
			<label>College</label>
			<select name="college_name">
			<%
				for(Map.Entry<String, String> entry: colleges.entrySet()){
					if(college_id != null){
						out.println("<option selected="+college_id == (entry.getKey())+" value="+entry.getKey()+">"+entry.getValue()+"</option>");
					} else{
						out.println("<option value="+entry.getKey()+">"+entry.getValue()+"</option>");
					}
					
				}
			%>
			</select>
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
	<script>


	function clearStorage(){
		localStorage.setItem("username", "");
	}
	</script>
</body>
</html>