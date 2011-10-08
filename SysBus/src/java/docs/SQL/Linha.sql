CREATE TABLE Linha
(
    codigo_linha INTEGER,
    nome_linha VARCHAR(40) NOT NULL,
    hora_inicio_linha TIME NOT NULL,
    demanda_linha INTEGER NOT NULL,
PRIMARY KEY(codigo_linha),
FOREIGN KEY(demanda_linha) REFERENCES Demanda(codigo_demanda)
);
