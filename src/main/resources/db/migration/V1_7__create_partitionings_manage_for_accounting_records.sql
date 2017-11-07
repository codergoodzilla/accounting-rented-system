CREATE VIEW accounting_records AS SELECT * FROM accounting_records_storage;
ALTER VIEW accounting_records ALTER COLUMN id SET DEFAULT NEXTVAL('accounting_records_storage_id_seq');

CREATE OR REPLACE FUNCTION insert_to_accounting_records()
RETURNS TRIGGER AS $BODY$
BEGIN
  EXECUTE FORMAT(
      $f$
            CREATE TABLE IF NOT EXISTS %I (
            CHECK (rental_start_at >= %L AND rental_start_at < %L)
            ) INHERITS (accounting_records_storage)
        $f$,
      CONCAT('accounting_records_storage_', TO_CHAR(new.rental_start_at, 'YYYYMMDD')),
      CONCAT(TO_CHAR(new.rental_start_at, 'YYYY-MM-DD '), '00:00:00'),
      CONCAT(TO_CHAR(new.rental_start_at + interval '1' day, 'YYYY-MM-DD '), '00:00:00')
  );
  EXECUTE FORMAT(
      $f$
            INSERT INTO %I
            VALUES  (%s, %s, %s, %L, %L, %s, %s)
        $f$,
      concat('accounting_records_storage_', TO_CHAR(new.rental_start_at, 'YYYYMMDD')),
      NEW.id,
      NEW.renter_id,
      NEW.rented_vehicle_id,
      NEW.rental_start_at,
      NEW.rental_end_at,
      NEW.rental_hours_count,
      NEW.rental_coordinates_count
  );
  RETURN NEW;
END; $BODY$ LANGUAGE plpgsql;

CREATE TRIGGER insert_to_accounting_records_trigger
INSTEAD OF INSERT ON accounting_records
FOR EACH ROW EXECUTE PROCEDURE insert_to_accounting_records();
