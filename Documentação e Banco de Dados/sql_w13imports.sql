CREATE DATABASE w13_imports;

USE w13_imports;

CREATE TABLE Vendedor (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  cpf VARCHAR(11) NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE Cliente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  cpf VARCHAR(11) NULL,
  telefone VARCHAR(11) NULL,
  endereço VARCHAR(255) NULL,
  PRIMARY KEY (id)
  );
  
  CREATE TABLE Produto (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NULL,
  tamanho VARCHAR(255) NULL,
  descricao VARCHAR(255) NULL,
  quantidade VARCHAR (255) NULL,
  valor VARCHAR (45) NULL,
  PRIMARY KEY (id)
  );
  
  CREATE TABLE Venda (
  id INT NOT NULL AUTO_INCREMENT,
  data DATE NULL,
  quantidade  VARCHAR (255) NULL,
  Cliente_id INT NOT NULL,
  Produto_id INT NOT NULL, 
  valor VARCHAR (100) NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (Cliente_id) REFERENCES Cliente(id),
  FOREIGN KEY (Produto_id) REFERENCES Produto(id)
  );
 
 CREATE TABLE Vendedor_Venda (
  Vendedor_id INT NOT NULL ,
  Venda_id INT NOT NULL,
  PRIMARY KEY (Vendedor_id, Venda_id),
  FOREIGN KEY (Vendedor_id) REFERENCES Vendedor(id),
  FOREIGN KEY (Venda_id) REFERENCES Venda(id)
  );
 