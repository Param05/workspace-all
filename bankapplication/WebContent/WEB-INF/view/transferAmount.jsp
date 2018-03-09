<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="transferAction" method="post" commandName="account">
	from account:<form:input path="from_account" />
		<form:errors path="from_account" class="error" />
		<br />
		to account:<form:input path="to_account" />
		<form:errors path="to_account" class="error" />
		<br />
		Transfer amount<form:input path="amount" />
		<form:errors path="amount" class="error" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>