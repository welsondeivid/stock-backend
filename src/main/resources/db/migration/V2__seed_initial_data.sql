INSERT INTO product (code, name, price) VALUES
    ('PRD-000001', 'Keyboard', 250.00),
    ('PRD-000002', 'Mouse', 120.00);

INSERT INTO raw_material (code, name, amount) VALUES
    ('RAW-000001', 'Plastic', 100),
    ('RAW-000002', 'Circuit Board', 50);

INSERT INTO product_raw_material (product_code, raw_material_code, required) VALUES
    ('PRD-000001', 'RAW-000001', 2),
    ('PRD-000001', 'RAW-000002', 1),
    ('PRD-000002', 'RAW-000001', 1);