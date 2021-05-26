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
    <title>Личный профиль</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>

        <%@include file='css/profile.css' %>
    </style>


</head>
<body>
<%@ include file="header.jsp" %>


<div class="container emp-profile">
    <form method="post">
        <div class="row">
            <div class="col-md-4">
                <div class="profile-img">
                    <img src="https://www.pngitem.com/pimgs/m/504-5040528_empty-profile-picture-png-transparent-png.png"
                         width="640"
                         height="640"
                         alt="img"/>
                    <div class="file btn btn-lg btn-primary">
                        Сменить фото
                        <input type="file" name="file"/>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="profile-head">
                    <h5>
                        ${user.firstName}
                        ${user.lastName}
                    </h5>

                    <h6>
                        ${user.shortMemo}
                    </h6>

                    <ul class="nav nav-tabs" id="myTab" role="tablist">

                        <li class="nav-item">
                            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#profile" role="tab"
                               aria-controls="profile" aria-selected="true">О себе</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" id="profile-tab" data-toggle="tab" href="#projects" role="tab"
                               aria-controls="projects" aria-selected="false">Проекты</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-2">
                <c:if test="${isCurrentUser}" >
                    <button type="button"
                            class="profile-edit-btn"
                            onclick="document.location='/profile/editprofile/<sec:authentication
                                    property="principal.id"/>'"
                    >Изменить профиль
                    </button>
                </c:if>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="profile-work">

                </div>
            </div>
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Никнейм</label>
                            </div>
                            <div class="col-md-6">
                                <p>
                                    ${user.username}
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>
                                    ФИО
                                </label>
                            </div>
                            <div class="col-md-6">
                                <p>
                                    ${user.firstName}
                                    ${user.lastName}
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email</label>
                            </div>
                            <div class="col-md-6">
                                <p>
                                    ${user.email}
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Дата регистрации</label>
                            </div>
                            <div class="col-md-6">
                                <p>
                                    ${user.registeringDate}
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>О себе</label>
                            </div>
                            <div class="col-md-6">
                                <p>
                                    ${user.memo}
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="projects" role="tabpanel" aria-labelledby="projects-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Experience</label>
                            </div>
                            <div class="col-md-6">
                                <p>Expert</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Hourly Rate</label>
                            </div>
                            <div class="col-md-6">
                                <p>10$/hr</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Total Projects</label>
                            </div>
                            <div class="col-md-6">
                                <p>230</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>English Level</label>
                            </div>
                            <div class="col-md-6">
                                <p>Expert</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Availability</label>
                            </div>
                            <div class="col-md-6">
                                <p>6 months</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Your Bio</label><br/>
                                <p>Your detail description</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>



</body>
</html>