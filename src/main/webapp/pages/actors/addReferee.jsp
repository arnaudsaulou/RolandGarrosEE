<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="#" method="post">
        <h2 class="text-center mb-5">Ajouter Arbitre</h2>
        <div class="form-group row">
            <label class="col-3 col-form-label">Nom</label>
            <div class="col-9">
                <input class="form-control" type="text" placeholder="Nom" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Prénom</label>
            <div class="col-9">
                <input class="form-control" type="text" placeholder="Prénom" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Nationalité</label>
            <div class="col-9">
                <%@include file="/includes/countriesDropdownList.jsp" %>
            </div>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </div>

    </form>

</div>

</body>
</html>