<%@include file="/includes/navbar.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<body>

<h3 class="text-center mb-5 mt-5">Infos sur ${referee.firstname} ${fn:toUpperCase(referee.lastname)}</h3>

<div class="container">
    <form class="p-5 card bg-light text-dark mb-0" action="${pageContext.request.contextPath}/detailsArbitre?id=${referee.id}" method="post">
        <table class="table table-bordered">
            <tr>
                <th class="text-center">Prénom</th>
                <th class="text-center"><input type="text" class="form-control" value="${referee.firstname}"
                                               name="firstname" placeholder="Prénom" required/></th>
            </tr>
            <tr>
                <td class="text-center">Nom</td>
                <td class="text-center"><input type="text" class="form-control"
                                               value="${fn:toUpperCase(referee.lastname)}"
                                               name="lastname" placeholder="Nom" required/></td>
            </tr>
            <tr>
                <td class="text-center">Nationalité</td>
                <td class="text-center">
                    <%@include file="/includes/countriesDropdownList.jsp" %>
                </td>
            </tr>
        </table>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" name="update" class="btn btn-outline-warning mt-2 mr-5" style="float:right;">
                Sauvegarder
            </button>
        </div>
        <div class="form-group text-center mt-3 mb-0">
            <button type="submit" name="delete" class="btn btn-danger mt-2 mr-5" style="float:right;">Supprimer</button>
        </div>
    </form>
</div>

</body>
</html>