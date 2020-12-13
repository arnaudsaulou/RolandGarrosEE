package com.cactus.RolandGarrosEE.controller;

public class Constantes {

    //region Session

    public static final String SESSION_USER = "userSession";
    public static final String SESSION_IS_ORGANIZER = "isOrganizer";
    public static final String SESSION_IS_ADMIN = "isAdmin";

    //endregion

    //region Views

    public static final String VIEW_NOT_FOUND = "/pages/notFound.jsp";
    public static final String VIEW_LOGIN = "/pages/login.jsp";
    public static final String VIEW_SINGLE_MATCH = "/pages/grids/bodyGridSimple.jsp";
    public static final String VIEW_DOUBLE_MATCH = "/pages/grids/bodyGridDouble.jsp";
    public static final String VIEW_ADD_PLAYER = "/pages/actors/addPlayer.jsp";
    public static final String VIEW_ADD_TEAM = "/pages/actors/addTeam.jsp";
    public static final String VIEW_PLAYERS = "/pages/grids/bodyGridPlayers.jsp";
    public static final String VIEW_TEAMS = "/pages/grids/bodyGridTeams.jsp";
    public static final String VIEW_ADD_REFEREE = "/pages/actors/addReferee.jsp";
    public static final String VIEW_REFEREES = "/pages/grids/bodyGridReferees.jsp";
    public static final String VIEW_ADD_SINGLE_MATCH = "/pages/tournament/addSingleMatch.jsp";
    public static final String VIEW_ADD_DOUBLE_MATCH = "/pages/tournament/addDoubleMatch.jsp";
    public static final String VIEW_RESULT_SINGLE_MATCH = "/pages/tournament/resultSingleMatch.jsp";
    public static final String VIEW_RESULT_DOUBLE_MATCH = "/pages/tournament/resultDoubleMatch.jsp";
    public static final String VIEW_USERS = "/pages/grids/bodyGridUser.jsp";
    public static final String VIEW_ADD_USER = "/pages/actors/addUser.jsp";

    //endregion

    //region URL

    public static final String URL_HOME = "tournoi?type=MatchSimple&genre=Femme";
    public static final String URL_LOGIN = "connexion";
    public static final String URL_REFEREES = "arbitres";
    public static final String URL_USERS = "utilisateurs";
    public static final String URL_PLAYERS = "joueurs";

    //endregion

    //region URL Param

    public static final String URL_PARAM_MATCH_TYPE = "type";
    public static final String URL_PARAM_GENDER = "genre";

    //endregion

    //region Form field

    public static final String LOGIN_FORM_FIELD_MAIL = "mail";
    public static final String LOGIN_FORM_FIELD_PASSWORD = "password";
    public static final String NEW_ACTOR_FORM_FIELD_FIRSTNAME = "actorFirstname";
    public static final String NEW_ACTOR_FORM_FIELD_LASTNAME = "actorLastname";
    public static final String NEW_ACTOR_FORM_FIELD_NATIONALITY = "actorNationality";
    public static final String NEW_ACTOR_FORM_FIELD_MAIL = "actorMail";
    public static final String NEW_ACTOR_FORM_FIELD_PASSWORD = "actorPassword";
    public static final String NEW_ACTOR_FORM_FIELD_STATUS = "actorStatus";
    public static final String NEW_ACTOR_FORM_FIELD_RANKINGS = "actorRankings";
    public static final String NEW_ACTOR_FORM_FIELD_GENDER = "actorGender";

    //endregion

    //region Request attributes

    public static final String REQUEST_ATTR_TITLE = "title";
    public static final String REQUEST_ATTR_CONNECTION_ERROR = "connectionError";
    public static final String REQUEST_ATTR_BREADCRUMBS = "breadcrumbs";
    public static final String REQUEST_ATTR_REFEREES_LIST = "refereesList";
    public static final String REQUEST_ATTR_USERS_LIST = "usersList";
    public static final String REQUEST_ATTR_TEAMS_LIST = "teamsList";
    public static final String REQUEST_ATTR_PLAYERS_LIST = "playersList";

    //endregion

    //region Titles

    public static final String TITLE_SINGLE_MATCH_BASE = "Match Simple";
    public static final String TITLE_DOUBLE_MATCH_BASE = "Match Double";
    public static final String TITLE_PLAYERS = "Joueurs";
    public static final String TITLE_ADD_PLAYER = "Ajouter joueur";
    public static final String TITLE_TEAMS = "Equipes";
    public static final String TITLE_ADD_TEAM = "Ajouter équipe";
    public static final String TITLE_REFEREES = "Arbitres";
    public static final String TITLE_ADD_REFEREE = "Ajouter arbitre";
    public static final String TITLE_ADD_MATCH = "Ajouter match";
    public static final String TITLE_ADD_RESULT = "Ajouter résultat";
    public static final String TITLE_USERS = "Utilisateurs";
    public static final String TITLE_ADD_USER= "Ajouter utilisateur";

    //endregion

}
