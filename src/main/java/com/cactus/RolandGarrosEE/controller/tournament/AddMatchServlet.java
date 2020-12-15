package com.cactus.RolandGarrosEE.controller.tournament;

import com.cactus.RolandGarrosEE.controller.BaseServlet;
import com.cactus.RolandGarrosEE.entities.*;
import com.cactus.RolandGarrosEE.repositories.remotes.*;
import com.cactus.RolandGarrosEE.utils.Constantes;
import com.cactus.RolandGarrosEE.utils.exceptions.InvalidMatchException;
import com.cactus.RolandGarrosEE.utils.exceptions.UnauthenticatedUserException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "ajouterMatch", value = "/tournoi/ajouterMatch")
public class AddMatchServlet extends BaseServlet {

    @EJB
    SingleMatchRemote singleMatchRemote;

    @EJB
    TournamentPersistentRemote tournamentPersistentRemote;

    @EJB
    RefereePersistentRemote refereePersistentRemote;

    @EJB
    CourtPersistentRemote courtPersistentRemote;

    @EJB
    PlayerPersistentRemote playerPersistentRemote;

    @EJB
    TeamPersistentRemote teamPersistentRemote;

    @EJB
    DoubleMatchPersistentRemote doubleMatchPersistentRemote;

    private TypeTournament type;
    private Gender gender;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.checkAuthentication(req);
            this.initViewData(req, resp);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            this.checkAuthentication(req);
            this.tryToSaveMatch(req);
            resp.sendRedirect("../" + Constantes.URL_TOURNAMENT + "?" + Constantes.URL_PARAM_MATCH_TYPE + "=" + this.type + "&" + Constantes.URL_PARAM_GENDER + "=" + this.gender);
        } catch (UnauthenticatedUserException e) {
            resp.sendRedirect("../" + Constantes.URL_LOGIN);
        } catch (InvalidMatchException e) {
            req.setAttribute(Constantes.REQUEST_ATTR__ERROR_MSG, e.getMessage());
            this.initViewData(req, resp);
            //resp.sendRedirect("../" + Constantes.URL_ADD_MATCH + "?" + Constantes.URL_PARAM_MATCH_TYPE + "=" + this.type + "&" + Constantes.URL_PARAM_GENDER + "=" + this.gender);
        }
    }

    private void initViewData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.setupViewAttributes(req);

        this.type = this.getTournamentTypeFromURL(req);
        this.attributes.put(Constantes.URL_PARAM_MATCH_TYPE, this.type.toString());

        this.gender = this.getGenderFromURL(req);
        this.attributes.put(Constantes.URL_PARAM_GENDER, this.gender.toString());

        this.populateReferees();
        this.populateCourts();

        this.dispatchDependingOnTournamentType(req, resp);
    }

    private void dispatchDependingOnTournamentType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (this.type.equals(TypeTournament.DOUBLE)) {
            this.populateTeams();
            this.propagateAttributesToRequest(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_DOUBLE_MATCH).forward(req, resp);
        } else {
            this.populatePlayer();
            this.propagateAttributesToRequest(req);
            this.getServletContext().getRequestDispatcher(Constantes.VIEW_ADD_SINGLE_MATCH).forward(req, resp);
        }
    }

    private void populateReferees() {
        List<Referee> referees = refereePersistentRemote.allArbitrator();
        this.attributes.put(Constantes.NEW_MATCH_FORM_FIELD_REFEREE, referees);
    }

    private void populateCourts() {
        List<Court> courts = courtPersistentRemote.allCourts();
        this.attributes.put(Constantes.NEW_MATCH_FORM_FIELD_COURT, courts);
    }

    private void populateTeams() {
        List<Team> teams;

        if (gender.equals(Gender.MIXTE)) {
            teams = teamPersistentRemote.allTeam();
        } else {
            teams = teamPersistentRemote.allTeamByGender(this.gender);
        }

        this.attributes.put(Constantes.NEW_MATCH_FORM_FIELD_PART_A, teams);
        this.attributes.put(Constantes.NEW_MATCH_FORM_FIELD_PART_B, teams);
    }

    private void populatePlayer() {
        List<Player> players = playerPersistentRemote.allPlayerByGender(this.gender);
        this.attributes.put(Constantes.NEW_MATCH_FORM_FIELD_PART_A, players);
        this.attributes.put(Constantes.NEW_MATCH_FORM_FIELD_PART_B, players);
    }

    private void setupViewAttributes(HttpServletRequest req) {
        this.resetBreadcrumbs();
        this.addToBreadcrumbs(Constantes.TITLE_TOURNAMENT);
        this.addToBreadcrumbs(Constantes.TITLE_ADD_MATCH);

        this.attributes.put(Constantes.REQUEST_ATTR_TITLE, Constantes.TITLE_ADD_MATCH);
        this.propagateAttributesToRequest(req);
    }

    private void tryToSaveMatch(HttpServletRequest req) throws InvalidMatchException {
        // TODO
        String startDateString = this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_START_DATE);

        Date startDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            startDate = formatter.parse(startDateString.replace("T"," "));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tournament tournament = this.getTournament(req);
        Referee referee = this.getReferee(req);
        Court court = this.getCourt(req);

        TypeTournament type = this.getTournamentTypeFromURL(req);

        if (type.equals(TypeTournament.SINGLE)) {
            SingleMatch newSingleMatch = this.constructSingleMatch(req, startDate, tournament, referee, court);
            singleMatchRemote.saveSingleMatch(newSingleMatch);
        } else {
            DoubleMatch newDoubleMatch = constructDoubleMatch(req, startDate, tournament, referee, court);
            doubleMatchPersistentRemote.addDoubleMatch(newDoubleMatch);
        }

    }

    private DoubleMatch constructDoubleMatch(HttpServletRequest req, Date startDate, Tournament tournament, Referee referee, Court court) throws InvalidMatchException {
        List<Team> teamList = this.constructTeamList(req);

        this.validateNewDoubleMatch(startDate, tournament, referee, court, teamList.get(0), teamList.get(1));

        return new DoubleMatch(startDate, startDate, 0, 0, tournament, court, referee, teamList);
    }

    private SingleMatch constructSingleMatch(HttpServletRequest req, Date startDate, Tournament tournament, Referee referee, Court court) throws InvalidMatchException {
        List<Player> playersList = this.constructPlayerList(req);

        this.validateNewSingleMatch(startDate, tournament, referee, court, playersList.get(0), playersList.get(1));

        return new SingleMatch(startDate, startDate, 0, 0, tournament, court, referee, playersList);
    }

    private Team getTeam(HttpServletRequest req, String field) throws InvalidMatchException, IllegalArgumentException {
        String teamIdString = this.getValue(req, field);

        if (teamIdString == null)
            throw new InvalidMatchException("Equipe non renseignée");

        return teamPersistentRemote.getTeamById(Integer.parseInt(teamIdString));
    }

    private Player getPlayer(HttpServletRequest req, String field) throws InvalidMatchException, IllegalArgumentException {
        String playerIdString = this.getValue(req, field);

        if (playerIdString == null)
            throw new InvalidMatchException("Joueur non renseigné");

        return playerPersistentRemote.findPlayerById(Integer.parseInt(playerIdString));
    }

    private Court getCourt(HttpServletRequest req) throws InvalidMatchException, IllegalArgumentException {
        String courtIdString = this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_COURT);

        if (courtIdString == null)
            throw new InvalidMatchException("Court non renseigné");

        return courtPersistentRemote.findCourtById(Integer.parseInt(courtIdString));
    }

    private Referee getReferee(HttpServletRequest req) throws InvalidMatchException, IllegalArgumentException {
        String refereeIdString = this.getValue(req, Constantes.NEW_MATCH_FORM_FIELD_REFEREE);

        if (refereeIdString == null)
            throw new InvalidMatchException("Arbitre non renseigné");

        return refereePersistentRemote.getArbitratorById(Integer.parseInt(refereeIdString));
    }

    private Tournament getTournament(HttpServletRequest req) throws InvalidMatchException, IllegalArgumentException {
        String typeTournamentString = this.getValue(req, Constantes.URL_PARAM_MATCH_TYPE);
        String genderString = this.getValue(req, Constantes.URL_PARAM_GENDER);

        if (typeTournamentString == null)
            throw new InvalidMatchException("Tournoi non spécifié");
        if (genderString == null)
            throw new InvalidMatchException("Genre non spécifié");

        TypeTournament type = TypeTournament.getTypeTournamentFromString(typeTournamentString);
        Gender gender = Gender.getGenderFromString(req.getParameter(Constantes.URL_PARAM_GENDER));

        return tournamentPersistentRemote.getTournamentByTypeAndGender(type, gender);
    }

    private Gender getGenderFromURL(HttpServletRequest request) throws IllegalArgumentException {
        String genderString = this.getValue(request, Constantes.URL_PARAM_GENDER);
        if (genderString == null)
            throw new IllegalArgumentException("Genre non renseigné");
        return Gender.getGenderFromString(genderString);
    }

    private TypeTournament getTournamentTypeFromURL(HttpServletRequest request) throws IllegalArgumentException {
        String matchTypeString = this.getValue(request, Constantes.URL_PARAM_MATCH_TYPE);
        if (matchTypeString == null)
            throw new IllegalArgumentException("Type de tournois non renseigné");
        return TypeTournament.getTypeTournamentFromString(matchTypeString);
    }

    private List<Player> constructPlayerList(HttpServletRequest request) throws InvalidMatchException {
        Player playerA = this.getPlayer(request, Constantes.NEW_MATCH_FORM_FIELD_PART_A);
        Player playerB = this.getPlayer(request, Constantes.NEW_MATCH_FORM_FIELD_PART_B);

        List<Player> playersList = new ArrayList<>();
        playersList.add(playerA);
        playersList.add(playerB);
        return playersList;
    }

    private List<Team> constructTeamList(HttpServletRequest request) throws InvalidMatchException {
        Team teamA = this.getTeam(request, Constantes.NEW_MATCH_FORM_FIELD_PART_A);
        Team teamB = this.getTeam(request, Constantes.NEW_MATCH_FORM_FIELD_PART_B);

        List<Team> teamList = new ArrayList<>();
        teamList.add(teamA);
        teamList.add(teamB);
        return teamList;
    }

    private void validateNewMatchBase(Date startDate, Tournament tournament, Referee referee, Court court)
            throws InvalidMatchException {
        if (startDate == null || tournament == null || referee == null || court == null)
            throw new InvalidMatchException("Format du match invalid");
    }

    private void validateNewSingleMatch(Date startDate, Tournament tournament, Referee referee, Court court, Player playerA, Player playerB)
            throws InvalidMatchException {
        this.validateNewMatchBase(startDate, tournament, referee, court);
        if (playerA == null || playerB == null)
            throw new InvalidMatchException("Format du match invalid");
        if (playerA.getId() == playerB.getId())
            throw new InvalidMatchException("Les joueurs rentrés sont les mêmes");
    }

    private void validateNewDoubleMatch(Date startDate, Tournament tournament, Referee referee, Court court, Team teamA, Team teamB)
            throws InvalidMatchException {
        this.validateNewMatchBase(startDate, tournament, referee, court);
        if (teamA == null || teamB == null)
            throw new InvalidMatchException("Format du match invalid");
        if (teamA.getId() == teamB.getId())
            throw new InvalidMatchException("Les joueurs rentrés sont les mêmes");
    }

}