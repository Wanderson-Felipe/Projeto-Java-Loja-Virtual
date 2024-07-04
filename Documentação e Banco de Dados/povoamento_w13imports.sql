INSERT INTO Vendedor (nome, cpf) VALUES

('Pedro Lima', '79562148175'),
('Douglas Teixeira', '64852318795'),
('David Paulo', '1652154855'),
('Michael Felipe', '56348951203'),
('Alisson Raul', '62314796542');

SELECT * FROM Vendedor;

INSERT INTO Cliente (nome,cpf,telefone,endereço) VALUES

('Alex Lima','55384477237','252516084','Rua F 900 SP'),
('Leandro Santos','05938080967','1136911201','Avenida Jandira 652 SP'),
('Jarisson Silva','95610032601','4825137270','Rua Bortolo 53 SP'),
('Fabio Gonçalves','61911851977','9537064429','Rua Senador Vilela 892  SP'),
('Douglas Henrique','54946966188','9835596270','Rua V12 2 SP');

SELECT * FROM Cliente;

INSERT INTO Produto (nome, tamanho, descricao, quantidade, valor) VALUES

('Camisa São Paulo','P','Camisa Jogo 96% Poliéster, 4% Elastano','50','450,00'),
('Camisa Corinthians','M','Camisa Treino Dri–Fit Tecido de poliéster','50','250,00'),
('Palmeiras','G','Camisa Torcedor Dry Cell Afasta a transpiração','50','350,00'),
('Flamengo','GG','Camisa Casual 100% Algodão','50','120,00');

SELECT * FROM Produto;

INSERT INTO Venda (data, quantidade, Cliente_id, Produto_id, valor) VALUES

('2023/01/10','10','1','1','450,00'),
('2023/03/15','25','3','2','240,00'),
('2023/05/23','50','5','3','350,00');

SELECT * FROM Venda;

INSERT INTO Vendedor_Venda (Vendedor_id, Venda_id) VALUES

('1','1'),
('2','2'),
('4','3');

