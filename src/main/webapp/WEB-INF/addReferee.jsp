<%@include file="/WEB-INF/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="#" method="post">
        <h2 class="text-center mb-5">Ajouter un joueur</h2>
        <div class="form-group row">
            <label class="col-2 col-form-label">Nom de l'arbitre</label>
            <div class="col-10">
                <input class="form-control" type="text" placeholder="Nom" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-2 col-form-label">Prénom de l'arbitre</label>
            <div class="col-10">
                <input class="form-control" type="text" placeholder="Prénom" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-2 col-form-label">Nationalité de l'arbitre</label>
            <div class="col-10">
                <input class="form-control" type="text" placeholder="Nationalité" required="required">
            </div>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </div>

    </form>

</div>

</body>
</html>