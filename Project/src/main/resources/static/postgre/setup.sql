DROP TABLE IF EXISTS
product_badge,
badge_definition,
review_rating,
rating_definition,
review,
users,
role,
product,
product_info,
subcategory,
category
CASCADE;

CREATE TABLE category (
id SERIAL PRIMARY KEY,
name TEXT UNIQUE NOT NULL,                                                              -- Food, electronic, medicin etc
description TEXT                                                                        -- UI
);

CREATE TABLE subcategory (                                                              -- Ex. Elektronik / Lyd
id SERIAL PRIMARY KEY,
category_id INT NOT NULL REFERENCES category(id) ON DELETE CASCADE,                     -- Follows category id (main)
name TEXT NOT NULL,
description TEXT,
UNIQUE(category_id, name)
);

CREATE TABLE product_info (
id SERIAL PRIMARY KEY,
name TEXT NOT NULL,
description TEXT NOT NULL
);

CREATE TABLE product (
barcode TEXT PRIMARY KEY,                                                               -- EAN number
product_info_id INT NOT NULL REFERENCES product_info(id),
category_id INT NOT NULL REFERENCES category(id),
subcategory_id INT NOT NULL REFERENCES subcategory(id),
image_path TEXT NOT NULL UNIQUE,
created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE role (
id SERIAL PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL                                                        -- Access giver
);

CREATE TABLE users (
id SERIAL PRIMARY KEY,
username TEXT UNIQUE NOT NULL,                                                          -- Normal
email_hashed TEXT UNIQUE NOT NULL,                                                      -- Hash (GDPR)
password_hash TEXT NOT NULL,                                                            -- Hash (GDPR)
role_id INT REFERENCES role(id),                                                        -- Access
created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE review (
id SERIAL PRIMARY KEY,
product_barcode TEXT NOT NULL REFERENCES product(barcode) ON DELETE CASCADE,            -- On Product
user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,                            -- User ID
final_comment TEXT NOT NULL,                                                            -- Display comment
created_at TIMESTAMP DEFAULT now(),
UNIQUE (user_id, product_barcode)
);

CREATE TABLE rating_definition (
id SERIAL PRIMARY KEY,
subcategory_id INT NOT NULL REFERENCES subcategory(id) ON DELETE CASCADE,               -- Snacks, Høretelefoner mm
label TEXT NOT NULL,                                                                    -- Pris, komfortabilitet osv
rating_type TEXT NOT NULL CHECK (rating_type = 'SCALE_1_5'),                            -- 1.0 -> 5.0
UNIQUE (subcategory_id, label)
);

CREATE TABLE review_rating (
id SERIAL PRIMARY KEY,
review_id INT NOT NULL REFERENCES review(id) ON DELETE CASCADE,                         -- Review for product by user
rating_definition_id INT NOT NULL REFERENCES rating_definition(id) ON DELETE CASCADE,   -- Type of review (Snacks, Elektronik mm)
value DOUBLE PRECISION NOT NULL CHECK (value BETWEEN 1.0 AND 5.0),                      -- 1.0 -> 5.0
comment TEXT,                                                                           -- Free comment
UNIQUE (review_id, rating_definition_id)
);

CREATE TABLE badge_definition (
id SERIAL PRIMARY KEY,
code TEXT NOT NULL UNIQUE,                                                              -- div display value
label TEXT NOT NULL                                                                     -- Badge label (text)
);

CREATE TABLE product_badge (
id SERIAL PRIMARY KEY,
product_barcode TEXT NOT NULL REFERENCES product(barcode) ON DELETE CASCADE,            -- Product
badge_id INT NOT NULL REFERENCES badge_definition(id) ON DELETE CASCADE,                -- Badge
UNIQUE(product_barcode, badge_id)
);