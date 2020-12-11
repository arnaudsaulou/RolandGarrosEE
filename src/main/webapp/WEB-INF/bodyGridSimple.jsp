<%@include file="/WEB-INF/navbar.jsp" %>

<body>

<c:if test="${isOrganizer}">
    <a href="">
        <button type="button" class="btn btn-secondary mr-1" style="float:right;">Ajouter</button>
    </a>
</c:if>

<div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">Numero de match</th>
            <th scope="col">Date</th>
            <th scope="col">Duree</th>
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

</body>
</html>