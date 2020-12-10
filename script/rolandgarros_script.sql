 -------------------------------------------------------------------------------------------------
 --        					              Script MariaDB                                        --
 -------------------------------------------------------------------------------------------------

 -------------------------------------------------------------------------------------------------
 --        					              RESET TABLES                                          --
 -------------------------------------------------------------------------------------------------

USING rolandgarros;

DELETE FROM USER;
DELETE FROM JOUEUR;
DELETE FROM ARBITRE;
DELETE FROM EQUIPE;
DELETE FROM TERRAIN;
DELETE FROM INFOMATCH;
DELETE FROM MATCHSIMPLE;
DELETE FROM MATCHDOUBLE;
DELETE FROM TOURNOI;
DELETE FROM MATCHSTOUR;

DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS JOUEUR;
DROP TABLE IF EXISTS ARBITRE;
DROP TABLE IF EXISTS EQUIPE;
DROP TABLE IF EXISTS TERRAIN;
DROP TABLE IF EXISTS INFOMATCH;
DROP TABLE IF EXISTS MATCHSIMPLE;
DROP TABLE IF EXISTS MATCHDOUBLE;
DROP TABLE IF EXISTS TOURNOI;
DROP TABLE IF EXISTS MATCHSTOUR;

-------------------------------------------------------------------------------------------------
--        					             CREATE TABLES                                         --
-------------------------------------------------------------------------------------------------

CREATE TABLE USER(
    IDUSER                  INT(4)               NOT NULL           AUTO_INCREMENT,
    NOMUSER                 VARCHAR(50)          NOT NULL,
    PRENOMUSER              VARCHAR(50)          NOT NULL,
    MAILUSER                VARCHAR(50)          NOT NULL,
    PASSWORDUSER            VARCHAR(50)          NOT NULL,
    STATUS                  INT(1)               NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (IDUSER),
    CONSTRAINT UK_MAILUSER UNIQUE (MAILUSER)
);

CREATE TABLE JOUEUR(
    IDJO                    INT(4)               NOT NULL    		AUTO_INCREMENT,
    NOMJO                   VARCHAR(50)          NOT NULL,
    PRENOMJO                VARCHAR(50)          NOT NULL,
    NATIOJO					VARCHAR(50)			 NOT NULL,
    CLASSEMENTJO            INT(4)               NULL,
    CONSTRAINT PK_JOUEUR PRIMARY KEY (IDJO)
);

CREATE TABLE ARBITRE(
    IDARB                    INT(4)              NOT NULL    		AUTO_INCREMENT,
    NOMARB                   VARCHAR(50)         NOT NULL,
    PRENOMARB                VARCHAR(50)         NOT NULL,
    NATIOARB				 VARCHAR(50)		 NOT NULL,
    CONSTRAINT PK_ARBITRE PRIMARY KEY (IDARB)
);

CREATE TABLE EQUIPE(
    IDEQ                     INT(4)              NOT NULL    		AUTO_INCREMENT,
    NOMEQ                    VARCHAR(50)         NOT NULL,
    IDJOA                    INT(4)          	 NOT NULL,
    IDJOB				     INT(4) 		 	 NOT NULL,
    CONSTRAINT PK_EQUIPE    PRIMARY KEY (IDEQ),
    CONSTRAINT FK_ID_EQ_JOA FOREIGN KEY (IDJOA) REFERENCES JOUEUR(IDJO),
    CONSTRAINT FK_ID_EQ_JOB FOREIGN KEY (IDJOB) REFERENCES JOUEUR(IDJO)
);

CREATE TABLE TERRAIN(
    IDTER                    INT(4)              NOT NULL    		AUTO_INCREMENT,
    NOMTER                   VARCHAR(50)         NOT NULL,
    CONSTRAINT PK_TERRAIN      PRIMARY KEY (IDTER)
);

CREATE TABLE INFOMATCH(
    IDINFOM                  INT(4)              NOT NULL    		AUTO_INCREMENT,
    DUREEINFOM               TIME                NOT NULL,
    DATEINFOM                DATE           	 NOT NULL,
    SCOREAINFOM				 INT(4) 		 	 NULL,
    SCOREBINFOM				 INT(4) 		 	 NULL,
    TERRAININFOM			 INT(4)				 NOT NULL,
    ARBITREINFOM			 INT(4)				 NOT NULL,
    CONSTRAINT PK_INFOMATCH        PRIMARY KEY (IDINFOM),
    CONSTRAINT FK_ID_TERRAIN_INFOM FOREIGN KEY (TERRAININFOM) REFERENCES TERRAIN(IDTER),
    CONSTRAINT FK_ID_ARBITRE_INFOM FOREIGN KEY (ARBITREINFOM) REFERENCES ARBITRE(IDARB)
);

