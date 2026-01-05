CREATE DATABASE jspstudy;
USE jspstudy;

CREATE TABLE users (
    id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(50)
);

INSERT INTO users (id, password, name)
VALUES ('admin', '1234', '관리자');
