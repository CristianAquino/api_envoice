INSERT INTO users(code,status,created_at,expires_at)
VALUES
('123456','A',NOW(),NOW() + INTERVAL '24 hours'),
('654321','I',NOW(),NOW() + INTERVAL '24 hours'),
('246824','A',NOW(),NOW() + INTERVAL '24 hours');