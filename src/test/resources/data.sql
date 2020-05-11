insert into course(title)
values ('Master Docker with Java - DevOps for Spring Microservices');
insert into course(title)
values ('Master Hibernate and JPA with Spring Boot in 100 Steps');
insert into course(title)
values ('Master Microservices with Spring Boot and Spring Cloud');
insert into course(title)
values ('Java Application Performance and Memory Management');

insert into review(rate, comment, course_id)
values (4, 'Sometimes boring and harmful style of examples.',
        select id from course where title = 'Master Hibernate and JPA with Spring Boot in 100 Steps');
insert into review(rate, comment, course_id)
values (3, 'It will be a great if you have one topic for samples across all courses.',
        select id from course where title = 'Master Hibernate and JPA with Spring Boot in 100 Steps');
insert into review(rate, comment, course_id)
values (5, 'Good introduction into Spring Microservices World.',
        select id from course where title = 'Master Microservices with Spring Boot and Spring Cloud');

insert into passport(number) values ('A1234567');
insert into passport(number) values ('A1234568');
insert into passport(number) values ('A1234569');
insert into student(name, surname, passport_id)
values ('Vladimir', 'Rurik', select id from passport where number = 'A1234567');
insert into student(name, surname, passport_id)
values ('Yaroslav', 'Rurik', select id from passport where number = 'A1234568');
insert into student(name, surname, passport_id)
values ('Bohdan', 'Khmelnytsky', select id from passport where number = 'A1234569');

insert into course_student(course_id, student_id)
values (select id from course where title = 'Master Hibernate and JPA with Spring Boot in 100 Steps',
        select id from student where name = 'Vladimir');
insert into course_student(course_id, student_id)
values (select id from course where title = 'Master Microservices with Spring Boot and Spring Cloud',
        select id from student where name = 'Vladimir');
insert into course_student(course_id, student_id)
values (select id from course where title = 'Master Microservices with Spring Boot and Spring Cloud',
        select id from student where name = 'Yaroslav');
insert into course_student(course_id, student_id)
values (select id from course where title = 'Master Docker with Java - DevOps for Spring Microservices',
        select id from student where name = 'Bohdan');

-- single table strategy
insert into employee(name, employee_type, salary)
values ('Vladimir', 'FULL_TIME', '10000');
insert into employee(name, employee_type, hourly_wage)
values ('Bohdan', 'PART_TIME', '50');