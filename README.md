-- Script SQL para Database

create database srm;
use srm;

create table moeda(
idMoeda int NOT NULL AUTO_INCREMENT,
nomeMoeda varchar(255),
PRIMARY KEY (idMoeda)
);

create table reino(
idReino int NOT NULL AUTO_INCREMENT,
nomeReino varchar(255),
taxaReino double,
PRIMARY KEY (idReino)
);

create table produto(
idProduto  int NOT NULL AUTO_INCREMENT,
nomeProduto varchar(255),
valorOuro double,
valorTibar double,
fkReinoOrigem int,
PRIMARY KEY (idProduto),
FOREIGN KEY (fkReinoOrigem) REFERENCES reino(idReino)
);

create table taxa(
idTaxa int NOT NULL AUTO_INCREMENT,
valorTaxa double,
dataMudanca date,
PRIMARY KEY (idTaxa)
);

create table transacao(
idTransacao int NOT NULL AUTO_INCREMENT,
horaTransacao datetime,
valorFinal double,
fkProduto int,
fkMoedaOrigem int,
fkMoedaDestino int,
PRIMARY KEY (idTransacao),
FOREIGN KEY (fkProduto) REFERENCES produto(idProduto),
FOREIGN KEY (fkMoedaOrigem) REFERENCES moeda(idMoeda),
FOREIGN KEY (fkMoedaDestino) REFERENCES moeda(idMoeda)
);

INSERT INTO moeda (nomeMoeda) VALUES
("Ouro Real"),
("Tibar");
 
 INSERT INTO taxa (valorTaxa, dataMudanca) VALUES
 (2.5, CURRENT_DATE());
 
 select * from moeda;
;
