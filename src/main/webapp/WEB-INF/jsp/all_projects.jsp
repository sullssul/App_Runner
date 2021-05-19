<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Главная</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/headers/">


    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        <%@ include file = "css/allProjects.css" %>
        .row {
            width: 100%;
            min-width: 1000px;
        }

    </style>

</head>
<body>
<%@ include file="header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
<div class="container mt-5 mb-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">

            <c:forEach var="project" items="${projectList}">

                <div class="row p-2 bg-white border rounded mt-2">
                    <div class="col-md-3 mt-1">
                        <img class="img-fluid img-responsive rounded product-image"
                             src="https://static.thenounproject.com/png/203873-200.png"
                            sizes="50%">
                    </div>
                    <div class="col-md-6 mt-1">
                        <h5>${project.name}</h5>

                        <div class="d-flex flex-row">
                            <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                    class="fa fa-star"></i><i class="fa fa-star"></i></div>
                            <span>Автор: <a href="/profile/${project.user.id}">${project.user.username}</a></span>
                        </div>


                        <div class="mt-1 mb-1 spec-1"><span>Описание:<br></span>
                        </div>
                        <p class="text-justify text-truncate para mb-0">${project.description}<br><br></p>
                    </div>
                    <div class="align-items-center align-content-center col-md-3 border-left mt-1">

                        <div class="d-flex flex-column mt-1">
                            <button class="btn btn-success"  type="button">Запустить</button>
                            <button class="btn btn-outline-primary  mt-2" onclick="document.location='/project/${project.id}'" type="button">Страница проекта</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>