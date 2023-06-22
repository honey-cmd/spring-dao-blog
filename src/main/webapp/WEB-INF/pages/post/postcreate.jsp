<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js">
	
</script>
</head>
<body>
	<div class="container py-5">
		<div class="d-flex justify-content-between">
			<h3>User List</h3>
			<div>
				<c:url var="searchPost" value="/posts/search" />
				<form action="${searchPost}" method="GET" class="d-flex">
					<input type="text" name="search" class="form-control"
						placeholder="Search....." />
					<button type="submit" class="btn btn-success ml-3">Search</button>
				</form>
			</div>
			<c:url var="createJSP" value="/create" />
			<a class="inline-block btn btn-primary" href="${createJSP}">Add
				New</a>
		</div>
		<div class="table-responsive py-5">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Description</th>
					<th>Created_at</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${postList}" var="post">
					<tr>
						<td>${post.id}</td>
						<td>${post.title}</td>
						<td>${post.description}</td>
			             <td>${post.created_at}</td>

						<td><c:url value="/update" var="updateDb">
								<c:param name="updateId" value="${post.id}"></c:param>
							</c:url> <a class="btn btn-info" href="${updateDb}">Edit</a> <c:url
								value="/delete" var="deleteDb">
								<c:param name="id" value="${post.id}"></c:param>
							</c:url> <a class="btn btn-danger" href="${deleteDb}">Delete</a></td>


					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>