-- Crear la base de datos "techtest"
DROP DATABASE techtest;
CREATE DATABASE techtest;

\connect techtest

-- Crear la tabla "Tabla1"
CREATE TABLE Tabla1 (
    Lat VARCHAR,
    Lng VARCHAR,
    Campo1 VARCHAR,
    Campo2 VARCHAR,
    PRIMARY KEY(Lat, Lng)
);

CREATE TABLE Usuario (
    username VARCHAR,
    encrypted_password VARCHAR,
    PRIMARY KEY(username)
);

INSERT INTO tabla1(
	lat, lng, campo1, campo2)
	VALUES ('1', '2', 'info11', 'info12');

INSERT INTO public.usuario(
	username, encrypted_password)
	VALUES ('usuario', '$2a$10$klgAouJYtGx7m1A/WqP.keQjHZHgrwcAEcvpHHwHPbGIDVeDJG8W.');

