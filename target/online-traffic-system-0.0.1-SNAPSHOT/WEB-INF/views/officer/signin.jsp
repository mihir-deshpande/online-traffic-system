<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Officer Sign In</title>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <!-- Add Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNSzN9W"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <style>
        .submit-button {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Traffic System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02"
            aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto mt-2">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/incident/incidents">Dashboard</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/incident/create">Create Incident</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto mt-2">
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/officer/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1>Officer Sign In</h1>
    <form:form action="#" modelAttribute="officer" method="post" cssClass="row g-3">
        <div class="col-md-6">
            <label for="username" class="form-label">Username:</label>
            <form:input path="username" id="username" cssClass="form-control" required="true" />
        </div>
        <div class="col-md-6">
            <label for="password" class="form-label">Password:</label>
            <form:password path="password" id="password" cssClass="form-control" required="true" />
        </div>
        <br/><br/>
        <div class="col-12 mb-3 submit-button">
            <button type="submit" class="btn btn-primary">Sign In</button>
        </div>
    </form:form>
</div>

<!-- Add the Bootstrap JS from the CDN -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0-alpha1/js/bootstrap.bundle.min.js" integrity="sha384-EAZP5vT/k8ODbUR4vsz4u4b6CwE4Tdfs8fjNdk3yurup23T2z2XbAkUUX7FQNyzJ" crossorigin="anonymous"></script>
</body>
</html>
