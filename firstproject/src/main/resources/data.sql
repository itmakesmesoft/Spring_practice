INSERT INTO article VALUES(1, 'aaa', 'aaa');
INSERT INTO article VALUES(2, 'bbb', 'bbb');
INSERT INTO article VALUES(3, 'ccc', 'ccc');


-- article 더미데이터
INSERT INTO article(id, title, content) VALUES(4, 'hello', 'rrr');
INSERT INTO article(id, title, content) VALUES(5, 'world', 'rrrr');
INSERT INTO article(id, title, content) VALUES(6, 'spring', 'rrrrr');

-- comment 더미데이터
-- 4번 게시글
INSERT INTO comment(id, article_id, nickname, body) VALUES(1, 4, 'user1', 'comment1');
INSERT INTO comment(id, article_id, nickname, body) VALUES(2, 4, 'user2', 'comment2');
INSERT INTO comment(id, article_id, nickname, body) VALUES(3, 4, 'user3', 'comment3');

-- 5번 게시글
INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 5, 'user1', 'comment4');
INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 5, 'user2', 'comment5');
INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 5, 'user3', 'comment6');

-- 6번 게시글
INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 6, 'user1', 'comment7');
INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 6, 'user2', 'comment8');
INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 6, 'user3', 'comment9');