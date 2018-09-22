
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="/Banking-App/views/css/bootstrap.min.css">
<sx:head />

<style>
	.errorMessage {  
    color:red;
}
.alert{}

.alert-danger{
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
				<li class="nav-item"><a class="nav-link" href="./views/jsp/register.jsp">Register</a></li>
				<li class="nav-item"><a class="nav-link" href="./views/jsp/login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="/Banking-App/transactions">Transaction</a></li>
			</ul>

		</div>
	</nav>
	<div class="container">
		<h2>Register Yourself</h2>
		<s:fielderror cssClass="alert alert-danger errorMessage"><s:param>email</s:param></s:fielderror>
		<div class="row">
			<div class="col-md-12">
				<s:form theme="bootstrap" action="addusertodb" class="form-inline">
					<div class="row mb-2 form-group">
						<label for="first name" class="col-md-4">First Name</label>
						<s:textfield name="userBean.first_name" type="text"
							class="ml-1 col-sm-8 form-control" placeholder="First Name"></s:textfield>
					</div>

					<div class="row mb-2 form-group">
						<label for="last name" class="col-md-4">Last Name</label>
						<s:textfield name="userBean.last_name" type="text"
							class="ml-1 col-md-8 form-control" placeholder="Last Name"></s:textfield>
					</div>

					<div class="row mb-2 form-group">
						<label for="email" class="col-md-4">Email</label>
						<s:textfield name="userBean.email" type="email"
							class="ml-1 col-md-8 form-control" placeholder="Email"></s:textfield>
					</div>

					<div class="row mb-2 form-group">
						<label for="username" class="col-md-4">Username</label>
						<s:textfield name="userBean.username" type="text"
							class="ml-1 col-md-8 form-control" placeholder="Username"></s:textfield>
					</div>

					<div class="row mb-2 form-group">
						<label for="password" class="col-md-4">Password</label>
						<s:textfield name="userBean.password" type="password"
							class="ml-1 col-md-8 form-control" placeholder="Password"></s:textfield>
					</div>

						<%--<div class="row mb-2 form-group">
						<label for="dob" class="col-md-4">Birth Date</label>
						<div class="col-md-8 form-control ml-1">
					 	<sx:datetimepicker name="userBean.dob"
								displayFormat="dd-MM-yyyy" />
						</div>

					</div>--%>

					<div class="row mb-2 form-group">
						<label for="contact" class="col-md-4">Contact</label>
						<s:textfield name="userBean.contact" type="text"
							class="ml-1 col-md-8 form-control" placeholder="Contact">
						</s:textfield>
					</div>
					<s:submit class="btn btn-primary offset-md-4 col-md-6"
						value="Create Account" />
				</s:form>
			</div>
		</div>
	</div>


</body>
</html>