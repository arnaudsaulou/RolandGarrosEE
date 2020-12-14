<%@include file="/includes/navbar.jsp" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<body>

<h3 class="text-center mb-5 mt-5">Infos sur l'équipe</h3>

<div class="container">
    <table class="table table-bordered">
        <tr>
            <th class="text-center">Ancien joueur 1</th>
            <th class="text-center">${team.playersList[0].firstname} ${fn:toUpperCase(team.playersList[0].lastname)}</th>
        </tr>
        <tr>
            <th class="text-center">Nouveau joueur 1</th>
            <th class="text-center"><%@include file="/includes/selectPlayerDropdownlist.jsp"%></th>
        </tr>
        <tr>
            <th class="text-center">Ancien joueur 2</th>
            <th class="text-center">${team.playersList[1].firstname} ${fn:toUpperCase(team.playersList[1].lastname)}</th>
        </tr>
        <tr>
            <th class="text-center">Nouveau joueur 2</th>
            <th class="text-center"><%@include file="/includes/selectPlayerDropdownlist.jsp"%></th>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/equipes">
        <button type="button" class="btn btn-outline-warning mt-2 mr-5" style="float:right;">Sauvegarder</button>
    </a>
    <a href="${pageContext.request.contextPath}/equipes">
        <button type="button" class="btn btn-danger mt-2 mr-5" style="float:right;">Supprimer</button>
    </a>
</div>

</body>
</html>