CREATE TABLE MATCHSIMPLE(
    IDMS                     INT(4)              NOT NULL    		AUTO_INCREMENT,
    INFOMS                   INT(4)         	 NOT NULL,
    IDJOA                    INT(4)          	 NULL,
    IDJOB				     INT(4) 		 	 NULL,
    CONSTRAINT PK_MATCHSIMPLE PRIMARY KEY (IDMS),
    CONSTRAINT FK_ID_INFOMS   FOREIGN KEY (INFOMS) REFERENCES INFOMATCH(IDINFOM),
    CONSTRAINT FK_ID_EQ_JOA   FOREIGN KEY (IDJOA) REFERENCES JOUEUR(IDJO),
    CONSTRAINT FK_ID_EQ_JOB   FOREIGN KEY (IDJOB) REFERENCES JOUEUR(IDJO)
);

CREATE TABLE MATCHDOUBLE(
    IDMD                     INT(4)              NOT NULL    		AUTO_INCREMENT,
    INFOMD                   INT(4)         	 NOT NULL,
    IDEQA                    INT(4)          	 NULL,
    IDEQB                    INT(4)          	 NULL,
    CONSTRAINT PK_ARBITRE     PRIMARY KEY (IDMD),
    CONSTRAINT FK_ID_INFOMD   FOREIGN KEY (INFOMD) REFERENCES INFOMATCH(IDINFOM),
    CONSTRAINT FK_ID_EQ_EQA   FOREIGN KEY (IDEQA)  REFERENCES EQUIPE(IDEQ),
    CONSTRAINT FK_ID_EQ_EQB   FOREIGN KEY (IDEQB)  REFERENCES EQUIPE(IDEQ)
);

CREATE TABLE TOURNOI(
    IDTOUR                   INT(4)              NOT NULL    		AUTO_INCREMENT,
    TYPEMATCH                INT(4)         	 NOT NULL,
    GENRE                    INT(4)          	 NOT NULL,
    CONSTRAINT PK_TOURNOI        PRIMARY KEY (IDTOUR),
    CONSTRAINT CHK_FCT_TYPEMATCH CHECK (TYPEMATCH IN ('Simple', 'Double')),
    CONSTRAINT CHK_FCT_GENRE     CHECK (GENRE IN ('Masculin', 'Feminin'))
);

CREATE TABLE MATCHSTOUR(
    IDTOUR                   INT(4)              NOT NULL    		AUTO_INCREMENT,
    IDMATCH                  INT(4)         	 NOT NULL,
    CONSTRAINT PK_TOURNOI        		PRIMARY KEY (IDTOUR, IDMATCH),
    CONSTRAINT FK_ID_MATCHSTOUR_TOUR    FOREIGN KEY (IDTOUR) REFERENCES  TOURNOI(IDTOUR),
    CONSTRAINT FK_ID_MATCHSTOUR_MATCH   FOREIGN KEY (IDMATCH) REFERENCES TOURNOI(IDMATCH)
);

-------------------------------------------------------------------------------------------------
--        					             TRIGGER                                               --
-------------------------------------------------------------------------------------------------

/*
create or replace trigger trigger_match_timing
before insert or update of DATEINFOM on INFOMATCH
for each row
declare
	pblmDateMatch exception;
begin
	if(:new.EstAnxieux = 0 AND :new.Indicateur != 0) then
		raise pblmAnxieux;
	end if;
exception
	when pblmAnxieux then
		raise_application_error(-20001, 'La personne n est pas anxieuse');
end;
/

CREATE TRIGGER trigger_match_timing
BEFORE INSERT OR UPDATE ON INFOMATCH
FOR EACH ROW
DECLARE
	pblmDateMatch exception;
BEGIN
 IF NEW.name = 'Moose' THEN
  UPDATE animal_count SET animal_count.animals = animal_count.animals+100;
 ELSE 
  UPDATE animal_count SET animal_count.animals = animal_count.animals+1;
 END IF;
END;
*/



