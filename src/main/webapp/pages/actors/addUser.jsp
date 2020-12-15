<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="${pageContext.request.contextPath}/utilisateurs/ajouterUtilisateur" method="post">
        <h2 class="text-center mb-5">Ajouter Utilisateur</h2>
        <div class="form-group row">
            <label class="col-3 col-form-label">Nom</label>
            <div class="col-9">
                <input class="form-control" type="text" placeholder="Nom" name="actorLastname" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Prénom</label>
            <div class="col-9">
                <input class="form-control" type="text" placeholder="Prénom" name="actorFirstname" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Mail</label>
            <div class="col-9">
                <input class="form-control" type="email" placeholder="Email" name="actorMail" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Mot de passe</label>
            <div class="col-9">
                <input class="form-control" type="password" placeholder="Mot de passe" name="actorPassword" required>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-3 col-form-label">Role</label>
            <div class="col-9">
                <select class="form-control" name="actorStatus" required>
                    <option disabled selected value>-- Choisir un role --</option>
                    <option value="0">Administrateur</option>
                    <option value="1">Organisateur</option>
                    <option value="2">Journaliste</option>
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