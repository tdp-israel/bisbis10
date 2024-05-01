CREATE TABLE IF NOT EXISTS restaurant (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    is_kosher boolean,
    name character varying(60)
);

CREATE TABLE IF NOT EXISTS dish (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(300),
    name VARCHAR(60),
    price real,
    restaurant_id INT
);

CREATE TABLE IF NOT EXISTS restaurant_order (
    id uuid NOT NULL PRIMARY KEY,
    restaurant_id INT
);

CREATE TABLE IF NOT EXISTS order_item (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    amount INT,
    dish_id INT,
    order_id uuid
);

CREATE TABLE IF NOT EXISTS restaurant_cuisines (
    restaurant_id INT NOT NULL,
    cuisines VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS restaurant_rating (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rating REAL,
    restaurant_id INT
);