package com.cactus.RolandGarrosEE.utils;

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
    public static final String VIEW_DETAILS_TEAM = "/pages/infosViews/infosTeam.jsp";
    public static final String VIEW_ADD_REFEREE = "/pages/actors/addReferee.jsp";
    public static final String VIEW_REFEREES = "/pages/grids/bodyGridReferees.jsp";
    public static final String VIEW_DETAILS_REFEREE = "/pages/infosViews/infosReferee.jsp";
    public static final String VIEW_ADD_SINGLE_MATCH = "/pages/tournament/addSingleMatch.jsp";
    public static final String VIEW_ADD_DOUBLE_MATCH = "/pages/tournament/addDoubleMatch.jsp";
    public static final String VIEW_RESULT_SINGLE_MATCH = "/pages/tournament/resultSingleMatch.jsp";
    public static final String VIEW_RESULT_DOUBLE_MATCH = "/pages/tournament/resultDoubleMatch.jsp";
    public static final String VIEW_USERS = "/pages/grids/bodyGridUser.jsp";
    public static final String VIEW_ADD_USER = "/pages/actors/addUser.jsp";
    public static final String VIEW_DETAILS_PLAYER = "/pages/infosViews/infosPlayer.jsp";

    //endregion

    //region URL

    public static final String URL_HOME = "tournoi?type=Single&genre=Femme";
    public static final String URL_LOGIN = "connexion";
    public static final String URL_LOGOUT = "deconnexion";
    public static final String URL_REFEREES = "arbitres";
    public static final String URL_USERS = "utilisateurs";
    public static final String URL_PLAYERS = "joueurs";
    public static final String URL_ADD_USER = "ajouterUtilisateur";
    public static final String URL_TEAM = "equipes";
    public static final String URL_ADD_MATCH = "ajouterMatch";
    public static final String URL_TOURNAMENT = "tournoi";

    //endregion

    //region URL Param

    public static final String URL_PARAM_MATCH_TYPE = "type";
    public static final String URL_PARAM_GENDER = "genre";
    public static final String URL_PARAM_TEAM_ID = "idEquipe";
    public static final String URL_PARAM_MATCH_ID = "idMatch";

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
    public static final String NEW_MATCH_FORM_FIELD_START_DATE = "matchStartDate";
    public static final String NEW_MATCH_FORM_FIELD_END_DATE = "matchEndDate";
    public static final String NEW_MATCH_FORM_FIELD_PART_A = "matchPartA";
    public static final String NEW_MATCH_FORM_FIELD_PART_B = "matchPartB";
    public static final String NEW_MATCH_FORM_FIELD_REFEREE = "matchReferee";
    public static final String NEW_MATCH_FORM_FIELD_COURT = "matchCourt";
    public static final String NEW_MATCH_FORM_FIELD_SCORE_A = "matchScoreA";
    public static final String NEW_MATCH_FORM_FIELD_SCORE_B = "matchScoreB";
    public static final String NEW_ACTOR_FORM_FIELD_RANKINGS = "actorRankings";
    public static final String NEW_ACTOR_FORM_FIELD_GENDER = "actorGender";
    public static final String NEW_TEAM_FORM_FIELD_NAME = "teamName";
    public static final String NEW_TEAM_FORM_FIELD_PLAYER_A = "teamPlayerA";
    public static final String NEW_TEAM_FORM_FIELD_PLAYER_B = "teamPlayerB";
    public static final String NEW_DETAILS_TEAM = "team";
    public static final String NEW_DETAILS_FORM_PLAYER = "joueur";
    public static final String NEW_DETAILS_UPDATE = "update";
    public static final String NEW_MATCH_ADD = "add";
    public static final String NEW_DETAILS_DELETE = "delete";
    public static final String NEW_DETAILS_REFEREE = "referee";

    //endregion

    //region Request attributes

    public static final String REQUEST_ATTR_TITLE = "title";
    public static final String REQUEST_ATTR_CONNECTION_ERROR = "connectionError";
    public static final String REQUEST_ATTR_BREADCRUMBS = "breadcrumbs";
    public static final String REQUEST_ATTR_REFEREES_LIST = "refereesList";
    public static final String REQUEST_ATTR_USERS_LIST = "usersList";
    public static final String REQUEST_ATTR_TEAMS_LIST = "teamsList";
    public static final String REQUEST_ATTR_PLAYERS_LIST = "playersList";
    public static final String REQUEST_ATTR_ID = "id";
    public static final String REQUEST_ATTR_SINGLE_MATCH_LIST = "singleMatchList";
    public static final String REQUEST_ATTR_DOUBLE_MATCH_LIST = "doubleMatchList";
    public static final String REQUEST_ATTR__ERROR_MSG = "errorMessage";


    //endregion

    //region Titles

    public static final String TITLE_SINGLE_MATCH_BASE = "Match Simple";
    public static final String TITLE_DOUBLE_MATCH_BASE = "Match Double";
    public static final String TITLE_PLAYERS = "Joueurs";
    public static final String TITLE_PLAYER_DETAILS = "Details joueur";
    public static final String TITLE_ADD_PLAYER = "Ajouter joueur";
    public static final String TITLE_TEAMS = "Equipes";
    public static final String TITLE_TEAMS_DETAILS = "Details Equipe";
    public static final String TITLE_ADD_TEAM = "Ajouter équipe";
    public static final String TITLE_REFEREES = "Arbitres";
    public static final String TITLE_REFEREE_DETAILS = "Details Arbitre";
    public static final String TITLE_ADD_REFEREE = "Ajouter arbitre";
    public static final String TITLE_ADD_MATCH = "Ajouter match";
    public static final String TITLE_ADD_RESULT = "Ajouter résultat";
    public static final String TITLE_USERS = "Utilisateurs";
    public static final String TITLE_ADD_USER = "Ajouter utilisateur";
    public static final String TITLE_TOURNAMENT = "Tournois";

    //endregion

}
