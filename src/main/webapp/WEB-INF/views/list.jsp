<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Customers List</title>
</head>
<body>
<h1>Customers List</h1>
<table>
  <thead>
  <tr>
    <th>User ID</th>
    <th>First Name</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="officer" items="${officers}">
    <tr>
      <td>${officer.officerId}</td>
        <td>${officer.officerName}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/customers/add">Add Customer</a>
</body>
</html>