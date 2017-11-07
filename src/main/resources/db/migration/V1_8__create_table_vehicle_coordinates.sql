CREATE TABLE vehicle_coordinates_storage (
  id SERIAL PRIMARY KEY,
  vehicle_id int NOT NULL,
  vehicle_model_id int NOT NULL,
  accounting_record_id int NOT NULL,
  lat DOUBLE PRECISION NOT NULL CHECK(lat > -90 and lat <= 90),
  lng DOUBLE PRECISION NOT NULL CHECK(lng > -180 and lng <= 180),
  created_at timestamptz NOT NULL,

  FOREIGN KEY (vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE ,
  FOREIGN KEY (vehicle_model_id) REFERENCES vehicle_models(id) ON DELETE CASCADE,
  FOREIGN KEY (accounting_record_id) REFERENCES accounting_records_storage(id) ON DELETE CASCADE
);