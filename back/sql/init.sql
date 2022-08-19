DROP TABLE IF EXISTS departments;

CREATE TABLE departments
(
    id      serial PRIMARY KEY,
    name    varchar(50),
    parent  int
);
