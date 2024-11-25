CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price VARCHAR(255),
    current_stock INT
);

CREATE TABLE orders (
    id INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (id, product_id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);


INSERT INTO products (name, description, price, current_stock) VALUES
('Laptop', 'High-performance laptop with 16GB RAM and 512GB SSD', '1000', 10),
('Smartphone', 'Latest model with 6.5-inch display and 128GB storage', '500', 20),
('Wireless Mouse', 'Ergonomic wireless mouse with USB receiver', '30', 50),
('Keyboard', 'Mechanical keyboard with RGB lighting', '80', 15),
('Monitor', '27-inch 4K monitor with HDMI and DisplayPort', '300', 8),
('Headphones', 'Noise-cancelling headphones with Bluetooth', '120', 25),
('External Hard Drive', '1TB portable external hard drive', '60', 12),
('Smartwatch', 'Fitness tracking smartwatch with heart rate monitor', '150', 30),
('Webcam', 'HD webcam with autofocus and microphone', '40', 10),
('USB-C Charger', 'Fast-charging USB-C charger for various devices', '25', 40);
