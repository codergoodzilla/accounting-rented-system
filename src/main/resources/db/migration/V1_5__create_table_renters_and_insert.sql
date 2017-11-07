CREATE TABLE renters (
  id serial PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO renters(full_name)
VALUES ('user0');