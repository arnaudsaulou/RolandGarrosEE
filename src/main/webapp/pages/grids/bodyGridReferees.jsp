<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des arbitres</h3>

<a href="${pageContext.request.contextPath}/arbitres/ajouterArbitre">
    <button type="button" class="btn btn-secondary mt-2 mr-5" style="float:right;">Ajouter</button>
</a>


<div class="container col-6 offset-3 mt-5 mb-0">
    <table class="table table-hover">
        <thead class="thead-light">
        <tr class="d-flex">
            <th class="col-3 text-center">Numéro</th>
            <th class="col-3 text-center">Nom</th>
            <th class="col-3 text-center">Prénom</th>
            <th class="col-3 text-center">Nationalité</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${refereesList}" var="referee">
            <tr class="d-flex"  onclick="document.location = '${pageContext.request.contextPath}/arbitres/${referee.id}'">
                <td class="col-3 text-center">${referee.id}</td>
                <td class="col-3 text-center">${referee.lastname}</td>
                <td class="col-3 text-center">${referee.firstname}</td>
                <td class="col-3 text-center">${referee.nationality}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>