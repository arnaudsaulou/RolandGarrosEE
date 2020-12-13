<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<select class="form-control" id="terrain" name="terrain">
    <option disabled selected value> -- selectionner un terrain -- </option>
    <c:forEach items="${terrains}" var="terrain">
        <option value="${terrain.id}">${terrain.firstname} ${fn:toUpperCase(terrain.lastname)}</option>
    </c:forEach>
</select>