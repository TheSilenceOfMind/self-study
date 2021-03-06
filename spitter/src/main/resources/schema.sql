/* script to create PDB schema to store all info */

CREATE TABLE Spittle (
  id         INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  message    VARCHAR(140) NOT NULL,
  created_at TIMESTAMP    NOT NULL,
  latitude   DOUBLE PRECISION,
  longitude  DOUBLE PRECISION
);

CREATE TABLE Spitter (
  id         INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  username   VARCHAR(20) UNIQUE NOT NULL,
  password   VARCHAR(20)        NOT NULL,
  first_name VARCHAR(30)        NOT NULL,
  last_name  VARCHAR(30)        NOT NULL,
  email      VARCHAR(30)        NOT NULL
);