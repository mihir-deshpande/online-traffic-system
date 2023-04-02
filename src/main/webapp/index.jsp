<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title>Online Traffic System</title>
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