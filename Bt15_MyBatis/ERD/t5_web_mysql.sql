DROP TABLE IF EXISTS t5_test_write;

create table t5_test_write
(
    id int PRIMARY KEY AUTO_INCREMENT,
    user varchar(20) NOT NULL,
    subject varchar(200) NOT NULL,
    content longtext,
    viewcnt int DEFAULT 0,
    regdate datetime DEFAULT now()
);