create database flight_repository;

create table airport (
	code char(3) primary key,
	country varchar(256) not null,
	city varchar(128) not null
);

create table aircraft (
	id serial primary key,
	model varchar(128) not null
);

create table seat (
	aircraft_id int references aircraft(id),
	seat_no varchar(4) not null,
	primary key (aircraft_id, seat_no)
);

create table flight (
	id bigserial primary key,
	flight_no varchar(16) not null,
	departure_date timestamp not null,
	departure_airport_code char(3) references airport(code) not null,
	arrival_date timestamp not null,
	arrival_airport_code char(3) references airport(code) not null,
	aircraft_id int references aircraft(id),
	status varchar(32) not null
);

create table ticket (
	id bigserial primary key,
	passenger_no varchar(32) not null,
	passenger_name varchar(128) not null,
	flight_id bigint references flight(id) not null,
	seat_no varchar(4) not null,
	cost numeric (8,2)
);

create index flight_id_seat_no_idx on ticket(flight_id, seat_no);

insert into airport (code, country, city)
values
	('MNK', 'Беларусь', 'Минск'),
	('LDN', 'Англия', 'Лондон'),
	('MSK', 'Россия', 'Москва'),
	('BSL', 'Испания', 'Барселона');

insert into aircraft (model)
values
	('Боинг 777-300'),
	('Боинг 737-300'),
	('Аэробус А320-200'),
	('Суперджет-100');

insert into seat(aircraft_id, seat_no)
select id, s.column1
from aircraft
	cross join (values ('A1'), ('A2'), ('B1'), ('B2'), ('C1'), ('C2'), ('D1'), ('D2') order by 1) s;

insert into flight(flight_no, departure_date, departure_airport_code, arrival_date, arrival_airport_code, aircraft_id, status)
values
	('MN3002', '2020-06-14T14:30', 'MNK', '2020-06-14T18:07', 'LDN', 1, 'ARRIVED'),
	('MN3002', '2020-06-16T09:15', 'LDN', '2020-06-16T13:00', 'MNK', 1, 'ARRIVED'),
	('BC2801', '2020-07-28T23:25', 'MNK', '2020-07-29T02:43', 'LDN', 2, 'ARRIVED'),
	('BC2801', '2020-08-01T11:00', 'LDN', '2020-08-01T14:15', 'MNK', 2, 'DEPARTED'),
	('TR3103', '2020-05-03T13:10', 'MSK', '2020-05-03T18:38', 'BSL', 3, 'ARRIVED'),
	('TR3103', '2020-05-10T07:15', 'BSL', '2020-05-10T12:44', 'MSK', 3, 'CANCELLED'),
	('CV9827', '2020-09-09T18:00', 'MNK', '2020-09-09T19:15', 'MNK', 4, 'SCHEDULED'),
	('CV9827', '2020-09-09T18:00', 'MNK', '2020-09-09T19:15', 'MNK', 4, 'SCHEDULED'),
	('QS8712', '2020-12-18T03:35', 'MNK', '2020-12-18T06:46', 'LDN', 2, 'ARRIVED');

