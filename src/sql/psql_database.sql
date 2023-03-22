-- Create a user with a password:
CREATE USER lifruk WITH PASSWORD 'Pa9g2y5yZoX';

-- Create a database lifruk_database owned by user lifruk with a default tablespace of lifrukspace:
CREATE DATABASE lifruk_database OWNER lifruk ENCODING 'UTF8';

CREATE TYPE game_type AS ENUM ('word', 'picture', 'audio');
CREATE TYPE difficulty_level AS ENUM ('easy', 'medium', 'hard');
CREATE TYPE languages AS ENUM ('english', 'lithuanian', 'ukrainian', 'french');

CREATE TABLE Picture (
        id SERIAL NOT NULL,
    link_pic TEXT NOT NULL,
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON Picture TO lifruk;

CREATE TABLE Word (
        id SERIAL NOT NULL,
    picture INT REFERENCES Picture(id),
    english_word TEXT,
    english_pronunciation TEXT,
    lithuanian_word TEXT,
    lithuanian_pronunciation TEXT,
    ukrainian_word TEXT,
    ukrainian_pronunciation TEXT,
    french_word TEXT,
    french_pronunciation TEXT,
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON Topic TO lifruk;

CREATE TABLE Topic (
        id SERIAL NOT NULL PRIMARY KEY,
    picture INT REFERENCES Picture(id),
    tname VARCHAR(25) NOT NULL
);

GRANT SELECT, UPDATE, INSERT ON Topic TO lifruk;

CREATE TABLE Player (
        id SERIAL NOT NULL,
    username VARCHAR(25) NOT NULL,
    email TEXT NOT NULL,
    age INT NOT NULL,
    pwd VARCHAR(25) NOT NULL,
    native_l languages NOT NULL,
    learning_l languages NOT NULL,
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON Player TO lifruk;

CREATE TABLE Game (
        id SERIAL NOT NULL,
    id_player INT REFERENCES Player(id),
    id_topic INT REFERENCES Topic(id),
    score INT DEFAULT 0,
    dlevel difficulty_level NOT NULL,
    language languages NOT NULL,
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON Game TO lifruk;

CREATE TABLE Flashcard (
        id SERIAL NOT NULL,
    id_word INT REFERENCES Word(id),
    id_topic INT REFERENCES Topic(id),
    gtype game_type NOT NULL,
    dlevel difficulty_level NOT NULL,
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON Flashcard TO lifruk;

CREATE TABLE Custom_Flashcard (
        id SERIAL NOT NULL,
    id_flashcard INT REFERENCES Flashcard(id),
    id_player INT REFERENCES Player(id),
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON Custom_Flashcard TO lifruk;



CREATE TABLE Question (
        id SERIAL NOT NULL,
    to_guess INT REFERENCES Word(id),
    dlevel difficulty_level NOT NULL,
    gtype game_type NOT NULL,
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON Question TO lifruk;

CREATE TABLE WrongAnswer (
        id SERIAL NOT NULL,
    id_player INT REFERENCES Player(id),
    id_Question INT REFERENCES Question(id),
        PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON WrongAnswer TO lifruk;