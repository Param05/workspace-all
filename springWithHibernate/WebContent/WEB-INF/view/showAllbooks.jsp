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
				<th>book isbn</th>
				<th>book title</th>
				<th>book author</th>
				<th>book type</th>
				<th>book price</th>
				<th>book publish date</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="b" items="${books}">
				<tr>
					<td>${b.isbn}</td>
					<td>${b.title}</td>
					<td>${b.author}</td>
					<td>${b.bookType}</td>
					<td>${b.price}</td>
					<td>${b.pubDate}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="addBook">Add new Book</a>
</body>
</html>