<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<select class="form-control" name="matchPartB">
    <option disabled selected value> -- selectionner un joueur -- </option>
    <c:forEach items="${players}" var="player">
        <option value="${player.id}">${player.firstname} ${fn:toUpperCase(player.lastname)}</option>
    </c:forEach>
</select>