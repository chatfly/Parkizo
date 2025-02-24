CREATE TABLE car(
    id serial PRIMARY KEY,
    license_plate char(7) not null,
    arrival_time timestamp
);