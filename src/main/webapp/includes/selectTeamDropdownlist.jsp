<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<select class="form-control" id="team" name="team" required>
    <option disabled selected value> -- selectionner une équipe -- </option>
    <c:forEach items="${teams}" var="team">
        <option value="${team.id}">${team.firstname} ${fn:toUpperCase(team.lastname)}</option>
    </c:forEach>
</select>