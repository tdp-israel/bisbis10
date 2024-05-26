
CREATE TABLE IF NOT EXISTS restaurant (
                                          id SERIAL PRIMARY KEY,
                                          name VARCHAR(100) NOT NULL,
    average_rating DOUBLE PRECISION,
    is_kosher BOOLEAN,
    cuisines TEXT[]
    );

CREATE TABLE IF NOT EXISTS dish (
                                    id SERIAL PRIMARY KEY,
                                    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DOUBLE PRECISION,
    restaurant_id BIGINT NOT NULL,
    CONSTRAINT fk_restaurant
    FOREIGN KEY(restaurant_id)
    REFERENCES restaurant(id)
    ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS rating (
                                      id SERIAL PRIMARY KEY,
                                      restaurant_id BIGINT NOT NULL,
                                      rating DOUBLE PRECISION NOT NULL,
                                      CONSTRAINT fk_restaurant_rating
                                      FOREIGN KEY(restaurant_id)
    REFERENCES restaurant(id)
    ON DELETE CASCADE
    );
