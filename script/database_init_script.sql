 -------------------------------------------------------------------------------------------------
 --                                      SETUP DATABASE                                         --
 -------------------------------------------------------------------------------------------------

-- Setup de la base de données avec l'utilisateur :

DROP DATABASE IF EXISTS rolandgarros;
CREATE DATABASE rolandgarros;

DROP USER IF EXISTS 'cactus'@localhost;
CREATE USER 'cactus'@localhost IDENTIFIED BY 'Cactus2020';
GRANT ALL PRIVILEGES ON *.* TO 'cactus'@localhost IDENTIFIED BY 'Cactus2020';