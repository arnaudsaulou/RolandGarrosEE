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

INSERT player(firstname, lastname, nationality, classement)
VALUES ('Joueur', 'A', 'FR', '2');

INSERT player(firstname, lastname, nationality, classement)
VALUES ('Joueur', 'B', 'ALL', '1');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Joueur', 'C', 'ANG', '3', 'HOMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Joueur', 'D', 'ANG', '4', 'FEMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Joueur', 'E', 'FR', '5', 'HOMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Joueur', 'F', 'ANG', '6', 'HOMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Joueur', 'F', 'AUS', '7', 'FEMME');

INSERT player(firstname, lastname, nationality, classement, gender)
VALUES ('Joueur', 'G', 'ANG', '8', 'FEMME');

-- INSERT ARBITRATOR --

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Arbitractor', '1', 'AUS');

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Arbitractor', '2', 'AUS');

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Arbitractor', '3', 'AUS');

INSERT arbitrator(firstname, lastname, nationality)
VALUES ('Arbitractor', '4', 'AUS');

-- INSERT FIELD --

INSERT field(name)
VALUES ('Terrain 1');

INSERT field(name)
VALUES ('Terrain 2');

INSERT field(name)
VALUES ('Terrain 3');

INSERT field(name)
VALUES ('Terrain 4');

-- INSERT TEAM --

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 1', 1, 2);

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 2', 3, 4);

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 3', 5, 6);

INSERT team(name, playera_id, playerb_id)
VALUES ('Team 4', 7, 8);