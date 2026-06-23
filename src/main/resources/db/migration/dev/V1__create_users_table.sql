CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    code CHAR(6) UNIQUE,
    status CHAR(1) CHECK(status IN ('A','I')) DEFAULT 'A',
    created_at TIMESTAMP DEFAULT NOW(),
    expires_at TIMESTAMP DEFAULT (NOW() + INTERVAL '24 hours')
);