CREATE DATABASE Perfil_V2;

USE Perfil_V2;

CREATE table servicos(
	idServico INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64),
	valor VARCHAR(16)
);

CREATE TABLE colaboradores(
	idColaborador INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64),
	telefone VARCHAR(16)
);

CREATE TABLE clientes(
	idCliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64),
	telefone VARCHAR(16)
);

CREATE TABLE atendimentos (
    idAtendimento INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    idServico INT NOT NULL,
    idColaborador INT NOT NULL,
    dataAtendimento VARCHAR(16) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES clientes(idCliente),
    FOREIGN KEY (idServico) REFERENCES servicos(idServico),
    FOREIGN KEY (idColaborador) REFERENCES colaboradores(idColaborador)
);