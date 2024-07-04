CREATE VIEW vendas_do_vendedor AS SELECT v.id AS venda_id, v.valor_venda, v.data_venda
FROM venda v
INNER JOIN vendedor_venda vv ON v.id = vv.venda_id
INNER JOIN vendedor ven ON ven.id = vv.vendedor_id
WHERE ven.nome = 'Pedro Lima';

CREATE VIEW vendas_totais AS SELECT id AS venda_id, valor_venda, data_venda
FROM venda;
