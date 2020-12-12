-- ALTER TABLE --

-- ALTER TABLE singlematch MODIFY COLUMN id INT auto_increment;
-- ALTER TABLE doublematch MODIFY COLUMN id INT auto_increment;

-- DELETE TABLE --

DELETE FROM arbitrator_singlematch where Arbitrator_ID = Arbitrator_ID;
DELETE FROM arbitrator_doublematch where matchsDouble_ID = matchsDouble_ID;
DELETE FROM tournament_doublematch where matchsDouble_ID = matchsDouble_ID;
DELETE FROM tournament_singlematch where matchsSingle_ID = matchsSingle_ID;
DELETE FROM tournament_doublematch where matchsDouble_ID = matchsDouble_ID;
DELETE FROM tournament_singlematch where matchsSingle_ID = matchsSingle_ID;
DELETE FROM user where FIRSTNAME = FIRSTNAME;
DELETE FROM doublematch where DATEBEGIN = DATEBEGIN;
DELETE FROM team where NAME = Name;
DELETE FROM singlematch where DATEBEGIN = DATEBEGIN;
DELETE FROM PLAYER where FIRSTNAME = FIRSTNAME;
DELETE FROM arbitrator where FIRSTNAME = FIRSTNAME;
DELETE FROM field where NAME = Name;
DELETE FROM tournament where DATEBEGIN = DATEBEGIN;

-- INSERT USER --
-- Status :
-- 0 - Administration
-- 1 - Organisation
-- 2 - Journaliste

INSERT INTO user(firstname, lastname, mail, password, status)
VALUES ('Cloe', 'RICARD', 'cloericard@gmail.com', 'cloemp',  0);

INSERT INTO user(firstname, lastname, mail, password, status)
VALUES ('Arnaud', 'SAULOU', 'arnaudsauloud@gmail.com', 'arnaudmp',  1);

INSERT INTO user(firstname, lastname, mail, password, status)
VALUES ('Pierre', 'LEMAIGRE', 'pierrelemaigre@gmail.com', 'pierremp',  1);

INSERT INTO user(firstname, lastname, mail, password, status)
VALUES ('Enzo', 'CARVALHO', 'enzocarvalho@gmail.com', 'enzomp',  1);

-- INSERT PLAYER --

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Alizé', 'CORNET', 'FRA', null, 'FEMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Kaia ', 'KANEPI', 'EST', null, 'FEMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Dominic', 'THIEM', 'ANG', null, 'HOMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Rafael', 'NADAL', 'AUT', null, 'HOMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Daniil', 'MEDVEDEV', 'RUS', null, 'HOMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Corentin', 'MOUTET', 'ANG', null, 'HOMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Greet', 'MINNEN', 'BEL', null, 'FEMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Kaja', 'JUVAN', 'SLO', null, 'FEMME');

-- INSERT ARBITRATOR --

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Pierre', 'BACCHI', 'FRA');

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Renaud', 'LICHTENSTEIN', 'FRA');

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Jaume', 'CAMPISTOL', 'ESP');

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Nico', 'HELWERTH', 'ALL');

-- INSERT FIELD --

INSERT field(name)
VALUES ('Court Philippe-Chatrier');

INSERT field(name)
VALUES ('Court Suzanne-Lenglen');

INSERT field(name)
VALUES ('Court Simonne-Mathieu');

INSERT field(name)
VALUES ('Court n°1');

INSERT field(name)
VALUES ('Court n°2');

-- INSERT TEAM --

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 1', 1, 2);

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 2', 3, 4);

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 3', 5, 6);

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 4', 7, 8);

-- INSERT TOURNAMENT --

INSERT tournament(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'HOMME', 12, 'SINGLE');

INSERT tournament(datebegin, dateend, gender, nbmatch, type)
VALUES ('2020-12-01', '2020-12-30', 'MIXTE', 8, 'DOUBLE');

-- INSERT SINGLEMATCH --

INSERT singlematch(datebegin, dateend, scorea, scoreb, arbitrator_id, fields_id, tournament_id, playera_id, playerb_id)
VALUES ('2020-12-02 02:55:05', '2020-12-02 08:55:05', 4, 1, 1, 1, 1, 3, 4);

INSERT singlematch(datebegin, dateend, scorea, scoreb, arbitrator_id, fields_id, tournament_id, playera_id, playerb_id)
VALUES ('2020-12-10 02:55:05', '2020-12-10 06:55:05',2, 3, 2, 3, 1, 5, 6);

INSERT singlematch(datebegin, dateend, scorea, scoreb, arbitrator_id, fields_id, tournament_id, playera_id, playerb_id)
VALUES ('2020-12-14 02:55:05', null, null, null, 1, 2, 1, 6, 3);

-- INSERT DOUBLEMATCH --

INSERT doublematch(datebegin, dateend, scorea, scoreb, arbitrator_id, fields_id, tournament_id, teama_id, teamb_id)
VALUES ('2020-12-13 02:55:05', null, null, null, 4, 4, 2, 1, 2);

INSERT doublematch(datebegin, dateend, scorea, scoreb, arbitrator_id, fields_id, tournament_id, teama_id, teamb_id)
VALUES ('2020-12-18 02:55:05', null, null, null, 2, 4, 2, 3, 4);

-- INSERT TOURNAMENT_SINGLE --

INSERT tournament_singlematch(tournament_id, matchssingle_id)
VALUES (1, 1);

INSERT tournament_singlematch(tournament_id, matchssingle_id)
VALUES (1, 2);

INSERT tournament_singlematch(tournament_id, matchssingle_id)
VALUES (1, 3);

-- INSERT TOURNAMENT_SINGLE --

INSERT tournament_doublematch(tournament_id, matchsdouble_id)
VALUES (2, 1);

INSERT tournament_doublematch(tournament_id, matchsdouble_id)
VALUES (2, 2);

-- INSERT ARBITRATOR_SINGLE --

INSERT arbitrator_singlematch(arbitrator_id, matchssingle_id)
VALUES (1, 1);

INSERT arbitrator_singlematch(arbitrator_id, matchssingle_id)
VALUES (2, 2);

INSERT arbitrator_singlematch(arbitrator_id, matchssingle_id)
VALUES (1, 3);

-- INSERT ARBITRATOR_DOUBLE --

INSERT arbitrator_doublematch(arbitrator_id, matchsDouble_ID)
VALUES (4, 1);

INSERT arbitrator_doublematch(arbitrator_id, matchsDouble_ID)
VALUES (2, 2);

-- INSERT PLAYER_SINGLEMATCH --

INSERT player_singlematch(player_id, matchssingle_id)
VALUES (3, 1);
INSERT player_singlematch(player_id, matchssingle_id)
VALUES (4, 1);

INSERT player_singlematch(player_id, matchssingle_id)
VALUES (5, 2);
INSERT player_singlematch(player_id, matchssingle_id)
VALUES (6, 2);

-- INSERT PLAYER_DOUBLEMATCH --

INSERT player_doublematch(player_id, matchsdouble_id)
VALUES (1, 1);
INSERT player_doublematch(player_id, matchsdouble_id)
VALUES (2, 1);

INSERT player_doublematch(player_id, matchsdouble_id)
VALUES (3, 2);
INSERT player_doublematch(player_id, matchsdouble_id)
VALUES (4, 2);