INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Cloe', 'RICARD', 'cloericard@gmail.com', 'cloemp',  0);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Arnaud', 'SAULOU', 'arnaudsauloud@gmail.com', 'arnaudmp',  1);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Pierre', 'LEMAIGRE', 'pierrelemaigre@gmail.com', 'pierremp',  1);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Enzo', 'CARVALHO', 'enzocarvalho@gmail.com', 'enzomp',  1);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Henri', 'VALLETTE', 'henrivallette@gmail.com', 'henrimp',  1);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Patrick', 'BALKANY', 'journaliste@gmail.com', 'j',  1);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Billy', 'CRAWFORD', 'organisateur@gmail.com', 'o',  1);
-- INSERT INTO PLAYER --

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Ashleigh', 'BARTY', 'AUS', 1, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Simona', 'HALEP', 'ROM', 2, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Naomi', 'OSAKA', 'JAP', 3, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Sofia', 'KENIN', 'USA', 4, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Elina', 'SVITOLINA', 'UKR', 5, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Karolina', 'PLISKOVA', 'Rép Tchèque', 6, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Bianca', 'ANDREESCU', 'CAN', 7, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Petra', 'KVITOVA', 'Rép Tchèque', 8, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Novak', 'DJOKOVIC', 'Serbia', 9, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Rafael ', 'NADAL', 'ESP', 10, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Dominic', 'THIEM', 'ANG', 11, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Daniil', 'MEDVEDEV', 'RUS', 12, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Roger', 'FEDERER', 'Suisse', 13, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Stefanos', 'TSITSIPAS', 'Grèce', 14, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Alexander', 'ZVEREV', 'ALL', 15, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Andrey', 'RUBLEV', 'RUS', 16, 'HOMME');

-- INSERT INTO REFEREE --

INSERT INTO REFEREE(firstname, lastname, nationality)
VALUES ('Pierre', 'BACCHI', 'FRA');

INSERT INTO REFEREE(firstname, lastname, nationality)
VALUES ('Renaud', 'LICHTENSTEIN', 'FRA');

INSERT INTO REFEREE(firstname, lastname, nationality)
VALUES ('Jaume', 'CAMPISTOL', 'ESP');

INSERT INTO REFEREE(firstname, lastname, nationality)
VALUES ('Nico', 'HELWERTH', 'ALL');

-- INSERT INTO COURT --

INSERT INTO COURT(name)
VALUES ('COURT Philippe-Chatrier');

INSERT INTO COURT(name)
VALUES ('COURT Suzanne-Lenglen');

INSERT INTO COURT(name)
VALUES ('COURT Simonne-Mathieu');

INSERT INTO COURT(name)
VALUES ('COURT n°1');

INSERT INTO COURT(name)
VALUES ('COURT n°2');

INSERT INTO COURT(name)
VALUES ('COURT n°3');

INSERT INTO COURT(name)
VALUES ('COURT n°4');

-- INSERT INTO TEAM --

INSERT INTO TEAM(gender, name)
VALUES ('FEMME','TEAM 1');

INSERT INTO TEAM(gender, name)
VALUES ('FEMME', 'TEAM 2');

INSERT INTO TEAM(gender, name)
VALUES ('FEMME', 'TEAM 3');

INSERT INTO TEAM(gender, name)
VALUES ('HOMME','TEAM 4');

INSERT INTO TEAM(gender, name)
VALUES ('HOMME', 'TEAM 5');

INSERT INTO TEAM(gender, name)
VALUES ('HOMME', 'TEAM 6');

INSERT INTO TEAM(gender, name)
VALUES ('MIXTE', 'TEAM 7');

INSERT INTO TEAM(gender, name)
VALUES ('MIXTE', 'TEAM 8');

-- INSERT INTO TEAM_PLAYER --

INSERT INTO team_player(team_id, player_id)
VALUES (1, 1);

INSERT INTO team_player(team_id, player_id)
VALUES (1, 2);

INSERT INTO team_player(team_id, player_id)
VALUES (2, 3);

INSERT INTO team_player(team_id, player_id)
VALUES (2, 4);

INSERT INTO team_player(team_id, player_id)
VALUES (3, 5);

INSERT INTO team_player(team_id, player_id)
VALUES (3, 6);

INSERT INTO team_player(team_id, player_id)
VALUES (4, 9);

INSERT INTO team_player(team_id, player_id)
VALUES (4, 10);

INSERT INTO team_player(team_id, player_id)
VALUES (5, 11);

INSERT INTO team_player(team_id, player_id)
VALUES (5, 12);

INSERT INTO team_player(team_id, player_id)
VALUES (6, 13);

INSERT INTO team_player(team_id, player_id)
VALUES (6, 14);

INSERT INTO team_player(team_id, player_id)
VALUES (7, 7);

INSERT INTO team_player(team_id, player_id)
VALUES (7, 15);

INSERT INTO team_player(team_id, player_id)
VALUES (8, 8);

INSERT INTO team_player(team_id, player_id)
VALUES (8, 16);

-- INSERT INTO TOURNAMENT --

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'HOMME', 12, 'SINGLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'FEMME', 12, 'SINGLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'MIXTE', 8, 'DOUBLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'FEMME', 12, 'DOUBLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'HOMME', 12, 'DOUBLE');

-- INSERT INTO SINGLEMATCH --

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-02 02:55:05', '2020-12-02 08:55:05', 4, 1, 1, 1, 2);

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-10 02:55:05', '2020-12-10 16:55:05',2, 3, 2, 3, 2);

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', '2020-12-14 12:59:05', 1, 2, 1, 2, 2);

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', null, 0, 0, 3, 4, 2);

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', '2020-12-14 22:59:05', 1, 2, 1, 2, 1);

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', null, 2, 3, 2, 5, 1);

-- INSERT INTO PLAYER_SINGLEMATCH --

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (3, 1);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (1, 1);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (5, 2);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (6, 2);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (6, 3);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (3, 3);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (7, 4);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (8, 4);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (12, 5);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (13, 5);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (14, 6);

INSERT INTO player_singlematch(player_id, singlematch_id)
VALUES (15, 6);


-- INSERT INTO DOUBLEMATCH --

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-13 02:55:05', null, 0, 0, 4, 4, 4);

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-18 02:55:05', null, 0, 0, 2, 4, 4);

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-02 02:55:05', '2020-12-02 08:55:05', 4, 1, 1, 1, 5);

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-10 02:55:05', '2020-12-10 06:55:05',2, 3, 2, 3, 5);

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', null, 0, 0, 1, 2, 3);

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', '2020-12-14 07:59:05', 1, 2, 3, 5, 3);

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', '2020-12-14 22:59:05', 3, 2, 2, 1, 3);

-- INSERT INTO DOUBLEMATCH_TEAM --

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (1, 1);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (1, 2);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (2, 3);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (2, 1);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (3, 6);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (3, 4);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (4, 4);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (4, 5);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (5, 7);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (5, 8);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (6, 8);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (6, 6);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (7, 8);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (7, 7);

