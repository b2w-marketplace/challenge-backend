drop database IF EXISTS teste4;

create database teste4;

use teste4;

create table events (
	event_type integer not null,
	value integer not null,
	time timestamp not null,
	unique (event_type, time)
);

insert into events values (1,   1,  '2015-05-09 01:42:00');
insert into events values (1, 	2,  '2015-05-09 02:19:57');
insert into events values (2,   3,  '2015-05-09 03:48:30');
insert into events values (2,   4,  '2015-05-09 04:54:39');
insert into events values (3,  	5,  '2015-05-09 05:19:57');
insert into events values (3,  	6,  '2015-05-09 06:01:09');
insert into events values (4,  	7,  '2016-05-09 07:19:57');
insert into events values (4,  	8,  '2015-05-09 08:01:09');
insert into events values (5,   9,  '2015-05-09 09:19:57');
insert into events values (5, 	10, '2015-05-09 10:18:58');
insert into events values (6,   11, '2016-05-09 11:19:57');
insert into events values (6,   12, '2015-05-09 12:11:30');
insert into events values (7,   13, '2015-05-09 13:11:30');
insert into events values (1,   1,  '2015-05-09 14:42:00');
insert into events values (1, 	2,  '2015-05-09 15:19:57');
insert into events values (2,   3,  '2015-05-09 16:48:30');
insert into events values (2,   4,  '2015-05-09 17:54:39');
insert into events values (3,  	5,  '2015-05-09 18:19:57');
insert into events values (3,  	6,  '2015-05-09 19:01:09');
insert into events values (4,  	7,  '2016-05-09 20:19:57');
insert into events values (4,  	8,  '2015-05-09 21:01:09');
insert into events values (5,   9,  '2015-05-09 22:19:57');
insert into events values (5, 	10, '2015-05-09 23:18:58');
insert into events values (6,   11, '2016-05-09 23:19:57');
insert into events values (6,   12, '2015-05-09 14:10:31');
insert into events values (7,   13, '2015-05-09 14:20:30');
insert into events values (1,   1,  '2015-05-09 12:30:00');
insert into events values (1, 	2,  '2015-05-09 13:40:57');
insert into events values (2,   3,  '2015-05-09 14:50:30');
insert into events values (2,   4,  '2015-05-09 12:59:01');
insert into events values (3,  	5,  '2015-05-09 13:19:05');
insert into events values (3,  	6,  '2015-05-09 22:01:10');
insert into events values (4,  	7,  '2016-05-09 13:19:15');
insert into events values (4,  	8,  '2015-05-09 01:01:20');
insert into events values (5,   9,  '2015-05-09 05:19:25');
insert into events values (5, 	10, '2015-05-09 13:18:30');
insert into events values (6,   11, '2016-05-09 12:19:35');
insert into events values (6,   12, '2015-05-09 14:11:40');
insert into events values (7,   13, '2015-05-09 14:11:45');
insert into events values (1,   1,  '2015-05-09 12:42:50');
insert into events values (1, 	2,  '2015-05-09 13:19:59');
insert into events values (2,   3,  '2015-05-09 14:01:30');
insert into events values (2,   4,  '2015-05-09 12:02:39');
insert into events values (3,  	5,  '2015-05-09 13:03:57');
insert into events values (3,  	6,  '2015-05-09 22:04:09');
insert into events values (4,  	7,  '2016-05-09 13:05:57');
insert into events values (4,  	8,  '2015-05-09 01:06:09');
insert into events values (5,   9,  '2015-05-09 05:07:57');
insert into events values (5, 	10, '2015-05-09 13:08:58');
insert into events values (6,   11, '2016-05-09 12:09:57');
insert into events values (6,   12, '2015-05-09 14:10:30');
insert into events values (7,   13, '2015-05-09 14:11:30');



