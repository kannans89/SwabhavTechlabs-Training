<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Banking-App/views/css/bootstrap.min.css">

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
					href="/Banking-App/transfer">Transfer</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Banking-App/withdraw">Withdraw</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/Banking-App/deposit">Deposit</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Banking-App/transactions">Transactions</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Banking-App/logout">Logout</a></li>
			</ul>

		</div>
	</nav>

	<h2>Transfer amount</h2>
	<s:form theme="bootstrap" action="transferamount">
		<div class="row mb-2 form-group">
			<label for="account-number" class="col-md-4">Account Number</label>
			<s:textfield name="account_number" type="text"
				class="ml-1 col-sm-8 form-control" placeholder="Account Number"></s:textfield>
		</div>

		<div class="row mb-2 form-group">
			<label for="amount" class="col-md-4">Amount</label>
			<s:textfield name="amount" type="text"
				class="ml-1 col-md-8 form-control" placeholder="Amount"></s:textfield>
		</div>

		<s:submit class="btn btn-primary offset-md-4 col-md-6"
			value="Transfer" />
	</s:form>
</body>
</html>