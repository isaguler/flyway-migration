CREATE TABLE IF NOT EXISTS product (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(255),
    description varchar(255),
    price DECIMAL(20, 8),
    enabled BOOLEAN
);