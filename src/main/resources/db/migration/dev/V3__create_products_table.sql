CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    envoice_id UUID,
    title VARCHAR(100),
    price NUMERIC,
    description VARCHAR(100),
    quantity INT,
    created_at TIMESTAMP DEFAULT NOW(),

    CONSTRAINT fk_envoice
    FOREIGN KEY (envoice_id)
    REFERENCES envoices(id)
    ON DELETE CASCADE
);