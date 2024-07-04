USE w13_imports;

CREATE USER 'user_admin'@'localhost';
CREATE USER 'user_vendedor'@'localhost';
CREATE USER 'user_gerente'@'localhost';

CREATE ROLE 'admin', 'vendedor', 'gerente';

GRANT ALL PRIVILEGES ON w13_imports TO 'admin';
FLUSH PRIVILEGES;
GRANT SELECT, INSERT, UPDATE ON venda TO vendedor;
GRANT SELECT, INSERT, UPDATE ON produto TO vendedor;
GRANT SELECT, INSERT, UPDATE ON cliente TO vendedor;
FLUSH PRIVILEGES;
GRANT ALL PRIVILEGES ON w13_imports TO 'gerente';
FLUSH PRIVILEGES;

GRANT 'admin' TO 'user_admin'@'localhost';
GRANT 'vendedor' TO 'user_vendedor'@'localhost';
GRANT 'gerente' TO 'user_gerente'@'localhost';