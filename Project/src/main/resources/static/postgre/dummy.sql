CREATE EXTENSION IF NOT EXISTS pgcrypto;

TRUNCATE TABLE
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
('5060337502900', 1, 3, 7, 'images/products/5060337502900.png');

INSERT INTO role (name) VALUES
('USER'),
('BRAND OWNER'),
('API ACCESS'),
('ADMIN');

INSERT INTO users (username, email_hashed, password_hash, role_id, xp) VALUES
(
'jonaslarsen_',
encode(digest('test@travlr.dk', 'sha256'), 'hex'),
crypt('password', gen_salt('bf')),
4,
250
),
(
'customer',
encode(digest('customer@email.com', 'sha256'), 'hex'),
crypt('customer', gen_salt('bf')),
1,
0
);

INSERT INTO badge_definition (code, label) VALUES
('popular', 'Populær'),
('top100', 'Top 100'),
('eco', 'Økologisk'),
('best', 'Bedst vurderet'),
('new', 'Nyhed'),
('newProduct', 'Nyt produkt'),
('top10', 'Top 10'),
('justAdded', 'Lige tilføjet'),
('newVersion', 'Ny version'),
('newTaste', 'Ny smag'),
('newPackaging', 'Ny emballage'),
('top10Category', 'Top 10 i kategori');

INSERT INTO rating_definition (subcategory_id, label, rating_type) VALUES
(7, 'Smag', 'SCALE_1_5'),
(7, 'Energi boost', 'SCALE_1_5'),
(7, 'Pris', 'SCALE_1_5');

INSERT INTO review (product_barcode, user_id, final_comment) VALUES
('5060337502900', 1, 'Super lækker energi, perfekt til træning');

INSERT INTO review_rating (review_id, rating_definition_id, value, comment) VALUES
(1, 1, 4.5, 'Smagen er klassisk Monster'),
(1, 2, 4.8, 'Giver et hurtigt energi boost'),
(1, 3, 3.5, 'En smule dyr men det er okay');

INSERT INTO product_badge (product_barcode, badge_id) VALUES
('5060337502900', 8);