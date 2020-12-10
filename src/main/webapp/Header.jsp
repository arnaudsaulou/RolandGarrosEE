<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%-- TODO Remove--%>
    <title>JSP - Hello World</title>
    <%-- TODO Add --%>
    <%--<title>JSP - Hello World</title>--%>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/stylesheet.css">
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/js/bootstrap.min.js.gz"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.slim.js"></script>
</head>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="col-3 flex-row">
        <img src="${pageContext.request.contextPath}/resources/svg/roland_garros_logo.svg" width="80" height="80"
             alt="Roland Garros Logo">
        <h2 class="d-inline align-middle">Roland Garros Planer</h2>
    </div>

    <%-- TODO Add--%>
    <%--<c:if test="${isConnected}">--%>

    <div class="collapse navbar-collapse col-7 d-flex flex-row" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/MatchSimple/Femme">
                    <button class="btn btn-outline-success btn-outline-success">Simple Femme</button>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/MatchSimple/Homme">
                    <button class="btn btn-outline-success btn-outline-success">Simple Homme</button>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/MatchDouble/Homme">
                    <button class="btn btn-outline-success btn-outline-success">Double Femme</button>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/MatchDouble/Homme">
                    <button class="btn btn-outline-success btn-outline-success">Double Homme</button>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/MatchDouble/Mixte">
                    <button class="btn btn-outline-success btn-outline-success">Double Mixte</button>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Joueurs">
                    <button class="btn btn-outline-success btn-outline-success">Joueurs</button>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Equipes">
                    <button class="btn btn-outline-success btn-outline-success">Equipes</button>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Arbitres">
                    <button class="btn btn-outline-success btn-outline-success">Arbitres</button>
                </a>
            </li>
        </ul>
    </div>

    <div class="col-2 d-flex flex-row-reverse">
        <a class="text-decoration-none" href="${pageContext.request.contextPath}/Deconnexion">
            <div>
                <div class="d-inline align-middle text-right">

                    <%-- TODO Add--%>
                    <%--<h4 class="d-inline align-middle">${firstname} ${lastname}</h4>--%>

                    <%-- TODO Remove--%>
                    <h4>Arnaud Saulou</h4>

                    <h6>Déconnexion</h6>
                </div>
            </div>
        </a>
    </div>

    <%-- TODO Add--%>
    <%--</c:if>--%>

</nav>

<%-- TODO Add--%>
<%--<c:if test="${isConnected}">--%>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">

        <%-- TODO Remove--%>
        <li class="breadcrumb-item"><a href="#">Match Simple</a></li>
        <li class="breadcrumb-item active" aria-current="page">Homme</li>

        <%-- TODO Add--%>
        <%--        <c:forEach items="${ancestor_breadcrumb}" var="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">${breadcrumb}</a></li>
                </c:forEach>
                <li class="breadcrumb-item active" aria-current="page">${current_breadcrumb}</li>--%>
    </ol>
</nav>

<%-- TODO Add--%>
<%--</c:if>--%>