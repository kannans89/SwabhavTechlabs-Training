<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Current date is: <s:property value="Date"/></p>
<p>Method type is: <s:property value="methodType"/></p>
<P>Postback: <s:property value="postback"/>
<s:form action="browse" namespace="/">
<s:hidden name="postback" value="true"></s:hidden>
<s:submit value="submit"></s:submit>
</s:form>
</body>
</html>