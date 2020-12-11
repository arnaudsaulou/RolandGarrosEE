<%@include file="/WEB-INF/header.jsp" %>
<%@include file="/WEB-INF/navbar.jsp" %>

<body>
<div class="col-4 offset-4 mt-5">
    <form class="p-5 card card-block bg-light text-dark" action="#" method="post">
        <h2 class="text-center mb-5">Connexion</h2>

        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Nom d'utilisateur" required="required">
        </div>

        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Mot de passe" required="required">
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Me connecter</button>
        </div>
    </form>
</div>
</body>
</html>