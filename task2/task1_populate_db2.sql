drop database IF EXISTS teste2;

create database teste2;

use teste2;

create table events (
	event_type integer not null,
	value integer not null,
	time timestamp not null,
	unique (event_type, time)
);

insert into events values (2,   5, '2015-05-09 12:42:00');
insert into events values (4, -42, '2015-05-09 13:19:57');
insert into events values (2,   2, '2015-05-09 14:48:30');
insert into events values (2,   7, '2015-05-09 12:54:39');
insert into events values (3,  16, '2015-05-09 13:19:57');
insert into events values (3,  20, '2015-05-09 22:01:09');
insert into events values (3,  16, '2016-05-09 13:19:57');
insert into events values (3,  20, '2015-05-09 01:01:09');
insert into events values (4,   0, '2015-05-09 05:19:57');
insert into events values (4, 1, '2015-05-09 13:18:58');
insert into events values (4,   1, '2016-05-09 12:19:57');
insert into events values (2,   3, '2015-05-09 14:11:30');
insert into events values (2,   2, '2015-05-09 19:54:39');


