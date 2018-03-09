<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="saveproductcontroller">
		<input type="hidden" name="productId"> Product Name : <input
			type="text" name="productName" /> <br /> Product Description : <input
			type="text" name="productDescription" /> <br /> Product Price : <input
			type="text" name="productPrice" /> <br /> <input type="submit"
			value="Add New Product" />
	</form>
</body>
</html>