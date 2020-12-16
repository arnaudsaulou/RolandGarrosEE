<%@include file="/includes/header.jsp" %>

<nav class="navbar navbar-expand-xl navbar-light bg-light">
    <div class="navbar-brand">
        <a href="${pageContext.request.contextPath}/tournoi?type=Single&genre=Femme">
            <img src="${pageContext.request.contextPath}/resources/svg/roland_garros_logo.svg" width="70" height="70"
                 alt="Roland Garros Logo">
        </a>
        <h3 class="d-inline align-middle">Roland Garros Planer</h3>
    </div>
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <c:if test="${sessionScope.userSession != null}">

        <div class="navbar-collapse collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/tournoi?type=Single&genre=Femme">
                        <button class="btn btn-outline-success btn-outline-success">Simple Femme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/tournoi?type=Single&genre=Homme">
                        <button class="btn btn-outline-success btn-outline-success">Simple Homme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/tournoi?type=Double&genre=Femme">
                        <button class="btn btn-outline-success btn-outline-success">Double Femme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/tournoi?type=Double&genre=Homme">
                        <button class="btn btn-outline-success btn-outline-success">Double Homme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/tournoi?type=Double&genre=Mixte">
                        <button class="btn btn-outline-success btn-outline-success">Double Mixte</button>
                    </a>
                </li>
                <c:if test="${sessionScope.isOrganizer || sessionScope.isAdmin}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/joueurs">
                            <button class="btn btn-outline-success btn-outline-success">Joueurs</button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/equipes">
                            <button class="btn btn-outline-success btn-outline-success">Equipes</button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/arbitres">
                            <button class="btn btn-outline-success btn-outline-success">Arbitres</button>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.isAdmin}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/utilisateurs">
                            <button class="btn btn-outline-success btn-outline-success">Utilisateurs</button>
                        </a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="text-decoration-none" href="${pageContext.request.contextPath}/deconnexion">
                        <div>
                            <div class="d-inline align-middle text-right">
                                <h4><c:out value='${sessionScope.userSession.firstname}'/></h4>
                                <h6>Deconnexion</h6>
                            </div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </c:if>
</nav>
<c:if test="${sessionScope.userSession != null}">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <c:forEach items="${breadcrumbs}" var="breadcrumb">
                <li class="breadcrumb-item">${breadcrumb}</li>
            </c:forEach>
        </ol>
    </nav>
</c:if>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
