INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Cloe', 'RICARD', 'cloericard@gmail.com', 'cloemp',  0);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Arnaud', 'SAULOU', 'arnaudsauloud@gmail.com', 'arnaudmp',  1);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Pierre', 'LEMAIGRE', 'pierrelemaigre@gmail.com', 'pierremp',  1);

INSERT INTO  USER(firstname, lastname, mail, password, status)
VALUES ('Enzo', 'CARVALHO', 'enzocarvalho@gmail.com', 'enzomp',  1);

-- INSERT INTO PLAYER --

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Alizé', 'CORNET', 'FRA', 1, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Kaia ', 'KANEPI', 'EST', 2, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Dominic', 'THIEM', 'ANG', 3, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Rafael', 'NADAL', 'AUT', 4, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Daniil', 'MEDVEDEV', 'RUS', 5, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Corentin', 'MOUTET', 'ANG', 6, 'HOMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Greet', 'MINNEN', 'BEL', 7, 'FEMME');

INSERT INTO PLAYER(firstname, lastname, nationality, rankings, gender)
VALUES ('Kaja', 'JUVAN', 'SLO', 8, 'FEMME');

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

-- INSERT INTO TEAM --

INSERT INTO TEAM(gender, name)
VALUES ('FEMME','TEAM 1');

INSERT INTO TEAM(gender, name)
VALUES ('HOMME', 'TEAM 2');

INSERT INTO TEAM(gender, name)
VALUES ('HOMME', 'TEAM 3');

INSERT INTO TEAM(gender, name)
VALUES ('FEMME', 'TEAM 4');

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
VALUES (4, 7);

INSERT INTO team_player(team_id, player_id)
VALUES (4, 8);

-- INSERT INTO TOURNAMENT --

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'HOMME', 12, 'SINGLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'MIXTE', 8, 'DOUBLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'FEMME', 12, 'SINGLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'FEMME', 12, 'DOUBLE');

INSERT INTO TOURNAMENT(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'HOMME', 12, 'DOUBLE');
-- INSERT INTO SINGLEMATCH --

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-02 02:55:05', '2020-12-02 08:55:05', 4, 1, 1, 1, 1);

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-10 02:55:05', '2020-12-10 06:55:05',2, 3, 2, 3, 1);

INSERT INTO SINGLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', null, 1, 2, 1, 2, 1);

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

-- INSERT INTO DOUBLEMATCH --

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-13 02:55:05', null, null, null, 4, 4, 2);

INSERT INTO DOUBLEMATCH(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-18 02:55:05', null, null, null, 2, 4, 2);

-- INSERT INTO DOUBLEMATCH_TEAM --

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (1, 1);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (1, 2);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (2, 3);

INSERT INTO doublematch_team(doublematch_id, team_id)
VALUES (2, 4);

-- INSERT INTO referee_SINGLE --

INSERT INTO REFEREE_SINGLEMATCH(referee_id, matchssingle_id)
VALUES (1, 1);

INSERT INTO REFEREE_SINGLEMATCH(referee_id, matchssingle_id)
VALUES (2, 2);

INSERT INTO REFEREE_SINGLEMATCH(referee_id, matchssingle_id)
VALUES (1, 3);

-- INSERT INTO referee_DOUBLE --

INSERT INTO REFEREE_DOUBLEMATCH(referee_id, matchsDouble_ID)
VALUES (4, 1);

INSERT INTO REFEREE_DOUBLEMATCH(referee_id, matchsDouble_ID)
VALUES (2, 2);

