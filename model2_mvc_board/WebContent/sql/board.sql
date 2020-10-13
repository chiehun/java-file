alter table board drop primary key cascade;
drop table board;

create table board(  
	num number(5) primary key,
	name varchar2(40),
	pass varchar2(20),   
	email varchar2(40),   
	title varchar2(100),   
	content varchar2(1000),   
	writedate date default sysdate,
	readcount number(7) default '0'
);

drop sequence board_seq;
create sequence board_seq start with 1;

