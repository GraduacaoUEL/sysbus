CREATE TABLE Cargo
(
	codigo_cargo INTEGER,
	nome_cargo VARCHAR(20) NOT NULL,
	permissao_cargos BOOLEAN DEFAULT FALSE,
	permissao_carros BOOLEAN DEFAULT FALSE,
	permissao_itinerarios BOOLEAN DEFAULT FALSE,
	permissao_vendas BOOLEAN DEFAULT FALSE,
	permissao_custos BOOLEAN DEFAULT FALSE,
PRIMARY KEY(codigo_cargo)
);