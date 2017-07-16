CREATE TABLE IF NOT EXISTS posts (
  post_id  INT(11)     NOT NULL,
  username VARCHAR(45) NOT NULL,
  content  BLOB        NOT NULL,
  pub_date TEXT        NOT NULL,
  name     TEXT        NOT NULL,

  CONSTRAINT fk_author_id FOREIGN KEY (username) REFERENCES users (username),
  PRIMARY KEY (post_id)
);

