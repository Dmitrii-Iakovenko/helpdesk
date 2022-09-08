DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;


CREATE TABLE departments
(
    id     bigserial PRIMARY KEY,
    name   varchar(50),
    parent bigint
);

CREATE TABLE employees
(
    id            bigserial PRIMARY KEY,
    first_name    varchar(20),
    middle_name   varchar(20),
    last_name     varchar(30),
    department    bigint,
    job_position  varchar(40),
    work_location varchar(40),
    email         varchar(40),
    city_phone    varchar(40),
    mobile_phone  varchar(40),
    local_phone   varchar(10)
);

CREATE TABLE tickets
(
    id          bigserial PRIMARY KEY,
    created     timestamp,
    employee_id bigint,
    category    varchar(50),
    problem     text,
    solution    text,
    engineer_id bigint,
    status      varchar(15)
);



INSERT INTO departments (name, parent)
VALUES
    ('АО "Весёлый молочник"', NULL),
        ('Департамент производства продукции', 1),
            ('Отдел по ухаживанию за коровами', 2),
            ('Отдел по разливу молока', 2),
        ('Департамент рекламы и маркетинга', 1),
            ('Отдел рекламы', 5),
            ('Отдел маркетинга', 5),
            ('Договорной отдел', 5),

    ('ФГБУ "Пельмешки без спешки"', NULL),
       ('Отдел пельмешки', 9),
       ('Отдел без спешки', 9);


INSERT INTO employees(first_name, middle_name, last_name, department, job_position, work_location, email, city_phone, mobile_phone, local_phone)
VALUES
    ('Иван', 'Иванович', 'Иванов',      1, 'Генеральный директор',      '999 кабинет', 'director@happy-milkman.com',    '+7 (495) 999-99-99', '+7 (909) 999-99-99', '9999'),
    ('Пётр', 'Петрович', 'Петров',      2, 'Директор департамента',     '888 кабинет', 'prodact@happy-milkman.com',     '+7 (495) 888-88-88', '+7 (909) 888-88-88', '8888'),
    ('Олег', 'Олегович', 'Олегов',      3, 'Начальник отдела',          '777 кабинет', 'support@happy-milkman.com',     '+7 (495) 777-77-77', '+7 (909) 777-77-77', '7777'),
    ('Елена', 'Еленовна', 'Еленова',    3, 'Зам. начальника отдела',    '777 кабинет', 'elena@happy-milkman.com',       '+7 (495) 777-77-77', '+7 (909) 123-12-23', '7776'),
    ('Ольга', 'Ольговна', 'Ольгова',    3, 'Ведущий технолог',          '787 кабинет', 'olga@happy-milkman.com',        '+7 (495) 666-66-66', '+7 (909) 666-66-66', '6666'),
    ('Сергей', 'Сергеевич', 'Сергеев',  3, 'Инженер',                   '787 кабинет', 'sergey@happy-milkman.com',      '+7 (495) 666-66-66', '+7 (909) 555-55-55', '6655')


INSERT INTO tickets(created, employee_id, category, problem, solution, engineer_id, status)
VALUES
    ('2022.09.07 10:30', 1, 'Не работает Discord', 'Срочно почините!', 'Не был выбран нужный сервер', 6, 'Created'),
    ('2022.09.07 10:30', 2, 'Обновите Excel',      'Нужна новая версия', 'Обновили версию экселя',    5, 'Appointed'),
    ('2022.09.07 10:30', 3, 'Не работает Discord', 'Срочно почините!', 'Не был выбран нужный сервер', 4, 'Working'),
    ('2022.09.07 10:30', 4, 'Не работает Discord', 'Срочно почините!', 'Не был выбран нужный сервер', 3, 'Completed'),
    ('2022.09.07 10:30', 5, 'Не работает Discord', 'Срочно почините!', 'Не был выбран нужный сервер', 2, 'Archived')
