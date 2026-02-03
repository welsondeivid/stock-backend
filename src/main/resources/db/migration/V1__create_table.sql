CREATE TABLE product (
    code VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE raw_material (
    code VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    amount INT NOT NULL
);

CREATE TABLE product_raw_material (
    product_code VARCHAR(20) NOT NULL,
    raw_material_code VARCHAR(20) NOT NULL,
    required INT NOT NULL,

    PRIMARY KEY (product_code, raw_material_code),
    FOREIGN KEY (product_code) REFERENCES product(code),
    FOREIGN KEY (raw_material_code) REFERENCES raw_material(code)
);