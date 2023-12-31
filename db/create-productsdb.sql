/* DELETE 'db' database*/
DROP SCHEMA IF EXISTS db;
/* DELETE USER 'user' AT LOCAL SERVER*/
DROP USER IF EXISTS 'user'@'%';

/* CREATE ''db' DATABASE */
CREATE SCHEMA IF NOT EXISTS db;
/* CREATE THE USER 'user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'user' AT LOCAL SERVER*/
GRANT ALL ON db.* TO 'user'@'%';