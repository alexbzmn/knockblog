INSERT INTO users (username, password, enabled)
VALUES ('admin', 'admin', 1);
INSERT INTO users (username, password, enabled)
VALUES ('alex', '123456', 1);

INSERT INTO user_roles (user_role_id, username, role)
VALUES (1, 'admin', 'ROLE_ADMIN');
INSERT INTO user_roles (user_role_id, username, role)
VALUES (2, 'alex', 'ROLE_USER');

INSERT INTO posts (post_id, username, content, pub_date, name)
VALUES (1, 'alex', 'Test Content', '2017-07-16 00:00:00', 'Sample Post')