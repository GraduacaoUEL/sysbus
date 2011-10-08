CREATE TABLE Venda
(
	codigo_venda INTEGER,
	data_venda TIMESTAMP NOT NULL,
	tipo_pagamento VARCHAR(8) DEFAULT 'Dinheiro',
	valor_venda DECIMAL(3,2) NOT NULL,
	passagem_entregue BOOLEAN DEFAULT FALSE,
	via_web CHAR(10),
	vendedor INTEGER,
	carro_venda INTEGER,
PRIMARY KEY(codigo_venda),
FOREIGN KEY(vendedor) REFERENCES Colaborador(codigo_colaborador),
FOREIGN KEY(carro_venda) REFERENCES Carro(codigo_carro)
);
