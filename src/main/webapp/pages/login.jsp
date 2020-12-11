<%@include file="/includes/navbar.jsp" %>

<body>
<div class="col-4 offset-4 mt-5">
    <form class="p-5 card card-block bg-light text-dark" action="${pageContext.request.contextPath}/connexion" method="post">
        <h2 class="text-center mb-5">Connexion</h2>

        <div class="form-group">
            <input name="mail" type="email" class="form-control" placeholder="Email" required="required">
        </div>

        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Mot de passe" required="required">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Me connecter</button>
        </div>

        <c:if test="${error != null}">
            <div class="form-group bg-danger text-white p-2">
                <div>
                    <h6 class="m-0 pl-2">${connectionError}</h6>
                </div>
            </div>
        </c:if>
    </form>
</div>
</body>
</html>
