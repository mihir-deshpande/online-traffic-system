<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title>Online Ticket System</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Online Traffic System</h1>
    <h3>Welcome Officer</h3>
    <div class="row">
        <div class="col-sm-6">
            <a href="${pageContext.request.contextPath}/officer/signin" class="btn btn-primary">Login</a>
        </div>
        <div class="col-sm-6">
            <a href="${pageContext.request.contextPath}/officer/signup" class="btn btn-primary">Register</a>
        </div>
    </div>
</body>
</html>