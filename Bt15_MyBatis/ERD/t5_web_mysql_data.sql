delete from t5_test_write;
alter table t5_test_write AUTO_INCREMENT = 1;

insert into t5_test_write (user, subject, content) values
('user1', 'subject1', 'content1'),
('user2', 'subject2', 'content2'),
('user3', 'subject3', 'content3'),
('user4', 'subject4', 'content4'),
('user5', 'subject5', 'content5')
;