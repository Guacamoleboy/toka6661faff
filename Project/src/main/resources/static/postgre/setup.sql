DROP TABLE IF EXISTS
category,
product,
product_info,
role,
users,
food_review,
electronics_review
CASCADE;

CREATE TABLE category (
id SERIAL PRIMARY KEY,
name TEXT UNIQUE NOT NULL,                                                              -- Food, electronic, medicin etc
description TEXT                                                                        -- UI
);

CREATE TABLE product_info (                                                             -- UI product information
id SERIAL PRIMARY KEY,
name TEXT NOT NULL,
description TEXT NOT NULL
);

CREATE TABLE product (
barcode TEXT PRIMARY KEY,                                                               -- EAN number
title TEXT NOT NULL,
product_info_id INT NOT NULL REFERENCES product_info(id),                               -- In the long run add description
category_id INT NOT NULL REFERENCES category(id),                                       -- Product Category
created_at TIMESTAMP DEFAULT now()                                                      -- Origin date of addition
);

CREATE TABLE role (
id SERIAL PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL                                                        -- Access giver
);

CREATE TABLE users (
id SERIAL PRIMARY KEY,
username_hashed TEXT UNIQUE NOT NULL,                                                   -- Hash (GDPR)
email_hashed TEXT UNIQUE NOT NULL,                                                      -- Hash (GDPR)
password_hash TEXT NOT NULL,                                                            -- Hash (GDPR)
role_id INT REFERENCES role(id),                                                        -- Access
created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE food_review (
id SERIAL PRIMARY KEY,
product_barcode TEXT REFERENCES product(barcode) ON DELETE CASCADE,                     -- Individual product
user_id INT REFERENCES users(id) ON DELETE CASCADE,
rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),                                     -- 1 -> 5
price_rating INT NOT NULL CHECK (price_rating BETWEEN 1 AND 5),                         -- 1 -> 5
flavor_rating INT NOT NULL CHECK (flavor_rating BETWEEN 1 AND 5),                       -- 1 -> 5
would_buy_again BOOLEAN NOT NULL,                                                       -- Must be added
improvements TEXT,                                                                      -- Not a must
comment TEXT NOT NULL,                                                                  -- Must be entered
review_date TIMESTAMP DEFAULT now(),
UNIQUE(user_id, product_barcode)                                                        -- Limits per customer
);

CREATE TABLE electronics_review (
id SERIAL PRIMARY KEY,
product_barcode TEXT REFERENCES product(barcode) ON DELETE CASCADE,                     -- Individual product
user_id INT REFERENCES users(id) ON DELETE CASCADE,
rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
durability_rating INT CHECK (durability_rating BETWEEN 1 AND 5),
ease_of_use_rating INT CHECK (ease_of_use_rating BETWEEN 1 AND 5),
design_rating INT CHECK (design_rating BETWEEN 1 AND 5),
would_recommend BOOLEAN NOT NULL,
improvements TEXT,
comment TEXT NOT NULL,
review_date TIMESTAMP DEFAULT now(),
UNIQUE(user_id, product_barcode)
);