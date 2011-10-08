CREATE TABLE Trecho
(
	codigo_trecho INTEGER,
	origem_trecho VARCHAR(20) NOT NULL,
	destino_trecho VARCHAR(20) NOT NULL,
	tempo_trecho TIME NOT NULL,
	distancia_trecho DECIMAL(3,1) NOT NULL,
	custo_trecho INTEGER NOT NULL,
PRIMARY KEY(codigo_trecho),
FOREIGN KEY(custo_trecho) REFERENCES Custo(codigo_custo)
);
