<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Officer Sign In</title>
    <!-- Add the Bootstrap CSS from the CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0-alpha1/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl7/1L_dstPt3HV5HzF6Gvk/e3s4xamKLOGMZA/XreD" crossorigin="anonymous">
</head>
<body>
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
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Sign In</button>
        </div>
    </form:form>
</div>

<!-- Add the Bootstrap JS from the CDN -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0-alpha1/js/bootstrap.bundle.min.js" integrity="sha384-EAZP5vT/k8ODbUR4vsz4u4b6CwE4Tdfs8fjNdk3yurup23T2z2XbAkUUX7FQNyzJ" crossorigin="anonymous"></script>
</body>
</html>
