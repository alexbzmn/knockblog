INSERT INTO users (username, password, enabled)
VALUES ('mkyong', '123456', 1);
INSERT INTO users (username, password, enabled)
VALUES ('alex', '123456', 1);

INSERT INTO user_roles (user_role_id, username, role)
VALUES (1, 'mkyong', 'ROLE_USER');
INSERT INTO user_roles (user_role_id, username, role)
VALUES (2, 'mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (user_role_id, username, role)
VALUES (3, 'alex', 'ROLE_USER');