CREATE INDEX idx_composition_product_code
    ON composition (product_code);

CREATE INDEX idx_composition_raw_material_code
    ON composition (raw_material_code);