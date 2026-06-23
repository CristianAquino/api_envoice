DO $$
DECLARE
    record_var RECORD;
BEGIN
    FOR record_var IN SELECT * FROM envoices LOOP
        INSERT INTO products(envoice_id,title,price,description,quantity,created_at)
        VALUES (
            record_var.id,
            record_var.precio,

            NOW()
        );
    END LOOP;
END $$;



INSERT INTO products(envoice_id,title,price,description,quantity,created_at)
VALUES
(1,0.18,100,118,'123456',NOW()),
(2,0.18,200,236,'654321',NOW()),
(3,0.18,300,354,'246824');
