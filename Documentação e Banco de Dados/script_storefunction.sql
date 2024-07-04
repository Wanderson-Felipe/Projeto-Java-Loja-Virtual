DELIMITER // 

CREATE FUNCTION total_vendas_vendedor (vendedor_id INT)
RETURNS INT DETERMINISTIC

BEGIN

DECLARE total_compras INT;
DECLARE total_vendas_vendedor VARCHAR (20);

SELECT COUNT(*) INTO total_compras
FROM venda v
WHERE v.vendedor_id = vendedor_id;
RETURN total_compras;
END//

DELIMITER ;

CREATE INDEX idx_vendedor_venda ON Vendedor_Venda (Vendedor_id, Venda_id);

SELECT total_vendas_vendedor (1);

