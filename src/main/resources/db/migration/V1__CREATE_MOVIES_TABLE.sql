CREATE SEQUENCE movies_table_id_sq;

CREATE TABLE movies(
    id INTEGER primary key default nextval('movies_table_id_sq'),
    title varchar(255),
    description varchar(255),
    release_date date,
    director_name varchar(255),
    version INTEGER
);