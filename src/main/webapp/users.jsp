<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body class="text-center">
<section class="vh-100" style="background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <h2 class="fw-bold mb-2 text-uppercase">Users: </h2>
                        <table class="table table-success table-striped">
                            <c:forEach items="${userList}" var="user">
                                <tr>
                                    <td>${user.getEmail()}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <br>
                        <form action="/home.jsp" method="get" class="form-outline form-white mb-4">
                            <input type="submit" value="Go back"
                                   class="btn btn-outline-light btn-lg px-5"/>
                        </form>
                        <form action="/logout" method="post" class="form-outline form-white mb-4">
                            <input type="submit" value="Logout"
                                   class="btn btn-outline-light btn-lg px-5"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>