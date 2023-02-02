SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS t5_user_authorities;
DROP TABLE IF EXISTS t5_authority;
DROP TABLE IF EXISTS t5_comment;
DROP TABLE IF EXISTS t5_file;
DROP TABLE IF EXISTS t5_write;
DROP TABLE IF EXISTS t5_user;




/* Create Tables */

CREATE TABLE t5_authority
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(40) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (name)
);


CREATE TABLE t5_comment
(
	id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	write_id int NOT NULL,
	content text NOT NULL,
	regdate datetime DEFAULT now(),
	PRIMARY KEY (id)
);


CREATE TABLE t5_file
(
	id int NOT NULL AUTO_INCREMENT,
	write_id int NOT NULL,
	source varchar(100) NOT NULL,
	file varchar(100) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE t5_user
(
	id int NOT NULL AUTO_INCREMENT,
	username varchar(80) NOT NULL,
	password varchar(100) NOT NULL,
	name varchar(80) NOT NULL,
	regdate datetime DEFAULT now(),
	PRIMARY KEY (id),
	UNIQUE (username)
);


CREATE TABLE t5_user_authorities
(
	user_id int NOT NULL,
	authority_id int NOT NULL
);


CREATE TABLE t5_write
(
	id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	subject varchar(200) NOT NULL,
	content longtext,
	viewcnt int DEFAULT 0,
	regdate datetime DEFAULT now(),
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE t5_user_authorities
	ADD FOREIGN KEY (authority_id)
	REFERENCES t5_authority (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE t5_comment
	ADD FOREIGN KEY (user_id)
	REFERENCES t5_user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t5_user_authorities
	ADD FOREIGN KEY (user_id)
	REFERENCES t5_user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE t5_write
	ADD FOREIGN KEY (user_id)
	REFERENCES t5_user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE t5_comment
	ADD FOREIGN KEY (write_id)
	REFERENCES t5_write (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE t5_file
	ADD FOREIGN KEY (write_id)
	REFERENCES t5_write (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;



