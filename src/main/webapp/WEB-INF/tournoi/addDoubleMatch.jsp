<%@include file="/WEB-INF/navbar.jsp"%>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="#" method="post">
        <h2 class="text-center mb-5">Ajouter Match Double</h2>
        <div class="form-group row">
            <label for="example-datetime-local-input" class="col-2 col-form-label">Date de début</label>
            <div class="col-10">
                <input class="form-control" type="datetime-local" value="2020-12-12T12:00:00"
                       id="example-datetime-local-input">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-2 col-form-label">Equipe A</label>
            <div class="col-10">
                <input class="form-control" type="text" placeholder="Equipe A" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-2 col-form-label">Equipe B</label>
            <div class="col-10">
                <input class="form-control" type="text" placeholder="Equipe A" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-2 col-form-label">Arbitre</label>
            <div class="col-10">
                <input class="form-control" type="text" placeholder="Arbitre" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-2 col-form-label">Terrain</label>
            <div class="col-10">
                <input class="form-control" type="text" placeholder="Terrain" required="required">
            </div>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </div>

    </form>

</div>


</body>
</html>
