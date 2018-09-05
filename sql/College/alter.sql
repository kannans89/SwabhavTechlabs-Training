/*alter table student modify column cgpa float;

alter table student add college_id int;

alter table student add foreign key (college_id) references college(id);

alter table employee add foreign key (dept_id) references department(id);

alter table department add college_id int;*/

alter table department add constraint fk_college_id foreign key (college_id) references college(id);
