DROP TABLE IF EXISTS departments;

CREATE TABLE departments
(
    id      serial PRIMARY KEY,
    name    varchar(50),
    parent  int
);

INSERT INTO departments (name, parent)
VALUES
    ('Организация 1', NULL),
    ('Департамент 1', 1),
    ('Отдел 1', 2),
    ('Отдел 2', 2),
    ('Департамент 2', 1),
    ('Отдел 3', 5),
    ('Отдел 4', 5),
    ('Отдел 5', 5)
