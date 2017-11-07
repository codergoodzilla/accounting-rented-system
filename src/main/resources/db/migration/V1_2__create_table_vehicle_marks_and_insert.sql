CREATE TABLE vehicle_marks (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO vehicle_marks (name)
VALUES
  ('Audi'),
  ('BMW'),
  ('Chevrolet'),
  ('Citroen'),
  ('Fiat'),
  ('Ducati'),
  ('Honda'),
  ('Kawasaki'),
  ('Yamaha');