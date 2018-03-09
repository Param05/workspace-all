<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error {
	color: #EF1313;
	font-style: italic;
}
</style>

</head>
<body>
	<form:form action="addCustomer" method="post" commandName="customer">
	Enter Customer Name:<form:input path="customer_name" />
		<form:errors path="customer_name" class="error" />
		<br />
		Enter Customer EmailId:<form:input path="emailId" />
		<form:errors path="emailId" class="error" />
		<br />
		Enter Customer Password:<form:input path="password" />
		<form:errors path="password" class="error" />
		<br />
		Enter Customer Address:<form:input path="customer_address" />
		<form:errors path="customer_address" class="error" />
		<br />
		
	Enter Customer DOB:<form:input path="dateOfBirth" />
		<form:errors path="dateOfBirth" class="error" />
		<br />
 	Enter account Type: <form:select path="accountType"
			items="${customerTypes}" />
		<br />
Enter Customer Account Number:<form:input path="accountNumber" />
		<form:errors path="accountNumber" class="error" />
		<br />
		Enter Customer Account Balance:<form:input path="amount" />
		<form:errors path="amount" class="error" />
		<br />
		<input type="submit" />
	</form:form>

</body>
</html>