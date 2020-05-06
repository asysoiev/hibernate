create sequence course_seq
START WITH 10000
INCREMENT BY 1
;

create table course
(
    id        long         not null default course_seq.nextval,
    title     varchar(255) not null
);

create sequence passport_seq
START WITH 40000
INCREMENT BY 1
;

create table passport
(
    id        long         not null default passport_seq.nextval,
    number    varchar(255) not null
);

create sequence student_seq
START WITH 20000
INCREMENT BY 1
;

create table student
(
    id        long         not null default student_seq.nextval,
    name      varchar(255) not null,
    surname   varchar(255) not null,
    passport_id   long references passport(id)
);