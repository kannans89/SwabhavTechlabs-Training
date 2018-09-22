<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	response.setHeader("Cache-Control", "no-cache"); // Forces caches to obtain a new copy of the page from the
	// origin server
	response.setHeader("Cache-Control", "no-store"); // Directs caches not to store the page under any circumstance
	//response.setDateHeader("Expires", 0); // Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0 backward compatibility
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Employees</h1>
	<a href="/">Home</a>
	<a href="/Spring-Struts-Hibernate/logout">Logout</a>
	<a href="/Spring-Struts-Hibernate/addemployee">Add Employee</a>
	<s:iterator value="employees" status="empCount">
		<div>
			<h3>
				Employee
				<s:property value="#empCount.count" />
			</h3>
			<p>
				ID:
				<s:property value="id" />
			</p>
			<p>
				First Name:
				<s:property value="first_name" />
			</p>
			<p>
				Last Name:
				<s:property value="last_name" />
			</p>
			<p>
				Salary:
				<s:property value="salary" />
			</p>
			<div>
				<a
					href="/Spring-Struts-Hibernate/deleteemployee?id=<s:property value="id"/>">Delete</a>
				<a
					href="/Spring-Struts-Hibernate/editemployee?id=<s:property value="id"/>">Edit</a>
			</div>
		</div>
	</s:iterator>
</body>
</html>