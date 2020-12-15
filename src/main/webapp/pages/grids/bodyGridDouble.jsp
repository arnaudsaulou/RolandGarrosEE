<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des matchs doubles</h3>

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
            <th class="text-center">Equipe A</th>
            <th class="text-center">Score A</th>
            <th class="text-center">Equipe B</th>
            <th class="text-center">Score B</th>
            <th class="text-center">Arbitre</th>
            <th class="text-center">Terrain</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${doubleMatchList}" var="doubleMatch">
            <tr>
                <td class="text-center">${doubleMatch.id}</td>
                <td class="text-center">${doubleMatch.dateBegin}</td>
                <td class="text-center">${doubleMatch.dateEnd}</td>
                <td class="text-center">${doubleMatch.teamsList[0].name}</td>
                <td class="text-center">${doubleMatch.scoreA}</td>
                <td class="text-center">${doubleMatch.teamsList[1].name}</td>
                <td class="text-center">${doubleMatch.scoreB}</td>
                <td class="text-center">${doubleMatch.referee.firstname} ${doubleMatch.referee.lastname}</td>
                <td class="text-center">${doubleMatch.court.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
