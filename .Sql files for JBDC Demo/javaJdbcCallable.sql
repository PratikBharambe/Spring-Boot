drop procedure if exists pro1;
delimiter $

create procedure pro1(in x int, in y int, out z int)
begin
	set z := x * y;
end $

delimiter ;

drop table if exists userinfo;

create table userinfo (uname varchar(30), password varchar(30), id int, sal int);

insert into userinfo values('admin1', 'admin1', 1, 1234),
('admin2', 'admin2', 2, 5678),
('user1', 'user1', 3, 9101),
('user2', 'user2', 4, 1123),
('mantri1', 'mantri1', 5, 1010),
('mantri1', 'mantri1', 6, 1248),
('senapati1', 'senapati1', 7, 1268),
('senapati1', 'senapati1', 8, 1587);