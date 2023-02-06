SHOW TABLES;

SELECT TABLE_NAME FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'mydb2211'
AND TABLE_NAME LIKE 't5_%'
;

SELECT * FROM t5_authority;
SELECT * FROM t5_user ORDER BY id DESC;
SELECT * FROM t5_user_authorities;
SELECT * FROM t5_write ORDER BY id DESC;
SELECT * FROM t5_comment ORDER BY id DESC;
SELECT * FROM t5_file ORDER BY id DESC;

-- 특정 id 의 사용자 조회
SELECT 
	id "id"
	, username "username"
	, password "password"
	, name "name"
	, regdate "regdate"
FROM t5_user
WHERE id = 1
;

-- 특정 name 의 authority 조회
SELECT
	id "id"
	, name "name"
FROM t5_authority
WHERE name = 'ROLE_ADMIN'
;

-- 특정 사용자의 authority 조회
SELECT a.id "id", a.name "auth_name"
FROM t5_authority a, t5_user_authorities u 
WHERE a.id = u.authority_id  AND  u.user_id = 3
;

-- 페이징 테스트용 다량의 데이터
INSERT INTO t5_write(user_id, subject, content)
SELECT user_id, subject, content FROM t5_write;

SELECT count(*) FROM t5_write;

SELECT * FROM t5_write ORDER BY id desc limit 5;

SELECT * FROM t5_write ORDER BY id desc limit 5, 5;

DELETE FROM t5_write WHERE id > 8;