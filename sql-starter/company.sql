create schema company_storage;

drop schema company_storage;

create table company(
	id INT primary key,
	name varchar(128) unique not null,
	date DATE not null check(date > '1995-01-01' and date < '2020-01-01')
);

drop table company ;

insert into company (id, name, date)
values (1, 'Google', '2001-01-1'),
	   (2, 'Apple', '2002-10-29'),
	   (3, 'Facebook', '1998-09-13');

create table employee(
	id SERIAL primary key ,
	first_name varchar(128) not null,
	last_name varchar(128) not null,
	company_id int references company(id) on delete cascade,
	salary int ,
	unique(first_name, last_name)
--	foreign key(company_id) references company
);

drop table employee ;

insert into employee (first_name, last_name, salary, company_id)
values
	('Rich', 'Gold', 1340, 1),
	('Ivan', 'Sidorov', 500, 1),
	('Ivan', 'Ivanov', 1000, 2),
	('Anri', 'Paramonov', null, 2),
	('Petr', 'Petrov', 2000, 3),
	('Sveta', 'Svetikova', 1500, null);


select * from company c ;

select distinct
	   id,
	   first_name f_name,
	   last_name  l_name,
	   salary
from employee e
where salary in (1000, 1100, 2000)
	or (first_name like 'Iv%'
	and last_name ilike '%ov%'
order by first_name, salary desc
--limit 2
--offset 2;

select
	lower(first_name),
--	concat(first_name, ' ', last_name) fio
	first_name || ' ' || last_name fio,
	now()
from employee e ;

select now(), 1 * 2 + 3

select
	id, first_name
from employee e
where company_id is not null
union
select
	id, first_name
from employee e
where salary is null

select
	avg(e.salary)
from (select
		*
	  from employee
	  order by salary desc
	  limit 2) e


select *,
	(select max(salary) from employee) - salary diff

--	(select avg(salary) from employee) avg,
--	(select max(salary) from employee) max
from employee e


select *
from employee e
where company_id in (select company.id from company where date > '2000-01-01');


select * from (values (1, 'Google', '2001-01-1'),
	   				  (2, 'Apple', '2002-10-29'),
	                  (3, 'Facebook', '1998-09-13')) t

delete from employee
where salary is null;

delete
from employee
where salary = (select max(salary) from employee);

delete
from employee
where company_id = 1;

delete
from company
where id = 2;

select *
from employee e ;

update employee
set company_id = 1,
	salary = 1700
where id = 5 or id = 4
returning id, first_name || ' ' || last_name fio;

create table contact(
	id SERIAL primary key ,
	 "number" varchar(128) not null,
	type varchar(128)
);

insert into contact(number, type)
values
	('234-56-78', 'домашний'),
	('987-65-43', 'рабочий'),
	('565-25-91', 'мобильный'),
	('332-55-67', null),
	('465-11-22', null);

create table employee_contact (
	employee_id INT references employee(id) on delete cascade,
	contact_id INT references contact(id) on delete cascade
);

insert into employee_contact(employee_id, contact_id)
values
	(1, 1),
	(1, 2),
	(2, 2),
	(2, 3),
	(2, 4),
	(3,5);

select company.name,
	   employee.first_name || employee.last_name fio
from employee, company
where employee.company_id = company.id

select c.name,
	   employee.first_name || ' ' || employee.last_name fio,
	   ec.contact_id,
	   c2."number" || ' ' || c2."type"
from employee
join company c on employee.company_id = c.id
join employee_contact ec on employee.id = ec.employee_id
join contact c2 on ec.employee_id = c2.id ;

select *
from employee e
cross join company c ;

select
	c.name,
	e.first_name
from company c
left join employee e
	on c.id = e.company_id ;

select c.name,
		e.first_name
from employee e
left join company c
	on e.company_id = c.id

select c.name,
		e.first_name
from employee e
right join company c
	on e.company_id = c.id
	and c."date" > '2001-01-01';

select c.name,
		e.first_name
from employee e
full join company c
	on e.company_id = c.id

select
	company."name" ,
	count(e.id)
from company
left join employee e
	on company.id = e.company_id
	and company."name" = 'Apple'
--where company."name" = 'Apple'
group by company."name"
having count(e.id) > 0;

select
	company."name" ,
	e.last_name ,
	e.salary,
--	count(e.id) over (),
--	max(e.salary) over (partition by company.name),
--	avg(e.salary) over (),
--	row_number() over(partition by company.name),
--	dense_rank () over(partition by company.name order by e.salary nulls first)
	lag (e.salary) over (order by e.salary) - e.salary
from company
left join employee e
	on company.id = e.company_id
order by company."name"


create view employee_view as
select
	company."name" ,
	e.last_name ,
	max(e.salary) over (partition by company.name),
	min(e.salary) over (partition by company.name),
	lag(e.salary) over (order by e.salary) -  e.salary
from company
left join employee e
	on company.id = e.company_id
order by company."name";

select *
from employee_view
where "name" = 'Facebook';

create materialized view m_employee_view as
select
	company."name" ,
	e.last_name ,
	max(e.salary) over (partition by company.name),
	min(e.salary) over (partition by company.name),
	lag(e.salary) over (order by e.salary) -  e.salary
from company
left join employee e
	on company.id = e.company_id
order by company."name";

select *
from m_employee_view
where max = 2000

refresh materialized view m_employee_view;

alter table if exists employee
add column gender int;

alter table if exists employee
alter column gender set not null;

alter table if exists employee
drop column gender;

update employee
set gender = 1
where id <= 5;

















