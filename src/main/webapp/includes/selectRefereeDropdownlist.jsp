<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<select class="form-control" name="matchReferee">
    <option disabled selected value> -- selectionner un arbitre -- </option>
    <c:forEach items="${referees}" var="referee">
        <option value="${referee.id}">${referee.firstname} ${fn:toUpperCase(referee.lastname)}</option>
    </c:forEach>
</select>