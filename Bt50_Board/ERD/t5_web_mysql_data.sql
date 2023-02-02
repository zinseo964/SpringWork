-- 기존테이블 삭제
DELETE FROM t5_file;
ALTER TABLE t5_file AUTO_INCREMENT = 1;
DELETE FROM t5_comment;
ALTER TABLE t5_comment AUTO_INCREMENT = 1;
DELETE FROM t5_write;
ALTER TABLE t5_write AUTO_INCREMENT = 1;
DELETE FROM t5_user_authorities;
ALTER TABLE t5_user_authorities AUTO_INCREMENT = 1;
DELETE FROM t5_authority;
ALTER TABLE t5_authority AUTO_INCREMENT = 1;
DELETE FROM t5_user ;
ALTER TABLE t5_user AUTO_INCREMENT = 1;

-- 샘플 authority
INSERT INTO t5_authority (name) VALUES
	('ROLE_MEMBER'), ('ROLE_ADMIN')
;
-- 샘플 사용자
INSERT INTO t5_user (username, password, name) VALUES
('USER1', '1234', '회원1'),
('USER2', '1234', '회원2'),
('ADMIN1', '1234', '관리자1')
-- ('USER1', '$2a$10$6gVaMy7.lbezp8bGRlV2fOArmA3WAk2EHxSKxncnzs28/m3DXPyA2', '회원1'),
-- ('USER2', '$2a$10$7LTnvLaczZbEL0gabgqgfezQPr.xOtTab2NAF/Yt4FrvTSi0Y29Xa', '회원2'),
-- ('ADMIN1', '$2a$10$53OEi/JukSMPr3z5RQBFH.z0TCYSUDPtxf1/8caRyRVdDNdHA9QHi', '관리자1')
;
-- 샘플 사용자-권한
INSERT INTO t5_user_authorities VALUES
(1, 1),
(3, 1),
(3, 2)
;
-- 샘플 글
INSERT INTO t5_write (user_id, subject, content) VALUES
(1, '제목입니다1', '내용입니다1'),
(1, '제목입니다2', '내용입니다2'),
(3, '제목입니다3', '내용입니다3'),
(3, '제목입니다4', '내용입니다4')
;
-- 샘플 댓글
INSERT INTO t5_comment(user_id, write_id, content) VALUES
(1, 1, '1. user1이 1번글에 댓글 작성.'),
(1, 1, '2. user1이 1번글에 댓글 작성.'),
(1, 2, '3. user1이 2번글에 댓글 작성.'),
(1, 2, '4. user1이 2번글에 댓글 작성.'),
(1, 3, '5. user1이 3번글에 댓글 작성.'),
(1, 3, '6. user1이 3번글에 댓글 작성.'),
(1, 4, '7. user1이 4번글에 댓글 작성.'),
(1, 4, '8. user1이 4번글에 댓글 작성.'),
(3, 1, '9. admin1이 1번글에 댓글 작성.'),
(3, 1, '10. admin1이 1번글에 댓글 작성.'),
(3, 2, '11. admin1이 2번글에 댓글 작성.'),
(3, 2, '12. admin1이 2번글에 댓글 작성.'),
(3, 3, '13. admin1이 3번글에 댓글 작성.'),
(3, 3, '14. admin1이 3번글에 댓글 작성.'),
(3, 4, '15. admin1이 4번글에 댓글 작성.'),
(3, 4, '16. admin1이 4번글에 댓글 작성.')
;
-- 샘플 댓글
INSERT INTO t5_file(write_id, source, file) VALUES
(1, 'face01.png', 'face01.png'),
(1, 'face02.png', 'face02.png'),
(2, 'face03.png', 'face03.png'),
(2, 'face04.png', 'face04.png'),
(3, 'face05.png', 'face05.png'),
(3, 'face06.png', 'face06.png'),
(4, 'face07.png', 'face07.png'),
(4, 'face08.png', 'face08.png')
;

