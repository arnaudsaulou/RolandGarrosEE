<%@include file="/WEB-INF/header.jsp" %>
<%@include file="/WEB-INF/navbar.jsp" %>

<body>
<form>
    <div class="form-group row">
        <label for="example-datetime-local-input" class="col-2 col-form-label">Date de fin</label>
        <div class="col-10">
            <input class="form-control" type="datetime-local" value="2011-08-19T13:45:00" id="example-datetime-local-input">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Joueur A</label>
        <div class="col-10">
            <input class="form-control" type="text" value="playerA">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Joueur B</label>
        <div class="col-10">
            <input class="form-control" type="text" value="playerB">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Arbitre</label>
        <div class="col-10">
            <input class="form-control" type="text" value="arbitrator">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-2 col-form-label">Terrain</label>
        <div class="col-10">
            <input class="form-control" type="text" value="ground">
        </div>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block">Ajouter</button>
    </div>

</form>

</body>
