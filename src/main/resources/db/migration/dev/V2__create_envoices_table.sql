CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE envoices (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id INT,
    iva NUMERIC,
    sub_total NUMERIC,
    total NUMERIC,
    code_envoice VARCHAR(24),
    created_at TIMESTAMP DEFAULT NOW(),
    expires_at TIMESTAMP DEFAULT (NOW() + INTERVAL '24 hours'),

    CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);