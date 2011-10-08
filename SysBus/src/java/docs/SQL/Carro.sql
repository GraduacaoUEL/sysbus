CREATE TABLE Carro
(
	codigo_carro INTEGER,
	numero_passageiros INTEGER NOT NULL,
	linha_carro INTEGER,
PRIMARY KEY(codigo_carro),
FOREIGN KEY(linha_carro) REFERENCES Linha(codigo_linha)
);
