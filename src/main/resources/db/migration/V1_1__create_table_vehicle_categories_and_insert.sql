	CREATE TABLE vehicle_categories (
		id SERIAL PRIMARY KEY,
		name VARCHAR(255) NOT NULL UNIQUE
	);

	INSERT INTO vehicle_categories (name)
	VALUES
		('Auto'),
		('Moto'),
		('Scooter');