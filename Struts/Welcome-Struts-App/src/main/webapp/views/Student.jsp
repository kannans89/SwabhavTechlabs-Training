<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List of students</h1><span>Logged in user <s:property value="#session.username"/></span>
<a href="/Welcome-Struts-App/addstudent">Add Student</a>
<a href="/Welcome-Struts-App/logout">Logout</a>
<a href="/Welcome-Struts-App/index.html">Home</a>
<div>
<s:iterator value="students">
	<p>Name: <s:property value="firstName"/></p>
	<p>Roll No: <s:property value="roll_no" /></p>
	<p>ID: <s:property value="id" /></p>
	<p>CGPI: <s:property value="cgpi" /></p>
	<p>Gender: <s:property value="gender" /></p>
	<a href="/Welcome-Struts-App/editstudent?id=<s:property value="id" />">Edit</a>
	<a onclick="confirmDelete(<s:property value="id" />)" href="javascript:void(0);">Delete</a>
	<hr/>
</s:iterator>

</div>

<script>
function confirmDelete(id){
	console.log("inside confirm");
	var result = confirm("Confirm delete?");
	if(!result){
		console.log("inside result if")
		return false;
		//swindow.location.href = (this.document);
	} else{
		console.log(id)
		window.location.href = "http://localhost:8080/Welcome-Struts-App/deletestudent?id="+id
	}
	
	
}

</script>
</body>
</html>