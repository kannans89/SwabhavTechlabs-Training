/*create table college(id int primary key, name varchar(50), location varchar(50));
create table employee(id int primary key, first_name varchar(50),last_name varchar(50), salary float, contact varchar(20), dept_id int);
create table department(id int primary key, name varchar(50));*/

create table studentemployeemap(student_id int, employee_id int, primary key(student_id, employee_id));
