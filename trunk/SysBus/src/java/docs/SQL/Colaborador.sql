CREATE TABLE Colaborador
(
	codigo_colaborador INTEGER,
	nome_colaborador VARCHAR(40) NOT NULL,
	login_colaborador VARCHAR(15) NOT NULL,
	senha_colaborador VARCHAR(15) NOT NULL,
	cargo_colaborador INTEGER NOT NULL,
PRIMARY KEY(codigo_colaborador),
FOREIGN KEY(cargo_colaborador) REFERENCES Cargo(codigo_cargo)
);
