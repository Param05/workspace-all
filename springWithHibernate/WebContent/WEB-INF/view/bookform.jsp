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

<form:form action="addBook" method="post" commandName="book">
	Enter book isbn:<form:input path="isbn"/><form:errors path="isbn" class="error"/><br/>
	Enter book title:<form:input path="title"/><form:errors path="title" class="error"/><br/>
	Enter book author:<form:input path="author"/><form:errors path="author" class="error"/><br/>
<%-- 	Enter Book Type: <form:select path="bookType" items="${booktypes}"/><br/> --%>
	Enter book price:<form:input path="price"/><form:errors path="isbn" class="error"/><br/><%-- 
	Enter book publish date:<form:input path="pubDate"/><form:errors path="pubDate" class="error"/><br/> --%>
	<input type ="submit"/>
</form:form>




</body>
</html>