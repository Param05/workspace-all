<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Email ID</th>
				<th>Customer password</th>
				<th>Customer Address</th>
				<th>Date Of Birth</th>
				<th>Account Type</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="customers" items="${customers}">
				<tr>
					<td>${customers.id}</td>
					<td>${customers.customer_name}</td>
					<td>${customers.emailId}</td>
					<td>${customers.password}</td>
					<td>${customers.customer_address}</td>
					<td>${customers.dateOfBirth}</td>
					<td>${customers.accountType}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>