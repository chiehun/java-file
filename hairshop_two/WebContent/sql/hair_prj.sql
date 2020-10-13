-- 관리자 테이블
create table worker(
   workerid varchar2(10),
   workerpw varchar2(10)
);


insert into worker values('admin1', '1234');
insert into worker values('admin2', '1234');


-- 고객 정보 테이블
create table rPWjd (
   id varchar2(20),			-- id
   pwd varchar2(20),		-- pw
   name varchar2(40),		-- 성명
   phoneNumber varchar2(20),-- 연락처
   address varchar2(60),	-- 주소
   enroll date default sysdate, -- 등록일자
   constraint pk_rPWjd primary key(id)
);

-- 예약번호 시퀸스
create sequence dpdir_seq start with 1;

-- 예약 테이블
create table dPdir (
   rsv_seq number(10)		-- 예약번호
   rsv_date varchar2(40),	-- 
   rsv_time varchar2(40),
   rsv_status char(1) default 0,
   p_type varchar2(60),
   id varchar2(20),
	constraint pk_dpdir primary key(rsv_seq),
	constraint fk_id foreign key(id) REFERENCES rPWjd (id)
);

-- 시술내역 테이블
create table sangSE (
   rsv_seq number(10),
   rsv_date varchar2(20),
   p_type varchar2(20),
   id varchar2(15),
   constraint fk_rsv_date foreign key(rsv_seq) REFERENCES dPdir (rsv_seq)
);

insert into rPWjd values('hoon', '1234', '최훈', '010-1234-1234', '인천 어딘가', sysdate);
insert into rPwjd values('kjh', '1234', '김진혁', '010-2608-2608', '서울 어딘가', sysdate);
insert into rPwjd values('lsw', '1234', '이상우', '010-5678-5678',' 경기 어딘가', sysdate);

select * from dPdir; -- 예약 테이블

insert into dPdir ( rsv_seq, rsv_date, rsv_time, rsv_status, p_type, id) values (dpdir_seq.nextval, '2020-08-24', '06:30 am', '2', '삭발', 'gogeck1');
insert into dPdir ( rsv_seq, rsv_date, rsv_time, rsv_status, p_type, id) values (dpdir_seq.nextval, '2020-08-10', '04:10 am', '2', '펌', 'gogeck2');
insert into dPdir ( rsv_seq, rsv_date, rsv_time, rsv_status, p_type, id) values (dpdir_seq.nextval, '2020-08-27', '06:10 am', '2', '삭발', 'gogeck3');
insert into dPdir ( rsv_seq, rsv_date, rsv_time, rsv_status, p_type, id) values (dpdir_seq.nextval, '2020-08-12', '07:30 am', '2', '염색', 'gogeck4');
insert into dPdir ( rsv_seq, rsv_date, rsv_time, rsv_status, p_type, id) values (dpdir_seq.nextval, '2020-08-23', '08:30 am', '2', '염색', 'gogeck5');

select * from sangSE; -- 상세조회
insert into sangSE (rsv_seq, rsv_date, id, p_type) values (1, '2020-09-26', 'gogeck1', '삭발');
insert into sangSE (rsv_seq, rsv_date, id, p_type) values (2, '2020-09-25', 'gogeck2', '펌');
insert into sangSE (rsv_seq, rsv_date, id, p_type) values (3, '2020-09-15', 'gogeck3', '삭발');
insert into sangSE (rsv_seq, rsv_date, id, p_type) values (4, '2020-09-10', 'gogeck4', '염색');
insert into sangSE (rsv_seq, rsv_date, id, p_type) values (5, '2020-09-25', 'gogeck5', '염색');
commit;