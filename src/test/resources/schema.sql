create sequence course_seq
START WITH 10000
INCREMENT BY 1
;

create table course
(
    id        long         not null default course_seq.nextval,
    title     varchar(255) not null
);
