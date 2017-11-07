CREATE VIEW vehicle_coordinates AS SELECT * FROM vehicle_coordinates_storage;
ALTER VIEW vehicle_coordinates ALTER COLUMN id SET DEFAULT NEXTVAL('vehicle_coordinates_storage_id_seq');

CREATE OR REPLACE FUNCTION insert_to_vehicle_coordinates()
RETURNS TRIGGER AS $BODY$
BEGIN
  EXECUTE FORMAT(
      $f$
            CREATE TABLE IF NOT EXISTS %I (
            CHECK (vehicle_model_id = %s)
            ) INHERITS (vehicle_coordinates_storage)
        $f$,
      CONCAT('vehicle_coordinates_model_', new.vehicle_model_id),
      new.vehicle_model_id
  );
  EXECUTE FORMAT(
      $f$
            INSERT INTO %I
            VALUES  (%s, %s, %s, %s, %s, %s, %L)
        $f$,
      CONCAT('vehicle_coordinates_model_', new.vehicle_model_id),
      NEW.id,
      NEW.vehicle_id,
      NEW.vehicle_model_id,
      NEW.accounting_record_id,
      NEW.lat,
      NEW.lng,
      NEW.created_at
  );
  RETURN NEW;
END; $BODY$ LANGUAGE plpgsql;

CREATE TRIGGER insert_to_vehicle_coordinates_trigger
INSTEAD OF INSERT ON vehicle_coordinates
FOR EACH ROW EXECUTE PROCEDURE insert_to_vehicle_coordinates();