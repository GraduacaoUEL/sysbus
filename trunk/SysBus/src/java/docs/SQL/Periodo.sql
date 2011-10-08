CREATE TABLE Periodo
(
    codigo_periodo INTEGER,
    inicio_periodo TIME NOT NULL,
    fim_periodo TIME NOT NULL,
    fator_multiplicacao DECIMAL(2,2) NOT NULL,
PRIMARY KEY(codigo_periodo)
);