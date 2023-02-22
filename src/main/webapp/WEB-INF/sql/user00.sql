create table userSample(
    id varchar2(40) not null primary key,
    name varchar2(50) not null,
    nickName varchar2(50) not null,
    pwd varchar2(40) not null
);

insert into usersample values('kkk','kang','gnak','123');
insert into usersample values('ggg','gim','mig','234');
insert into usersample values('ppp','park','krap','345');
insert into usersample values('uuu','uoo','oou','456');

commit;