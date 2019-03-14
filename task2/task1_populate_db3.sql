drop database IF EXISTS teste3;

create database teste3;

use teste3;

create table events (
	event_type integer not null,
	value integer not null,
	time timestamp not null,
	unique (event_type, time)
);

insert into events values (1,   1,  '2015-05-09 12:42:00');
insert into events values (1, 	2,  '2015-05-09 13:19:57');
insert into events values (2,   3,  '2015-05-09 14:48:30');
insert into events values (2,   4,  '2015-05-09 12:54:39');
insert into events values (3,  	5,  '2015-05-09 13:19:57');
insert into events values (3,  	6,  '2015-05-09 22:01:09');
insert into events values (4,  	7,  '2016-05-09 13:19:57');
insert into events values (4,  	8,  '2015-05-09 01:01:09');
insert into events values (5,   9,  '2015-05-09 05:19:57');
insert into events values (5, 	10, '2015-05-09 13:18:58');
insert into events values (6,   11, '2016-05-09 12:19:57');
insert into events values (6,   12, '2015-05-09 14:11:30');
insert into events values (7,   13, '2015-05-09 14:11:30');



