INSERT INTO envoices(user_id,iva,sub_total,total,code_envoice,created_at,expires_at)
VALUES
(1,0.18,100,118,'123456',NOW(),NOW() + INTERVAL '24 hours'),
(2,0.18,200,236,'654321',NOW(),NOW() + INTERVAL '24 hours'),
(3,0.18,300,354,'246824',NOW(),NOW() + INTERVAL '24 hours');