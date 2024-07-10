Este projeto foi feito para ser um sistema de uma Academia utilizando Java, com conexão ao banco de dados.

Para conseguir a conexão com o banco de dados você devera utilizar o XAMP e inserir esse código para criar as tabelas: 

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL    
);
CREATE TABLE cadastroequipamentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nomeequipamento VARCHAR(255) NOT NULL,
    codigoequipamento VARCHAR(255) NOT NULL,
    pesosuportado VARCHAR(255) NOT NULL,
    grupomuscular VARCHAR(255) NOT NULL,
    datamanutencao VARCHAR(255) NOT NULL    
);
CREATE TABLE funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    salario VARCHAR(255) NOT NULL,
    departamento VARCHAR(255) NOT NULL    
);
CREATE TABLE fichatreino (
    id INT PRIMARY KEY AUTO_INCREMENT,
    objetivo VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    treinoa VARCHAR(255) NOT NULL,
    treinob VARCHAR(255) NOT NULL,
    treinoc VARCHAR(255) NOT NULL    
);
