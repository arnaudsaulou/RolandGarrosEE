package com.cactus.RolandGarrosEE.controller;

public class Constantes {

    //region Session

    public static final String SESSION_USER = "userSession";
    public static final String SESSION_IS_ORGANIZER = "isOrganizer";

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

    //endregion

    //region URL

    public static final String URL_HOME = "tournoi?type=MatchSimple&genre=Femme";
    public static final String URL_LOGIN = "connexion";

    //endregion

    //region URL Param

    public static final String URL_PARAM_MATCH_TYPE = "type";
    public static final String URL_PARAM_GENDER = "genre";

    //endregion

    //region Form field

    public static final String LOGIN_FORM_FIELD_MAIL = "mail";
    public static final String LOGIN_FORM_FIELD_PASSWORD = "password";

    //endregion

    //region Request attributes

    public static final String REQUEST_ATTR_TITLE = "title";
    public static final String REQUEST_ATTR_CONNECTION_ERROR = "connectionError";
    public static final String REQUEST_ATTR_BREADCRUMBS = "breadcrumbs";

    //endregion

    //region Titles

    public static final String TITLE_SINGLE_MATCH_BASE = "Match Simple";
    public static final String TITLE_DOUBLE_MATCH_BASE = "Match Double";
    public static final String TITLE_PLAYERS = "Joueurs";
    public static final String TITLE_ADD_PLAYER = "Ajouter joueur";
    public static final String TITLE_TEAMS = "Equipes";
    public static final String TITLE_ADD_TEAM = "Ajouter équipe";
    public static final String TITLE_REFEREES = "Arbitres";
    public static final String TITLE_ADD_REFEREE= "Ajouter arbitre";
    public static final String TITLE_ADD_MATCH = "Ajouter match";
    public static final String TITLE_ADD_RESULT= "Ajouter résultat";

    //endregion

}
