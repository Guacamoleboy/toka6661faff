CREATE EXTENSION IF NOT EXISTS pgcrypto;

TRUNCATE TABLE
category,
product,
product_info,
role,
users,
food_review,
electronics_review
RESTART IDENTITY CASCADE;

INSERT INTO category (name, description) VALUES
('Food', 'All edible consumer products'),
('Electronics', 'Electronic devices and accessories');

INSERT INTO product_info (name, description) VALUES
('Pepsi Max', 'Sugar free cola with maximum taste'),
('Monster Energy Green', 'Energy drink with classic Monster flavor'),
('iPhone 14', 'Apple smartphone released in 2022'),
('Sony WH-1000XM5', 'Noise cancelling wireless headphones');

INSERT INTO product (barcode, title, product_info_id, category_id) VALUES
('5449000000996', 'Pepsi Max 500ml', 1, 1),
('5060166691234', 'Monster Energy Original 500ml', 2, 1),
('0194253401440', 'iPhone 14 128GB Black', 3, 2),
('4548736133050', 'Sony WH-1000XM5 Black', 4, 2);

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