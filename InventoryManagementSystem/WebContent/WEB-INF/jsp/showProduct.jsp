<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>product Name</th>
				<th>product Description</th>
				<th>Product price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="products">
				<tr>
					<td><c:out value="${products.productName}" /></td>
					<td><c:out value="${products.productDescription}" /></td>
					<td><c:out value="${products.productPrice}" /></td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>