drop database if exists hrdsystem;
create database hrdsystem;
use hrdsystem;

drop table if exists department;
create table department(
	dno int auto_increment ,
    dname varchar(20) , 
    dcontact varchar(20) unique, 
    primary key(dno)
);

drop table if exists employees;
create table employees(
	eno int auto_increment , 
    ename varchar(20) ,
    econtact varchar(20) unique , 
    position varchar(20) , 
    dno int , 
    primary key(eno) , 
    foreign key (dno) references department(dno)
    on update cascade
    on delete cascade
);

select * from department;
select * from employees;

insert into department(dname , dcontact) values ('마케팅' , '02-222-2222');

insert into employees(ename , econtact , position , dno) values('유재석' , '010-111-1111' , '과장' , (select dno from department where dname = '마케팅'));

select dno from department where dname = '마케팅';

select * from employees inner join department on employees.dno = department.dno;