insert into ticket (passenger_no, passenger_name, flight_id, seat_no, cost)
values
	('112233', 'Иван Иванов', 1, 'A1', 200),
	('23234A', 'Пётр Петров', 1, 'B1', 180),
	('SS988D', 'Светлана Светикова', 1, 'B2', 175),
	('OYASDE', 'Андрей Андреев', 1, 'C2', 175),
	('POQ234', 'Иван Кожемякин', 1, 'D1', 160),
	('898123', 'Олег Рубцов', 1, 'A2', 198),
	('555321', 'Екатерина Петренко', 2, 'A1', 250),
	('QO2300', 'Иван Розмаринов', 2, 'B2', 225),
	('9883IO', 'Иван Кожемякин', 2, 'C1', 217),
	('123UI2', 'Андрей Буйнов', 2, 'C2', 227),
	('SS988D', 'Светлана Светикова', 2, 'D2', 277),
	('EE2344', 'Дмитрий Трусцов', 3, 'A1', 300),
	('AS23PP', 'Максим Комсомольцев', 3, 'A2', 285),
	('322349', 'Эдуард Щеглов', 3, 'B1', 99),
	('DL123S', 'Игорь Беркутов', 3, 'B2', 199),
	('MVM111', 'Алексей Щербин', 3, 'C1', 299),
	('ZZZ111', 'Денис Колобков', 3, 'C2', 230),
	('112233', 'Иван Иванов', 6, 'B1', 135),
	('309623', 'Татьяна Крот', 6, 'C1', 155),
	('319623', 'Юрий Дувинков', 6, 'D1', 125),
	('322349', 'Эдуард Щеглов', 7, 'A1', 69),
	('DIOPSL', 'Евгений Безфамильная', 7, 'A2', 58),
	('DIOPS1', 'Константин Швец', 7, 'D1', 65),
	('DIOPS2', 'Юлия Швец', 7, 'D2', 65),
	('1IOPS2', 'Ник Говриленко', 7, 'C2', 73),
	('999666', 'Анастасия Шепелёва', 7, 'B1', 66),
	('23234A', 'Пётр Петров', 7, 'C1', 80),
	('OYASDE', 'Андрей Андреев', 8, 'A2', 100),
	('1QAZD2', 'Лариса Потёмкнина', 8, 'A2', 89),
	('1OAZD2', 'Карл Хмелёв', 8, 'B2', 79),
	('2QAZD2', 'Жанна Хмелёва', 8, 'C2', 77),
	('DBXND1', 'Светлана Хмурая', 8, 'B', 94),
	('DBXND2', 'Светлана Светикова', 9, 'A2', 222),
	('SS988D', 'Андрей Жёлудь', 9, 'A1', 198),
	('SS968D', 'Дмитрий Воснецов', 9, 'B1', 243),
	('SS958D', 'Максим Гребцов', 9, 'C1', 251),
	('112233', 'Иван Иванов', 9, 'C2', 135),
	('MNMDV2', 'Лариса Тельникова', 9, 'B2', 217),
	('23234A', 'Пётр Петров', 9, 'D1', 189),
	('123951', 'Полина Зверева', 9, 'D2', 234);


select *
from ticket
join flight f
	on ticket.flight_id = f.id
where seat_no = 'B1'
	and f.departure_airport_code = 'MNK'
	and f.arrival_airport_code = 'LDN'
	and f.departure_date::date = (now() - interval '2 days')::date;

select t2.count - t1.count
from (
select
	f.aircraft_id ,
	count(*)
from ticket t
join flight f
	on f.id = t.flight_id
where f.flight_no = 'MN3002'
	and f.departure_date::date = '2020-06-14'
group by f.aircraft_id
) t1
join (
select
	aircraft_id ,
	count(*)
from seat s
where aircraft_id = 1
group by aircraft_id ) t2
on t1.aircraft_id = t2.aircraft_id;

select exists (select from ticket where id = 1)

select
	s.seat_no
from seat s
where aircraft_id = 1
	and not exists (
select
	t.seat_no
from ticket t
join flight f
	on f.id = t.flight_id
where f.flight_no = 'MN3002'
	and f.departure_date::date = '2020-06-14'
	and s.seat_no = t.seat_no);

select *
from flight f
order by (f.arrival_date - f.departure_date) desc
limit 2;

select
	f.id ,
	first_value (f.arrival_date - f.departure_date) over (order by (f.arrival_date - f.departure_date) desc) max_valie,
	first_value (f.arrival_date - f.departure_date) over (order by (f.arrival_date - f.departure_date)) min_valie,
	count(*) over()
from flight f
join airport a
	on a.code = f.arrival_airport_code
join airport d
	on d.code  = f.departure_airport_code
where a.code = 'Лондон'
	and d.city = 'Минск'
limit 1;

select
	t.passenger_name ,
	count(*),
	round(100.0 * count(*) / (select count(*) from ticket), 2)
from ticket t
group by t.passenger_name
order by count(*) desc;

select
	t1.*,
	first_value (t1.count) over () -t1.count
from (select
	t.passenger_no ,
	t.passenger_name ,
	count(*)
from ticket t
group by t.passenger_no, t.passenger_name
order by 3 desc
) t1

select t1.*,
	coalesce(lead(sum_cost) over (order by t1.sum_cost), t1.sum_cost) - t1.sum_cost
from (select
	t.flight_id ,
	sum(t.cost) sum_cost
from ticket t
group by t.flight_id
order by 2 desc) t1


values (1, '2'), (3, '4'), (5, '6'), (7, '8')
except
values (1, '2'), (2, '4'), (5, '6'), (7, '9')

select
	aircraft_id ,
	s.seat_no
from seat s
where aircraft_id = 1
except
select
	f.aircraft_id ,
	t.seat_no
from ticket t
join flight f
	on f.id = t.flight_id
where f.flight_no = 'MN3002'
	and f.departure_date::date = '2020-06-14'

SELECT
	id
FROM ticket
where id = 5;

select *
from ticket
where seat_no = 'B1'
	and flight_id = 5;

select count(distinct flight_id)
from ticket;

select count(*) from ticket;
























