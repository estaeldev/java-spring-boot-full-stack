INSERT INTO users(id, birth_date, name)
VALUES (10001, CURRENT_DATE(), 'Estael');

INSERT INTO users(id, birth_date, name)
VALUES (10002, CURRENT_DATE(), 'Ravi');

INSERT INTO users(id, birth_date, name)
VALUES (10003, CURRENT_DATE(), 'Luh');

INSERT INTO posts(id, description, user_id)
VALUES (20001, 'I want to learn AWS', 10001);

INSERT INTO posts(id, description, user_id)
VALUES (20002, 'I want to learn DevOps', 10001);

INSERT INTO posts(id, description, user_id)
VALUES (20003, 'I want to learn AWS Certified', 10002);

INSERT INTO posts(id, description, user_id)
VALUES (20004, 'I want to learn Mult Cloud', 10002);
