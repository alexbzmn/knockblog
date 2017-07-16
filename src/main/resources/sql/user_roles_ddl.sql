CREATE TABLE user_roles (
  user_role_id INT(11)     NOT NULL,
  username     VARCHAR(45) NOT NULL,
  role         VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);