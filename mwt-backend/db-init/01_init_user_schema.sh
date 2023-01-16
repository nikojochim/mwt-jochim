#!/bin/bash

psql -v ON_ERROR_STOP=1 --dbname "hotel" --username "postgres" <<-EOSQL
  CREATE SCHEMA bookings;
  COMMIT;

  CREATE USER bookings WITH PASSWORD '123456';

  GRANT CONNECT ON DATABASE "hotel" TO bookings;

  GRANT USAGE ON SCHEMA "bookings" TO bookings;
  GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "bookings" TO bookings;
  GRANT ALL PRIVILEGES ON SCHEMA "bookings" TO bookings;
  ALTER SCHEMA "bookings" OWNER TO bookings;
  COMMIT;
EOSQL
