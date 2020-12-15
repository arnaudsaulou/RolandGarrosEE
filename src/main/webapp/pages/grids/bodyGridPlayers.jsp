<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des joueurs</h3>

<a href="${pageContext.request.contextPath}/joueurs/ajouterJoueur">
    <button type="button" class="btn btn-secondary mt-2 mr-5" style="float:right;">Ajouter</button>
</a>

<div class="container">
    <table class="table table-hover">
        <thead class="thead-light">
        <tr>
            <th class="text-center">Numéro</th>
            <th class="text-center">Nom</th>
            <th class="text-center">Prénom</th>
            <th class="text-center">Nationalité</th>
            <th class="text-center">Genre</th>
            <th class="text-center">Classement mondial</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${playersList}" var="player">
            <tr onclick="document.location = '${pageContext.request.contextPath}/players/${player.id}'">
                <td class="text-center">${player.id}</td>
                <td class="text-center">${player.lastname}</td>
                <td class="text-center">${player.firstname}</td>
                <td class="text-center">${player.nationality}</td>
                <td class="text-center">${player.gender}</td>
                <td class="text-center">${player.rankings}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>