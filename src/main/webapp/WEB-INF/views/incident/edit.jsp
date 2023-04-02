<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Incident</title>
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

<div class="container-fluid mt-5">
    <div class="row">
        <div class="col-md-12">
            <h2>Edit Incident</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <form method="POST" action="${pageContext.request.contextPath}/incident/create">
                <input type="hidden" name="incidentId" id="incidentId" value="${incident.getIncidentId()}" />
                <div class="form-group">
                    <label for="vehicleId">Vehicle:</label>
                    <select name="vehicleId" id="vehicleId" class="form-control">
                        <c:forEach items="${vehicles}" var="vehicle">
                            <option value="${vehicle.getVehicleId()}" ${vehicle.getVehicleId() == incident.vehicle.getVehicleId() ? 'selected' : ''}>${vehicle.getVehicleId()}  -  ${vehicle.getMake()} ${vehicle.getModel()} ${vehicle.getYear()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="routeId">Route:</label>
                    <select name="routeId" id="routeId" class="form-control">
                        <c:forEach items="${routes}" var="route">
                            <option value="${route.getRouteId()}" ${route.getRouteId() == incident.route.getRouteId() ? 'selected' : ''}>${route.getRouteName()}, ${route.getLocation()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea name="description" id="description" class="form-control">${incident.getDescription()}</textarea>
                </div>
                <div class="form-group">
                    <label for="date">Date:</label>
                    <input type="date" name="date" id="date" class="form-control" value="${incident.getIncidentDate()}">
                </div>
                <button type="submit" class="btn btn-primary">Update Incident</button>
            </form>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
