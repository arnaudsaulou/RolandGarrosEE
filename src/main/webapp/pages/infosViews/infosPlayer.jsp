<%@include file="/includes/navbar.jsp" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<body>

<h3 class="text-center mb-5 mt-5">Infos sur ${joueur.firstname} ${fn:toUpperCase(joueur.lastname)}</h3>

<div class="container">
    <table class="table table-bordered">
        <tr>
            <th class="text-center">Prénom</th>
            <th class="text-center"><input type="text" value="${joueur.firstname}" name="firstname" placeholder="Prénom" required/></th>
        </tr>
        <tr>
            <td class="text-center">Nom</td>
            <td class="text-center"><input type="text" value="${fn:toUpperCase(joueur.lastname)}" name="lastname" placeholder="Nom" required/></td>
        </tr>
        <tr>
            <td class="text-center">Nationalité</td>
            <td class="text-center"><%@include file="/includes/countriesDropdownList.jsp"%></td>
        </tr>
        <tr>
            <td class="text-center">Classement Mondial</td>
            <td class="text-center"><input type="text" value="${joueur.rankings}" name="ranking" placeholder="Classement mondial" required/></td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/joueurs">
        <button type="button" class="btn btn-outline-warning mt-2 mr-5" style="float:right;">Sauvegarder</button>
    </a>
    <a href="${pageContext.request.contextPath}/joueurs">
        <button type="button" class="btn btn-danger mt-2 mr-5" style="float:right;">Supprimer</button>
    </a>
</div>

</body>
</html>