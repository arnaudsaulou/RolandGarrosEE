<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/stylesheet.css">
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.3/js/bootstrap.min.js.gz"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.slim.js"></script>
</head>

<%--<c:if test="${isConnected}">--%>
<a href="">
    <button type="button" class="btn btn-secondary ml-5" style="float:right;">Nouveau</button>
</a>
<%--</c:if>--%>

<div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">Numéro de match</th>
            <th scope="col">Date</th>
            <th scope="col">Durée</th>
            <th scope="col">Joueur A</th>
            <th scope="col">Score A</th>
            <th scope="col">Joueur B</th>
            <th scope="col">Score B</th>
            <th scope="col">Arbitre</th>
            <th scope="col">Terrain</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${simpleMatchList}" var="simpleMatch">
                <tr>
                    <td class="item-simpleMatch">${simpleMatch.number}</td>
                    <td class="item-simpleMatch">${simpleMatch.date}</td>
                    <td class="item-simpleMatch">${simpleMatch.duration}</td>
                    <td class="item-simpleMatch">${simpleMatch.playerA}</td>
                    <td class="item-simpleMatch">${simpleMatch.scoreA}</td>
                    <td class="item-simpleMatch">${simpleMatch.playerB}</td>
                    <td class="item-simpleMatch">${simpleMatch.scoreB}</td>
                    <td class="item-simpleMatch">${simpleMatch.referee}</td>
                    <td class="item-simpleMatch">${simpleMatch.ground}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>



</div>




