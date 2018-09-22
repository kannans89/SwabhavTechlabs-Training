<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
.errorMessage {
	color: red;
}

.alert {
	
}

.alert-danger {
	color:
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/Banking-App/">Bank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="./views/jsp/register.jsp">Register</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./views/jsp/login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Banking-App/transactions">Transaction</a></li>
			</ul>

		</div>
	</nav>
	<h1>Login</h1>
	<s:fielderror cssClass="alert alert-danger errorMessage">
		<s:param>activate</s:param>
	</s:fielderror>
	<s:fielderror cssClass="alert alert-danger errorMessage">
		<s:param>errorAuth</s:param>
	</s:fielderror>

	<s:if test="hasActionMessages()">
		<div class="alert alert-danger errorMessage">
			<s:actionmessage />
		</div>
	</s:if>
	
	<div class="container">
		<h1>
			<s:property value="%{error1}" />
		</h1>
		<s:form theme="bootstrap" action="loginuser" class="form-inline">
			<div class="row mb-2 form-group">
				<label for="first name" class="col-md-4">Email</label>
				<s:textfield name="email" type="email"
					class="ml-1 col-sm-8 form-control" placeholder="Email"></s:textfield>
			</div>

			<div class="row mb-2 form-group">
				<label for="first name" class="col-md-4">Password</label>
				<s:textfield name="password" type="password"
					class="ml-1 col-sm-8 form-control" placeholder="Password"></s:textfield>
			</div>
			<s:submit class="btn btn-primary offset-md-4 col-md-6" value="Login" />
		</s:form>
	</div>
</body>
</html>