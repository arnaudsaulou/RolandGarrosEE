<%@include file="/WEB-INF/header.jsp" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="col-3 flex-row">
        <a class="nav-link" href="${pageContext.request.contextPath}/Tournois?type=MatchSimple&genre=Femme">
            <img src="${pageContext.request.contextPath}/resources/svg/roland_garros_logo.svg" width="80" height="80" alt="Roland Garros Logo">
        </a>
        <h2 class="d-inline align-middle">Roland Garros Planer</h2>
    </div>

    <c:if test="${isConnected}">

        <div class="collapse navbar-collapse col-7 d-flex flex-row" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Tournois?type=MatchSimple&genre=Femme">
                        <button class="btn btn-outline-success btn-outline-success">Simple Femme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Tournois?type=MatchSimple&genre=Homme">
                        <button class="btn btn-outline-success btn-outline-success">Simple Homme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Tournois?type=MatchDouble&genre=Femme">
                        <button class="btn btn-outline-success btn-outline-success">Double Femme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Tournois?type=MatchDouble&genre=Homme">
                        <button class="btn btn-outline-success btn-outline-success">Double Homme</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Tournois?type=MatchDouble&genre=Mixte">
                        <button class="btn btn-outline-success btn-outline-success">Double Mixte</button>
                    </a>
                </li>
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
            </ul>
        </div>

        <div class="col-2 d-flex flex-row-reverse">
            <a class="text-decoration-none" href="${pageContext.request.contextPath}/Deconnexion">
                <div>
                    <div class="d-inline align-middle text-right">
                        <h4 class="d-inline align-middle">${user.firstname} ${user.lastname}</h4>
                        <h6>Déconnexion</h6>
                    </div>
                </div>
            </a>
        </div>

    </c:if>

</nav>

<c:if test="${isConnected}">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <c:forEach items="${breadcrumbs}" var="breadcrumb">
                <li class="breadcrumb-item">${breadcrumb}</li>
            </c:forEach>
        </ol>
    </nav>

</c:if>
