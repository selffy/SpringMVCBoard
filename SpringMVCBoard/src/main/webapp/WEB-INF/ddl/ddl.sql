-- [CMD]
-- sys 계정으로 오라클 접속
-- sqlplus system/password
-- # 사용자 계정 생성
-- SQL> create user springmvcboard identified by springmvcboard;
-- # 사용자 권한 부여
-- SQL> grant connect, resource, dba to springmvcboard;

-- [DBeaver]

# 테이블 생성
CREATE TABLE board(
	bno number(10, 0),
	title varchar2(2000) NOT NULL,
	content varchar2(4000) NOT NULL,
	writer varchar2(50) NOT NULL,
	regdate DATE DEFAULT sysdate,
	UPDATEdate DATE DEFAULT sysdate
);

CREATE TABLE reply(
	rno number(10, 0),
	bno NUMBER(10, 0) NOT NULL,
	reply varchar2(2000) NOT NULL,
	replyer varchar2(200) NOT NULL,
	replydate DATE DEFAULT sysdate,
	updateDate DATE DEFAULT sysdate
);

COMMENT ON COLUMN board.bno IS '번호';
COMMENT ON COLUMN board.title IS '제목';
COMMENT ON COLUMN board.content IS '내용';
COMMENT ON COLUMN board.writer IS '작성자';
COMMENT ON COLUMN board.regdate IS '작성일시';
COMMENT ON COLUMN board.updatedate IS '수정일시';

COMMENT ON COLUMN reply.rno IS '댓글번호';
COMMENT ON COLUMN reply.bno IS '게시물번호(FK)';
COMMENT ON COLUMN reply.reply IS '댓글내용';
COMMENT ON COLUMN reply.replyer IS '댓글작성자';
COMMENT ON COLUMN reply.replydate IS '댓글작성일시';
COMMENT ON COLUMN reply.updateDate IS '댓글수정일시';

# PK 설정 및 SEQUENCE 설정
CREATE SEQUENCE seq_board INCREMENT BY 1;

ALTER TABLE board ADD CONSTRAINTS pk_board PRIMARY KEY(bno);

CREATE SEQUENCE seq_reply INCREMENT BY 1;

ALTER TABLE reply ADD CONSTRAINT pk_reply PRIMARY key(rno);

ALTER TABLE reply ADD CONSTRAINT fk_reply_board FOREIGN KEY (bno) REFERENCES board(bno);

# 더미 데이터 생성
INSERT INTO board(bno, title, content, writer) values(seq_board.nextval, '제목1', '내용1', '작성자1');
INSERT INTO board(bno, title, content, writer) values(seq_board.nextval, '제목2', '내용2', '작성자2');
INSERT INTO board(bno, title, content, writer) values(seq_board.nextval, '제목3', '내용3', '작성자3');

INSERT INTO reply(rno, bno, reply, replyer) values(seq_reply.nextval, 5, '더미 댓굴1', '댓글작성자1' );
INSERT INTO reply(rno, bno, reply, replyer) values(seq_reply.nextval, 5, '더미 댓굴2', '댓글작성자2' );
INSERT INTO reply(rno, bno, reply, replyer) values(seq_reply.nextval, 5, '더미 댓굴3', '댓글작성자3' );
INSERT INTO reply(rno, bno, reply, replyer) values(seq_reply.nextval, 5, '더미 댓굴4', '댓글작성자4' );
INSERT INTO reply(rno, bno, reply, replyer) values(seq_reply.nextval, 5, '더미 댓굴5', '댓글작성자5' );
INSERT INTO reply(rno, bno, reply, replyer) values(seq_reply.nextval, 5, '더미 댓굴6', '댓글작성자6' );