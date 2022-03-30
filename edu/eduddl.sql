select eno, title, acadamy_name, edu_period, edu_app_period,acadamy_add
from (
        select row_number() over (order by eno desc) num,educations.*
        from educations
        where edu_deleteYN ='N'
        order by eno desc)
where  edu_deleteYN = 'N' and num between 10 and 20 ;
select count(*)
from educations
where edu_deleteYN = 'Y';
drop sequence eduno;

create sequence eduno
minvalue 1
maxvalue 9999
increment by 1
start with 1
nocycle;

drop table educations;

create table educations(
    eno number(20) constraint educations_eno_pk primary key,
    title varchar2(500 byte),
    imgsrc varchar2(500 byte),
    academy_name varchar2(60 byte),
    academy_phone varchar2(15 byte),
    academy_add varchar2(100 byte),
    edu_field varchar2(150 byte),
    edu_type varchar2(30 byte),
    edu_process varchar2(400 byte),
    edu_count varchar2(10 byte),
    edu_period varchar2(30 byte),
    edu_location varchar2(50 byte),
    edu_price varchar2(20 byte),
    edu_privilege varchar2(300 byte),
    edu_app_period varchar2(20 byte),
    edu_deleteYN varchar2(2 byte) default 'N'
);

commit;      