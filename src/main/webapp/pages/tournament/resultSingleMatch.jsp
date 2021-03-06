<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="${pageContext.request.contextPath}/tournoi/ajouterResultat?type=${type}&idMatch=${idMatch}" method="post">
        <h2 class="text-center mb-5">Résultat Match Simple</h2>
        <div class="form-group row">
            <label for="example-datetime-local-input" class="col-3 col-form-label">Date de fin</label>
            <div class="col-8">
                <input class="form-control" type="datetime-local" value="2020-12-12T14:00:00" name="matchEndDate"
                       id="example-datetime-local-input">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Score Joueur A</label>
            <div class="col-8">
                <select class="form-control" id="scoreJoueurA" name="matchScoreA" required>
                    <c:forEach var="i" begin="0" end="3" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Score Joueur B</label>
            <div class="col-8">
                <select class="form-control" id="scoreJoueurB" name="matchScoreB" required>
                    <c:forEach var="i" begin="0" end="3" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>>
                </select>
            </div>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" name="add" value="Add Button" class="btn btn-primary">Ajouter</button>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" name="delete" value="Delete Button" class="btn btn-primary">Delete</button>
        </div>

    </form>

</div>


</body>
</html>
