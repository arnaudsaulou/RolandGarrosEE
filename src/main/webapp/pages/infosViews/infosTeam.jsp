<%@include file="/includes/navbar.jsp" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<body>

<h3 class="text-center mb-5 mt-5">Infos sur l'équipe</h3>

<div class="container">
    <table class="table table-bordered">
        <tr>
            <th class="text-center">Ancien joueur 1</th>
            <th class="text-center">${team.playersList[0].firstname} ${fn:toUpperCase(team.playersList[0].lastname)}</th>
        </tr>
        <tr>
            <th class="text-center">Nouveau joueur 1</th>
            <th class="text-center">
                <select class="form-control" name="teamPlayerA">
                    <option disabled selected value> -- selectionner un joueur -- </option>
                    <c:forEach items="${playersList}" var="player">
                        <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                    </c:forEach>
                </select>
            </th>
        </tr>
        <tr>
            <th class="text-center">Ancien joueur 2</th>
            <th class="text-center">${team.playersList[1].firstname} ${fn:toUpperCase(team.playersList[1].lastname)}</th>
        </tr>
        <tr>
            <th class="text-center">Nouveau joueur 2</th>
            <th class="text-center">
                <select class="form-control" name="teamPlayerB">
                    <option disabled selected value> -- selectionner un joueur -- </option>
                    <c:forEach items="${playersList}" var="player">
                        <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                    </c:forEach>
                </select>
            </th>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/equipes">
        <button type="button" class="btn btn-outline-warning mt-2 mr-5" style="float:right;">Sauvegarder</button>
    </a>
    <a href="${pageContext.request.contextPath}/equipes">
        <button type="button" class="btn btn-danger mt-2 mr-5" style="float:right;">Supprimer</button>
    </a>
</div>

</body>
</html>