<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Создание проекта</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">


    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/checkout/">
    <script src="https://cdn.tiny.cloud/1/byxli5c6fz8kwvtf7h6vui2t0zthgkovzx9omkkczi4xc6oz/tinymce/5/tinymce.min.js"
            referrerpolicy="origin"></script>


    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap core CSS -->

    <style>
        <%@include file='css/form-validation.css' %>

        @media (min-width: 768px) {
        }

        .border-black {
            border-color: #212529;
        }

        button {
            margin: 5px 5px 5px 5px;
        }


    </style>

</head>


<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<%@ include file="header.jsp" %>

<div class="container">
    <main>
        <div class="py-5 ">
            <h2>Создание проекта</h2>
        </div>

        <div class="row g-5">
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Введите данные проекта</h4>
                <%--@elvariable id="userForm" type=""--%>
                <form:form method="POST" modelAttribute="projectForm" class="needs-validation">
                <div class="row g-3">

                    <div class="col-12">
                        <label for="name" class="form-label">Название проекта</label>
                        <form:input type="text"
                                    path="name"
                                    class="form-control"
                                    id="name"/>
                    </div>

                    <div class="col-12">
                        <label for="sourceUrl" class="form-label memo">Ссылка на исходные данные</label>
                        <form:input type="text"
                                    path="sourceUrl"
                                    class="form-control"
                                    id="sourceUrl"/>
                    </div>

                    <div class="col-12">

                        <label for="projectConfig" class="form-label memo">Конфигурация запуска</label>
                        <form:select type="text"
                                     path="projectConfig"
                                     class="form-control"
                                     id="projectConfig">
                            <c:forEach items="${configsList}" var="config">
                                <option value="${config.id}">${config.name}</option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="col-12">

                        <div class="col-12">
                            <label for="description" class="form-label memo">Описание проекта</label>
                            <form:textarea type="text"
                                           path="description"
                                           class="form-control"
                                           id="description"/>
                        </div>
                    </div>


                    <button class="w-100 btn btn-success "
                            type="submit">Создать проект
                    </button>

                    <button class="w-100 btn btn-warning border-black "
                            type="button"
                            onclick="document.location='/'">Назад
                    </button>

                    </form:form>


                </div>
            </div>
    </main>
</div>


<script>
    tinymce.init({
        selector: 'textarea',
        plugins: 'a11ychecker advcode casechange formatpainter linkchecker autolink lists checklist media mediaembed pageembed permanentpen powerpaste table advtable tinycomments tinymcespellchecker',
        toolbar: 'a11ycheck addcomment showcomments casechange checklist code formatpainter pageembed permanentpen table',
        toolbar_mode: 'floating',
        tinycomments_mode: 'embedded',
        tinycomments_author: 'Author name',
    });
</script>

</body>
</html>