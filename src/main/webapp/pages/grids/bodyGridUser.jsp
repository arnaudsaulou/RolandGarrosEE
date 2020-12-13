<%@include file="/includes/navbar.jsp" %>

<body>

<h3 class="text-center mb-5 mt-5">Liste des utilisateurs</h3>

<c:if test="${sessionScope.isAdmin}">
    <a href="${pageContext.request.contextPath}/utilisateurs/ajouterUtilisateur">
        <button type="button" class="btn btn-secondary mt-2 mr-5" style="float:right;">Ajouter</button>
    </a>
</c:if>

<div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th class="text-center">Numéro</th>
            <th class="text-center">Prénom</th>
            <th class="text-center">Nom</th>
            <th class="text-center">Mail</th>
            <th class="text-center">Statut</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td class="text-center">${user.id}</td>
                <td class="text-center">${user.firstname}</td>
                <td class="text-center">${user.lastname}</td>
                <td class="text-center">${user.mail}</td>
                <td class="text-center">${user.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
