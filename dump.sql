create table employees
(
    id           int auto_increment primary key,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    gender       varchar(1) not null default 'M',
    birthday     date not null default '1970-01-01',
    salary       int default 1000
);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Иван', 'Иванов', 'M', '1972-09-30', 2000);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Лев', 'Колпаков', 'M', '1990-02-01', 100);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('София', 'Короткова', 'F', '2000-12-31', 35);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Роберт', 'Скворцов', 'M', '1956-10-24', 2367);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Анастасия', 'Данилова', 'F', '1989-06-28', 4576);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Алиса', 'Лазарева', 'F', '1958-04-03', 345);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Любовь', 'Алексеева', 'F', '1994-11-01', 567);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Маргарита', 'Соболева', 'F', '1946-03-08', 5689);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Степан', 'Платонов', 'M', '1977-07-10', 678);

insert into mnu.employees
    (name, surname, gender, birthday, salary)
values
    ('Арина', 'Киселева', 'F', '1999-08-17', 5945);
