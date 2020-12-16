<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-6 offset-3 mt-5 mb-0">
    <form class="p-5 card bg-light text-dark mb-0" action="#${pageContext.request.contextPath}/equipes/ajouterEquipe" method="post">
        <h2 class="text-center mb-5">Ajouter Equipe</h2>
        <div class="form-group row">
            <label class="col-3 col-form-label">Nom</label>
            <div class="col-9">
                <input class="form-control" type="text" name="teamName" placeholder="Nom" required="required">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Joueur A</label>
            <div class="col-9">
                <select class="form-control" name="teamPlayerA">
                    <option disabled selected value> -- selectionner un joueur -- </option>
                    <c:forEach items="${playersList}" var="player">
                        <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-3 col-form-label">Joueur B</label>
            <div class="col-9">
                <select class="form-control" name="teamPlayerB">
                    <option disabled selected value> -- selectionner un joueur -- </option>
                    <c:forEach items="${playersList}" var="player">
                        <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                    </c:forEach>
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
