CREATE TABLE users (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  enabled  BOOLEAN     NOT NULL DEFAULT TRUE,
  PRIMARY KEY (username)
);

