<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des matchs simples</h3>

<c:if test="${sessionScope.isAdmin || sessionScope.isOrganizer}">
    <a href="${pageContext.request.contextPath}/tournoi/ajouterResultat?type=${type}&genre=${genre}">
        <button type="button" class="btn btn-secondary mt-2 mr-5 mb-2" style="float:right;">Ajouter Résultat</button>
    </a>
    <a href="${pageContext.request.contextPath}/tournoi/ajouterMatch?type=${type}&genre=${genre}">
        <button type="button" class="btn btn-secondary mt-2 mr-5 mb-2" style="float:right;">Ajouter Match</button>
    </a>
</c:if>

<div class="container">
    <table class="table table-hover">
        <thead class="thead-light">
        <tr>
            <th class="text-center">Numéro</th>
            <th class="text-center">Date</th>
            <th class="text-center">Durée</th>
            <th class="text-center">Joueur A</th>
            <th class="text-center">Score A</th>
            <th class="text-center">Joueur B</th>
            <th class="text-center">Score B</th>
            <th class="text-center">Arbitre</th>
            <th class="text-center">Terrain</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${singleMatchList}" var="singleMatch">
            <tr>
                <td class="text-center">${singleMatch.id}</td>
                <td class="text-center">${singleMatch.dateBegin}</td>
                <td class="text-center">${singleMatch.dateBegin}</td><%-- TODO Duration --%>
                <td class="text-center">${singleMatch.playersList[0].firstname} ${singleMatch.playersList[0].lastname}</td>
                <td class="text-center">${singleMatch.scoreA}</td>
                <td class="text-center">${singleMatch.playersList[1].firstname} ${singleMatch.playersList[1].lastname}</td>
                <td class="text-center">${singleMatch.scoreB}</td>
                <td class="text-center">${singleMatch.referee.firstname} ${singleMatch.referee.lastname}</td>
                <td class="text-center">${singleMatch.court.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>