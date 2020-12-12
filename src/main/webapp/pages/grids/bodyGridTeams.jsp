<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des équipes</h3>

<a href="${pageContext.request.contextPath}/equipes/ajouterEquipe">
    <button type="button" class="btn btn-secondary mt-2 mr-5" style="float:right;">Ajouter</button>
</a>

<div class="container">
    <table class="table">
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
            <tr class="d-flex">
                <td class="col-3 text-center">${team.number}</td>
                <td class="col-3 text-center">${team.name}</td>
                <td class="col-3 text-center">${team.playerA}</td>
                <td class="col-3 text-center">${team.playerB}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>