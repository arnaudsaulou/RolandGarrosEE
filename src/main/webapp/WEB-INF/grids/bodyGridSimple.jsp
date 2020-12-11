<%@include file="/WEB-INF/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des matchs simples</h3>

<c:if test="${isOrganizer}">
    <a href="${pageContext.request.contextPath}/Tournois/ajouterMatch?type=simple">
        <button type="button" class="btn btn-secondary mt-2 mr-5" style="float:right;">Ajouter</button>
    </a>
</c:if>

<div class="container">
    <table class="table">
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
        <c:forEach items="${simpleMatchList}" var="simpleMatch">
            <tr>
                <td class="text-center">${simpleMatch.number}</td>
                <td class="text-center">${simpleMatch.date}</td>
                <td class="text-center">${simpleMatch.duration}</td>
                <td class="text-center">${simpleMatch.playerA}</td>
                <td class="text-center">${simpleMatch.scoreA}</td>
                <td class="text-center">${simpleMatch.playerB}</td>
                <td class="text-center">${simpleMatch.scoreB}</td>
                <td class="text-center">${simpleMatch.referee}</td>
                <td class="text-center">${simpleMatch.ground}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>