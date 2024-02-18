INSERT INTO users (userName, password, email, role)
VALUES ('Гарри Поттер', '213', 'qwe@mail.ru', 'junior'),
('ivan', '213', 'ivan@mail.ru', 'junior');

INSERT INTO projects (name, description)
VALUES ('project 1', 'wqer'),
('project 2', 'wqer');

INSERT INTO user_project (user_id, project_id)
VALUES (1,2),
(2,2),
(2,1);




