create table cities(
    name varchar(255),
    country_id bigint references countries(id)
)