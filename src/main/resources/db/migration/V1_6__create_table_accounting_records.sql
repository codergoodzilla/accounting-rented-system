CREATE TABLE accounting_records_storage (
  id serial PRIMARY KEY,
  renter_id int NOT NULL,
  rented_vehicle_id int NOT NULL,
  rental_start_at timestamptz NOT NULL,
  rental_end_at timestamptz,
  rental_hours_count int NOT NULL DEFAULT 0,
  rental_coordinates_count int NOT NULL DEFAULT 0,

  FOREIGN KEY (renter_id) REFERENCES renters(id) ON DELETE CASCADE,
  FOREIGN KEY (rented_vehicle_id) REFERENCES vehicles(id) ON DELETE CASCADE
);