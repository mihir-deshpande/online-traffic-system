<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Incidents</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Add Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNSzN9W" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Traffic System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto mt-2">
            <li class="nav-item">
                <a class="nav-link" href="#">Create Incident</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto mt-2">
            <li class="nav-item">
                <a class="nav-link" href="#">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid mt-5">
    <div class="row">
        <div class="col-md-12">
            <div class="text-center mb-4">
                <h5>Officer Details</h5>
                <p>Name: ${loggedinOfficer.getOfficerName()}</p>
                <p>Branch: ${loggedinOfficer.getBranch()}</p>
                <p>Username: ${loggedinOfficer.getUsername()}</p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div>
                <h2 class="mb-4">Reported Incidents</h2>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>Incident ID</th>
                        <th>Incident Date</th>
                        <th>Route</th>
                        <th>Vehicle ID</th>
                        <th>Vehicle Details</th>
                        <th>Vehicle Owner</th>
                        <th>Description</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${incidents}" var="incident">
                        <tr>
                            <td>${incident.getIncidentId()}</td>
                            <td>${incident.getIncidentDate()}</td>
                            <td>${incident.getRoute().getRouteName()}, ${incident.getRoute().getLocation()}</td>
                            <td>${incident.getVehicle().getVehicleId()}</td>
                            <td>${incident.getVehicle().getMake()} ${incident.getVehicle().getModel()} ${incident.getVehicle().getYear()}</td>
                            <td>${incident.getVehicle().getOwnerName()}</td>
                            <td>${incident.getDescription()}</td>
                            <td><a href="${pageContext.request.contextPath}/edit-incident/${incident.getIncidentId()}">Edit</a></td>
                            <td><a href="${pageContext.request.contextPath}/delete-incident/${incident.getIncidentId()}" onclick="return confirm('Are you sure you want to delete this incident?')">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
