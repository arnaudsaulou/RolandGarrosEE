<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="${pageContext.request.contextPath}/joueurs/ajouterJoueur" method="post">
        <h2 class="text-center mb-5">Ajouter Joueur</h2>
        <div class="form-group row">
            <label class="col-3 col-form-label">Nom</label>
            <div class="col-9">
                <input class="form-control" type="text" placeholder="Nom" name="actorLastname" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Prénom</label>
            <div class="col-9">
                <input class="form-control" type="text" placeholder="Prénom" name="actorFirstname" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Nationalité</label>
            <div class="col-9">
                <%@include file="/includes/countriesDropdownList.jsp" %>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Classement</label>
            <div class="col-9">
                <input class="form-control" type="number" min="1" placeholder="Classement mondial" name="actorRankings" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Genre</label>
            <div class="col-9">
                <select class="form-control" required="required" name="actorGender">
                    <option value="HOMME">Homme</option>
                    <option value="FEMME">Femme</option>
                </select>
            </div>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </div>
        <c:if test="${errorMessage != null}">
            <div class="alert alert-danger mt-3" role="alert">
                    ${errorMessage}
            </div>
        </c:if>

    </form>

</div>

</body>
</html>