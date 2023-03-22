-- Create a user with a password:
CREATE USER lifruk WITH PASSWORD 'Pa9g2y5$yZoX';

-- Create a database lifruk_database owned by user lifruk with a default tablespace of lifrukspace:
CREATE DATABASE lifruk_database OWNER lifruk ENCODING 'UTF8';

CREATE TYPE difficulty_level AS ENUM ('easy', 'medium', 'hard');
CREATE TYPE kind_of_link AS ENUM ('picture', 'voice');

CREATE TABLE player (
	id SERIAL NOT NULL,
    email TEXT NOT NULL,
    username VARCHAR(25) NOT NULL,
    pwd VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON player TO lifruk;

CREATE TABLE pictures (
	id SERIAL NOT NULL,
    link_pic_1 TEXT NOT NULL,
    link_pic_2 TEXT NOT NULL,
    link_pic_3 TEXT NOT NULL,
    link_pic_4 TEXT NOT NULL,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON pictures TO lifruk;

CREATE TABLE theme (
	id SERIAL NOT NULL,
    tname VARCHAR(25) NOT NULL,
    link_pic TEXT NOT NULL,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON theme TO lifruk;

CREATE TABLE quiz_4_pictures (
	id SERIAL NOT NULL,
    id_pictures INT REFERENCES pictures(id),
    response INT NOT NULL,
    id_theme INT REFERENCES theme(id),
    dlevel difficulty_level,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON quiz_4_pictures TO lifruk;

CREATE TABLE quiz_4_pictures_word (
	id SERIAL NOT NULL,
    id_quiz_4_pictures INT REFERENCES quiz_4_pictures(id),
    word VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON quiz_4_pictures_word TO lifruk;

CREATE TABLE quiz_4_pictures_voice (
	id SERIAL NOT NULL,
    id_quiz_4_pictures INT REFERENCES quiz_4_pictures(id),
    voice TEXT NOT NULL,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON quiz_4_pictures_voice TO lifruk;

CREATE TABLE quiz_picture_word (
	id SERIAL NOT NULL,
    link_pic TEXT NOT NULL,
    response VARCHAR(25) NOT NULL,
    id_theme INT REFERENCES theme(id),
    dlevel difficulty_level,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON quiz_picture_word TO lifruk;

CREATE TABLE flashcard (
	id SERIAL NOT NULL,
    response VARCHAR(25) NOT NULL,
    id_theme INT REFERENCES theme(id),
    dlevel difficulty_level,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON flashcard TO lifruk;

CREATE TABLE flashcard_link (
	id SERIAL NOT NULL,
    id_flashcard INT REFERENCES flashcard(id),
    link TEXT NOT NULL,
    klink kind_of_link,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON flashcard_link TO lifruk;

CREATE TABLE flashcard_word (
	id SERIAL NOT NULL,
    id_flashcard INT REFERENCES flashcard(id),
    word VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
);
GRANT SELECT, UPDATE, INSERT ON flashcard_word TO lifruk;
