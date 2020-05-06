insert into course(title)
values ('Master Docker with Java - DevOps for Spring Microservices');
insert into course(title)
values ('Master Hibernate and JPA with Spring Boot in 100 Steps');
insert into course(title)
values ('Master Microservices with Spring Boot and Spring Cloud');

insert into passport(number)
values ('A1234567');
insert into student(name, surname, passport_id)
values ('Vladimir', 'Rurik', select id from passport where number = 'A1234567');