drop database book_repository;

create table author(
	id serial primary key,
	first_name varchar(128) not null,
	last_name varchar(128) not null
);

create table book(
	id BIGSERIAL primary key,
    name varchar(128) not null,
	year smallint not null,
	pagrs smallint not null,
	author_id int references author(id) on delete cascade
);

insert into author (first_name, last_name)
values
	('Кей', 'Хорстман'),
	('Стивен', 'Кови'),
	('Тони', 'Роббинс'),
	('Наполеон', 'Хилл'),
	('Роберт', 'Кийосаки'),
	('Дейл', 'Карнеги');

select * from author a ;

insert into book(name, year, pagrs, author_id)
values
	('Java. Библиотека профессионала. Том 1', 2010, 1102, (select id from author where last_name = 'Хорстман')),
	('Java. Библиотека профессионала. Том 2', 2012, 954, (select id from author where last_name = 'Хорстман')),
	('Java SE 8. Вводный курс', 2015, 203, (select id from author where last_name = 'Хорстман')),
	('7 навыков высоэффективный людей', 1989, 396, (select id from author where last_name = 'Кови')),
	('Разбуди в себя испольна', 1991, 576, (select id from author where last_name = 'Роббинс')),
	('Думай и  богатей', 1937, 336, (select id from author where last_name = 'Хилл')),
	('Богатый папа, бедный папа', 1997, 352, (select id from author where last_name = 'Кийосаки')),
	('Квадрант денежного потока', 1998, 368, (select id from author where last_name = 'Кийосаки')),
	('Как перестать беспокоиться и начать жить', 1948, 368, (select id from author where last_name = 'Карнеги')),
	('Как завоёвывать друзей и оказывать влияние на людей', 1936, 352, (select id from author where last_name = 'Карнеги'));


select
	b.name,
	b.year,
	(select a.first_name from author a where a.id = b.author_id)
from book b
order by b.year desc;


select
	count(*)
from book
where author_id IN (select id from author where first_name = 'Кей');

select *
from book
where pagrs > (select avg(pagrs)
			   from book);

select sum(t.pagrs)
from (select pagrs
		from book
		order by year
		limit 5) t;

update book
set pagrs = pagrs + 5
where  id = 2
returning name, year, pagrs;

delete from book
where author_id = (select author_id
				   from book
                   where pagrs = (select max(pagrs)
				                  from book));

delete from author
where id = (select author_id
			from book
			where pagrs = (select max(pagrs)
						   from book))
returning *;


















