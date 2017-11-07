CREATE TABLE vehicles (
  id serial PRIMARY KEY,
  license_plate VARCHAR(25) NOT NULL UNIQUE,
  model_id int NOT NULL,

  FOREIGN KEY (model_id) REFERENCES vehicle_models(id)
);

INSERT INTO vehicles(model_id, license_plate)
VALUES
  (1, 'a000aa01'),
  (2, 'a000aa02');