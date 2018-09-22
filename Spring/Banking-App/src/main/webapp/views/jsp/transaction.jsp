<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%
	response.setHeader("Cache-Control", "no-cache"); // Forces caches to obtain a new copy of the page from the
	response.setHeader("Cache-Control", "no-store"); // Directs caches not to store the page under any circumstance
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0 backward compatibility
%>
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
			<ul class="navbar-nav">
			<li class="nav-item ml-auto"><a class="nav-link"
					href="/Banking-App/report">Download Report</a></li>
				<li class="nav-item ml-auto"><a class="nav-link"
					href="/Banking-App/logout"><s:property value="current_user" /></a></li>
			</ul>
		</div>
	</nav>
	<h1>Last transactions</h1>

	<div>
		<table class="container table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Type</th>
					<th scope="col">Date</th>
					<th scope="col">Receiver</th>
					<th scope="col">Amount</th>
					<th scope="col">Prev Balance</th>
					<th scope="col">New Balance</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="transactions" var="eachTransaction" status="stat">
					<tr>
						<th scope="row"><s:property value="#stat.index" /></th>
						<td><s:property value="#eachTransaction.type" /></td>
						<td><s:property value="#eachTransaction.date" /></td>
						<td><s:property value="#eachTransaction.receiver" /></td>
						<td><s:property value="#eachTransaction.amount" /></td>
						<td><s:property value="#eachTransaction.prevBalance" /></td>
						<td><s:property value="#eachTransaction.newBalance" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

</body>
</html>