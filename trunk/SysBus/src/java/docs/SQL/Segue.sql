CREATE TABLE Segue
(
    numero_demanda INTEGER,
    numero_periodo INTEGER,
PRIMARY KEY(numero_demanda, numero_periodo),
FOREIGN KEY(numero_demanda) REFERENCES Demanda(codigo_demanda),
FOREIGN KEY(numero_periodo) REFERENCES Periodo(codigo_periodo)
);