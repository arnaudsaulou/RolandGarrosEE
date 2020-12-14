INSERT INTO USER(firstname, lastname, mail, password, status)
VALUES ('Cloe', 'RICARD', 'cloericard@gmail.com', 'cloemp',  0);

INSERT INTO USER(firstname, lastname, mail, password, status)
VALUES ('Arnaud', 'SAULOU', 'arnaudsauloud@gmail.com', 'arnaudmp',  1);

INSERT INTO USER(firstname, lastname, mail, password, status)
VALUES ('Pierre', 'LEMAIGRE', 'pierrelemaigre@gmail.com', 'pierremp',  1);

INSERT INTO USER(firstname, lastname, mail, password, status)
VALUES ('Enzo', 'CARVALHO', 'enzocarvalho@gmail.com', 'enzomp',  1);

-- INSERT PLAYER --

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Alizé', 'CORNET', 'FRA', 1, 'FEMME');

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Kaia ', 'KANEPI', 'EST', 2, 'FEMME');

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Dominic', 'THIEM', 'ANG', 3, 'HOMME');

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Rafael', 'NADAL', 'AUT', 4, 'HOMME');

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Daniil', 'MEDVEDEV', 'RUS', 5, 'HOMME');

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Corentin', 'MOUTET', 'ANG', 6, 'HOMME');

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Greet', 'MINNEN', 'BEL', 7, 'FEMME');

INSERT player(firstname, lastname, nationality, rankings, gender)
VALUES ('Kaja', 'JUVAN', 'SLO', 8, 'FEMME');

-- INSERT referee --

INSERT referee(firstname, lastname, nationality)
VALUES ('Pierre', 'BACCHI', 'FRA');

INSERT referee(firstname, lastname, nationality)
VALUES ('Renaud', 'LICHTENSTEIN', 'FRA');

INSERT referee(firstname, lastname, nationality)
VALUES ('Jaume', 'CAMPISTOL', 'ESP');

INSERT referee(firstname, lastname, nationality)
VALUES ('Nico', 'HELWERTH', 'ALL');

-- INSERT COURT --

INSERT court(name)
VALUES ('Court Philippe-Chatrier');

INSERT court(name)
VALUES ('Court Suzanne-Lenglen');

INSERT court(name)
VALUES ('Court Simonne-Mathieu');

INSERT court(name)
VALUES ('Court n°1');

INSERT court(name)
VALUES ('Court n°2');

-- INSERT TEAM --

INSERT team(name)
VALUES ('Team 1');

INSERT team(name)
VALUES ('Team 2');

INSERT team(name)
VALUES ('Team 3');

INSERT team(name)
VALUES ('Team 4');

-- INSERT TEAM_PLAYER --

INSERT team_player(team_id, player_id)
VALUES (1, 1);

INSERT team_player(team_id, player_id)
VALUES (1, 2);

INSERT team_player(team_id, player_id)
VALUES (2, 3);

INSERT team_player(team_id, player_id)
VALUES (2, 4);

INSERT team_player(team_id, player_id)
VALUES (3, 5);

INSERT team_player(team_id, player_id)
VALUES (3, 6);

INSERT team_player(team_id, player_id)
VALUES (4, 7);

INSERT team_player(team_id, player_id)
VALUES (4, 8);

-- INSERT TOURNAMENT --

INSERT tournament(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'HOMME', 12, 'SINGLE');

INSERT tournament(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'MIXTE', 8, 'DOUBLE');

-- INSERT SINGLEMATCH --

INSERT singlematch(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-02 02:55:05', '2020-12-02 08:55:05', 4, 1, 1, 1, 1);

INSERT singlematch(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-10 02:55:05', '2020-12-10 06:55:05',2, 3, 2, 3, 1);

INSERT singlematch(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-14 02:55:05', null, null, null, 1, 2, 1);

-- INSERT PLAYER_SINGLEMATCH --

INSERT player_singlematch(player_id, singlematch_id)
VALUES (3, 1);

INSERT player_singlematch(player_id, singlematch_id)
VALUES (3, 2);

INSERT player_singlematch(player_id, singlematch_id)
VALUES (5, 2);

INSERT player_singlematch(player_id, singlematch_id)
VALUES (6, 2);

INSERT player_singlematch(player_id, singlematch_id)
VALUES (6, 3);

INSERT player_singlematch(player_id, singlematch_id)
VALUES (3, 3);

-- INSERT DOUBLEMATCH --

INSERT doublematch(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-13 02:55:05', null, null, null, 4, 4, 2);

INSERT doublematch(datebegin, dateend, scorea, scoreb, referee_id, court_ID, tournament_id)
VALUES ('2020-12-18 02:55:05', null, null, null, 2, 4, 2);

-- INSERT DOUBLEMATCH_TEAM --

INSERT doublematch_team(doublematch_id, team_id)
VALUES (1, 1);

INSERT doublematch_team(doublematch_id, team_id)
VALUES (1, 2);

INSERT doublematch_team(doublematch_id, team_id)
VALUES (2, 3);

INSERT doublematch_team(doublematch_id, team_id)
VALUES (2, 4);

-- INSERT referee_SINGLE --

INSERT referee_singlematch(referee_id, matchssingle_id)
VALUES (1, 1);

INSERT referee_singlematch(referee_id, matchssingle_id)
VALUES (2, 2);

INSERT referee_singlematch(referee_id, matchssingle_id)
VALUES (1, 3);

-- INSERT referee_DOUBLE --

INSERT referee_doublematch(referee_id, matchsDouble_ID)
VALUES (4, 1);

INSERT referee_doublematch(referee_id, matchsDouble_ID)
VALUES (2, 2);

