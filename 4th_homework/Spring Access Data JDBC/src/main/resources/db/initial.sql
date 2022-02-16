CREATE SCHEMA IF NOT EXISTS factory;

CREATE TABLE IF NOT EXISTS factory.car
(
    registration_id SERIAL PRIMARY KEY,
    car_brand VARCHAR(255) NOT NULL,
    car_model VARCHAR(255) NOT NULL,
    fuel_type VARCHAR(255) NOT NULL,
    manufacturing_date DATE NOT NULL,
    car_color VARCHAR(255) NOT NULL
);

truncate table factory.car RESTART IDENTITY CASCADE;