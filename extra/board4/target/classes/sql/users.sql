select * from users;

create table roles(
role varchar2(20) primary key,
roleName varchar2(30),
description varchar2(50)
);

select * from roles;

insert into roles values('admin','admin','관리자권한');
insert into roles values('user','user','일반권한');
insert into roles values('operator','operator','사용자권한');