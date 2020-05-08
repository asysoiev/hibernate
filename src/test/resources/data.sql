insert into course(title)
values ('Master Docker with Java - DevOps for Spring Microservices');
insert into course(title)
values ('Master Hibernate and JPA with Spring Boot in 100 Steps');
insert into course(title)
values ('Master Microservices with Spring Boot and Spring Cloud');

insert into review(rate, comment, course_id)
values (4, 'Sometimes boring and harmful style of examples.',
        select id from course where title = 'Master Hibernate and JPA with Spring Boot in 100 Steps');
insert into review(rate, comment, course_id)
values (3, 'It will be a great if you have one topic for samples across all courses.',
        select id from course where title = 'Master Hibernate and JPA with Spring Boot in 100 Steps');
insert into review(rate, comment, course_id)
values (5, 'Good introduction into Spring Microservices World.',
        select id from course where title = 'Master Microservices with Spring Boot and Spring Cloud');

insert into passport(number)
values ('A1234567');
insert into student(name, surname, passport_id)
values ('Vladimir', 'Rurik', select id from passport where number = 'A1234567');