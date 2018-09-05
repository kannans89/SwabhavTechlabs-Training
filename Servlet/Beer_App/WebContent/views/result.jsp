<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Beer Recommendations</h1>
	<p>
	<%
		List<String> brands = (List)request.getAttribute("brands");
		for(String brand:brands){
			out.print("<br/>try: "+brand);
		}
	%>
	</p>
</body>
</html>