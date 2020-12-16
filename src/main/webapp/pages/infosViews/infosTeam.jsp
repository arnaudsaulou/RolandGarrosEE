<%@include file="/includes/navbar.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<body>

<h3 class="text-center mb-5 mt-5">Infos sur l'équipe</h3>

<div class="container">
    <form class="p-5 card bg-light text-dark mb-0"
          action="${pageContext.request.contextPath}/detailsEquipe?id=${team.id}" method="post">
        <table class="table table-bordered">
            <tr>
                <th class="text-center">Ancien joueur 1</th>
                <th class="text-center">${team.playersList[0].firstname} ${fn:toUpperCase(team.playersList[0].lastname)}</th>
            </tr>
            <tr>
                <th class="text-center">Nouveau joueur 1</th>
                <th class="text-center">
                    <select class="form-control" name="teamPlayerA">
                        <option disabled selected value> -- selectionner un joueur --</option>
                        <c:forEach items="${playersList}" var="player">
                            <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                        </c:forEach>
                    </select>
                </th>
            </tr>
            <tr>
                <th class="text-center">Ancien joueur 2</th>
                <th class="text-center">${team.playersList[1].firstname} ${fn:toUpperCase(team.playersList[1].lastname)}</th>
            </tr>
            <tr>
                <th class="text-center">Nouveau joueur 2</th>
                <th class="text-center">
                    <select class="form-control" name="teamPlayerB">
                        <option disabled selected value> -- selectionner un joueur --</option>
                        <c:forEach items="${playersList}" var="player">
                            <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
                        </c:forEach>
                    </select>
                </th>
            </tr>
        </table>
        <div>
            <button type="submit" name="update" class="btn btn-outline-warning mt-2 mr-5" style="float:right;">
                Sauvegarder
            </button>
        </div>
        <div>
            <button type="submit" name="delete" class="btn btn-danger mt-2 mr-5" style="float:right;">Supprimer</button>
        </div>
    </form>
</div>

</body>
</html>