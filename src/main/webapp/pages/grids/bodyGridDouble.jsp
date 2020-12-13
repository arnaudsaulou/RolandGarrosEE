<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des matchs doubles</h3>

<c:if test="${sessionScope.isAdmin} || ${sessionScope.isOrganizer}">
    <a href="${pageContext.request.contextPath}/tournoi/ajouterResultat?type=double">
        <button type="button" class="btn btn-secondary mt-2 mr-5 mb-2" style="float:right;">Ajouter Résultat</button>
    </a>
    <a href="${pageContext.request.contextPath}/tournoi/ajouterMatch?type=double">
        <button type="button" class="btn btn-secondary mt-2 mr-5 mb-2" style="float:right;">Ajouter Match</button>
    </a>
</c:if>


<div class="container">
    <table class="table">
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
                <td class="text-center">${doubleMatchList.number}</td>
                <td class="text-center">${doubleMatchList.date}</td>
                <td class="text-center">${doubleMatchList.duration}</td>
                <td class="text-center">${doubleMatchList.teamA}</td>
                <td class="text-center">${doubleMatchList.scoreA}</td>
                <td class="text-center">${doubleMatchList.teamB}</td>
                <td class="text-center">${doubleMatchList.scoreB}</td>
                <td class="text-center">${doubleMatchList.referee}</td>
                <td class="text-center">${doubleMatchList.ground}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
