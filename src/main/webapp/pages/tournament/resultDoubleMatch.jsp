<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="#" method="post">
        <h2 class="text-center mb-5">Résultat Match Double</h2>
        <div class="form-group row">
            <label form="form-group row">Durée du match</label>
            <div class="col-8">
                <input type="time" id="tempsDeJeu" name="tempsDeJeu" min="00:00" max="24:00" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Score Equipe A</label>
            <div class="col-8">
                <select id="scoreEquipeA" name="scoreEquipeA">
                    <c:forEach var="i" begin="0" end="5" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Score Equipe B</label>
            <div class="col-8">
                <select id="scoreEquipeB" name="scoreEquipeB">
                    <c:forEach var="i" begin="0" end="5" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>>
                </select>
            </div>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </div>

    </form>

</div>


</body>
</html>
