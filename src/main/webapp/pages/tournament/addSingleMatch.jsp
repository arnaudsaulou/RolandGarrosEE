<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0"
          action="${pageContext.request.contextPath}/tournoi/ajouterMatch?type=${type}&genre=${genre}" method="post">
        <h2 class="text-center mb-5">Ajouter Match Simple</h2>
        <div class="form-group row">
            <label for="example-datetime-local-input" class="col-3 col-form-label">Date de début</label>
            <div class="col-8">
                <input class="form-control" type="datetime-local" value="2020-12-12T12:00:00"
                       name="matchStartDate" id="example-datetime-local-input" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Joueur A</label>
            <div class="col-8">
                <select class="form-control" name="matchPartA">
                    <option disabled selected value> -- selectionner un joueur --</option>
                    <c:forEach items="${matchPartA}" var="player">
                        <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Joueur B</label>
            <div class="col-8">
                <select class="form-control" name="matchPartB">
                    <option disabled selected value> -- selectionner un joueur --</option>
                    <c:forEach items="${matchPartB}" var="player">
                        <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Arbitre</label>
            <div class="col-8">
                <%@include file="/includes/selectRefereeDropdownlist.jsp" %>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Terrain</label>
            <div class="col-8">
                <%@include file="/includes/selectTerrainDropdownlist.jsp" %>
            </div>
        </div>
        <div class="form-group text-center mt-3 mb-1">
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </div>
        <c:if test="${errorMessage != null}">
            <div class="alert alert-danger" role="alert">
                    ${errorMessage}
            </div>
        </c:if>

    </form>

</div>

</body>
</html>