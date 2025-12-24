CREATE EXTENSION IF NOT EXISTS pgcrypto;

TRUNCATE TABLE
category,
subcategory,
product,
product_info,
role,
users,
food_review,
electronics_review
RESTART IDENTITY CASCADE;

INSERT INTO category (name, description) VALUES
('Mad', 'All edible consumer products'),
('Elektronik', 'Electronic devices and accessories'),
('Drikkevarer', 'Alt væske som kan indtages');

INSERT INTO subcategory (category_id, name, description) VALUES
(2, 'Headphones', 'Wireless and wired headphones'),
(2, 'Laptops', 'Portable computers'),
(2, 'Smartphones', 'Mobile devices'),
(1, 'Frugt', 'Fresh fruits'),
(1, 'Grøntsager', 'Fresh vegetables'),
(1, 'Snacks', 'Chips, candies, and other snacks'),
(3, 'Energidrik', 'Boom! Release the beast.'),
(3, 'Læskedrik', 'Cola, pepsi, Faxe - you name it');

INSERT INTO product_info (name, description) VALUES
('Monster Energy Green', 'Energy drink with classic Monster flavor');

INSERT INTO product (barcode, product_info_id, category_id, subcategory_id, image_path) VALUES
('5060337502900', 1, 3, 7, '/images/products/5060337502900.png');

INSERT INTO role (name) VALUES
('USER'),
('BRAND OWNER'),
('API ACCESS'),
('ADMIN');

INSERT INTO users (username_hashed, email_hashed, password_hash, role_id) VALUES
(
encode(digest('user1', 'sha256'), 'hex'),
encode(digest('user1@email.com', 'sha256'), 'hex'),
crypt('password123', gen_salt('bf')),
1
),
(
encode(digest('user2', 'sha256'), 'hex'),
encode(digest('user2@email.com', 'sha256'), 'hex'),
crypt('password456', gen_salt('bf')),
1
);

INSERT INTO food_review (product_barcode,user_id,rating,price_rating,flavor_rating,would_buy_again,improvements,comment) VALUES
(
'5449000000996',
1,
5,
4,
5,
true,
'Could be slightly less carbonated',
'Best sugar free cola on the market'
),
(
'5060166691234',
2,
4,
3,
4,
true,
NULL,
'Great energy boost, but a bit expensive'
);

INSERT INTO electronics_review (product_barcode,user_id,rating,durability_rating,ease_of_use_rating,design_rating,would_recommend,improvements,comment) VALUES
(
'0194253401440',
1,
5,
5,
5,
5,
true,
NULL,
'Extremely smooth performance and great camera'
),
(
'4548736133050',
2,
4,
4,
5,
5,
true,
'Could improve microphone quality',
'Excellent noise cancellation and comfort'
);