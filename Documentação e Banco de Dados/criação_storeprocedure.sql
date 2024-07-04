DELIMITER //

CREATE PROCEDURE inserir_cliente(
IN nome_cliente VARCHAR (100),
IN cpf_cliente VARCHAR (11),
IN telefone_cliente VARCHAR (11),
IN endereço_cliente VARCHAR (255)
)

BEGIN
INSERT INTO cliente (nome,cpf,telefone,endereço)
VALUES (nome_cliente, cpf_cliente, telefone_cliente, endereço_cliente);
END//

DELIMITER ;

call inserir_cliente('Maria Souza', '46132045679', '53879461205', 'Rua b2 1984 SP');


SELECT * FROM cliente;

