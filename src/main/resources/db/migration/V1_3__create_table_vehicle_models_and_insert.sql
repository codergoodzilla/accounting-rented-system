CREATE TABLE vehicle_models (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE,
  category_id int NOT NULL,
  mark_id int NOT NULL,

  FOREIGN KEY (category_id) REFERENCES vehicle_categories(id) ON DELETE CASCADE,
  FOREIGN KEY (mark_id) REFERENCES vehicle_marks(id) ON DELETE CASCADE
);

INSERT INTO vehicle_models (name, category_id, mark_id)
VALUES
  ('Q2', 1, 1 ),
  ('Q3', 1, 1 ),
  ('X1', 1, 2 ),
  ('X2', 1, 2 ),
  ('Aveo', 1, 3 ),
  ('Chery', 1, 3 ),
  ('DS3', 1, 4 ),
  ('DS4', 1, 4 ),
  ('Panda', 1, 5 ),
  ('Punto', 1, 5 ),
  ('CS', 2, 2 ),
  ('DKW', 2, 2 ),
  ('SportClassic', 2, 6 ),
  ('ST', 2, 6 ),
  ('TDPB', 2, 7 ),
  ('TLR', 2, 7 ),
  ('Ultra', 2, 8 ),
  ('Teryx', 2, 8 ),
  ('TDM', 2, 9 ),
  ('TDR', 2, 9 ),
  ('RS', 3, 2 ),
  ('RT', 3, 2 ),
  ('996', 3, 6 ),
  ('916', 3, 6 ),
  ('Spacy', 3, 7 ),
  ('Spark', 3, 7 ),
  ('KDX', 3, 8 ),
  ('KE', 3, 8 ),
  ('FJR', 3, 9 ),
  ('FS80', 3, 9 );