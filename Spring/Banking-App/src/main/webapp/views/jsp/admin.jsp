<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
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
					href="/Banking-App/logout">Logout</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item ml-auto"><a class="nav-link"
					href="/Banking-App/logout"><s:property value="current_user" /></a></li>
			</ul>
		</div>
	</nav>

	<h1>Account holders</h1>
	
	
	<div>
		<table class="container table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Account No</th>
					<th scope="col">Email</th>
					<th scope="col">Contact</th>
					<th scope="col">Account Status</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="adminBean.accountHoldersMap" status="stat">
					<s:iterator>
						<s:set var="status" value="value" />
						<tr>
							<th><s:property value="#stat.index" /></th>
							<td><s:property value="key.first_name" /></td>
							<td><s:property value="key.account_no" /></td>
							<td><s:property value="key.email" /></td>
							<td><s:property value="key.contact" /></td>
							<td><s:property value="value" /></td>
							<s:if test="%{#status=='Activated'}">
								<td><a href="/Banking-App/unlock?account_no=<s:property value="key.account_no"/>">Lock account</a></td>
							</s:if>
							<s:else>
								<td><a href="/Banking-App/unlock?account_no=<s:property value="key.account_no"/>">Unlock account</a></td>
							</s:else>

						</tr>
					</s:iterator>
				</s:iterator>

				<%--	<s:iterator value="adminBean.accountHolders" var="account"
					status="stat">
					<s:iterator value="adminBean.accountStatus" var="a">
						<tr>
							<th scope="row"><s:property value="#stat.index" /></th>
							<td><s:property value="#account.first_name" /></td>
							<td><s:property value="#account.account_no" /></td>
							<td><s:property value="#account.email" /></td>
							<td><s:property value="#account.contact" /></td>
							<td><s:property value="a" /></td>
							<td><a href="/Banking-App/unlock?account_no="
								<s:property value="#account.account_no"/>>Unlock account</a></td>
						</tr>
					</s:iterator>
				</s:iterator>--%>
			</tbody>
		</table>
	</div>
</body>
</html>