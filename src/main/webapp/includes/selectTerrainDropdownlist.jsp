<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<select class="form-control" name="matchCourt">
    <option disabled selected value> -- selectionner un terrain -- </option>
    <c:forEach items="${matchCourt}" var="terrain">
        <option value="${terrain.id}">${terrain.name}</option>
    </c:forEach>
</select>