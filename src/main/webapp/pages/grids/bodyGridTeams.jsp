<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des équipes</h3>

<a href="${pageContext.request.contextPath}/equipes/ajouterEquipe">
    <button type="button" class="btn btn-secondary mt-2 mr-5" style="float:right;">Ajouter</button>
</a>

<div class="container">
    <table class="table table-hover">
        <thead class="thead-light">
        <tr class="d-flex">
            <th class="col-3 text-center">Numéro</th>
            <th class="col-3 text-center">Nom</th>
            <th class="col-3 text-center">Joueur A</th>
            <th class="col-3 text-center">Joueur B</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teamsList}" var="team">
            <tr class="d-flex" onclick="document.location = '${pageContext.request.contextPath}/detailsEquipe?id=${team.id}'">
                <td class="col-3 text-center">${team.id}</td>
                <td class="col-3 text-center">${team.name}</td>
                <c:forEach items="${team.playersList}" var="player">
                    <td class="col-3 text-center">${player.lastname} ${player.firstname}</td>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
