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
	<h1>Purchase products</h1>
	<div>
		<s:form action="addtocart">


			<s:select label="Select products" headerKey="-1"
				headerValue="Select Product" list="%{productBean.productNameValue}"
				listKey="key" listValue="value" name="productBean.product_id" />
			<s:textfield type="number" name="productBean.quantity"></s:textfield>
			<s:submit value="Submit"></s:submit>
		</s:form>
	</div>

	<div>
		<h2>Your Cart</h2>
		<table id="cart-table" border="1">
			<thead>
				<tr>
					<td>#</td>
					<td>Name</td>
					<td>Quantity</td>
					<td>Unit price (Rs)</td>
					<td>Total price (Rs)</td>
					<td>Discount (%)</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<s:if test="productBean.cartProduct.size < 0">
					<tr>
						<td colspan="7">Empty</td>
					</tr>
				</s:if>
				<s:else>
					<s:iterator value="productBean.cartProduct" status="stat">
						<s:iterator>
							<tr>
								<th><s:property value="#stat.index" /></th>
								<td><s:property value="value.name" /></td>
								<td contenteditable><s:property value="key.quantity" /></td>
								<td><s:property value="value.cost" /></td>
								<td><s:property value="%{value.cost*key.quantity}" /></td>
								<td><s:property value="value.discount" /></td>
								<td><a href="<s:url value="updateproduct"  />">Update</a></td>
								<td><a
									href="/Struts-Shopping-App/deleteproduct?line_id=<s:property value="key.lineitem_id" />">Delete
								</a></td>
								<td><a href="#"
									onclick="updateproduct(event, <s:property value="#stat.index" />, <s:property value="key.lineitem_id" />)">Update
										Quantity</a></td>
							</tr>
						</s:iterator>
					</s:iterator>
				</s:else>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script>
  	function updateproduct(e, index, lid){
  		e.preventDefault();
  		
  		var index = index+1;
  		console.log(index, lid)
  		var updatedQuantity = $('#cart-table').find("tr:eq("+index+")").find("td:eq(1)").text();
  		console.log(updatedQuantity)
  		
  		var url = "http://localhost:8080/Struts-Shopping-App/updateproducts";
  		console.log(url);
  		
  		var dataObj = {
  				quantity:updatedQuantity,
  				lId: lid
  		}  		
  		
  		console.log(dataObj)
  		var data1 = JSON.stringify(dataObj); 
  		
  		console.log(data1)
  		$.ajax({
  			url: url,
  			method: "POST",
  			data: data1,
  		
  			contentType: 'application/json',
  			success: function(response){
  				console.log(response)
  			}
  		})
 }
  	
  </script>
</body>
</html>