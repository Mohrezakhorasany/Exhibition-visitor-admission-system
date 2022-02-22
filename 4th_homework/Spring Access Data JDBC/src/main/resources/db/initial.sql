create schema if not exists factory;


create table if not exists factory.car
(
    registration_id serial primary key not null,
    car_brand varchar(255) not null,
    car_model varchar(255) not null unique,
    fuel_type varchar(255) not null,
    manufacturing_date date not null,
    car_color varchar(255) not null
);

TRUNCATE TABLE factory.car RESTART IDENTITY;
