CREATE TABLE Possui
(
	numero_itinerario INTEGER,
	numero_trecho INTEGER,
PRIMARY KEY(numero_itinerario, numero_trecho),
FOREIGN KEY(numero_itinerario) REFERENCES Itinerario(codigo_itinerario),
FOREIGN KEY(numero_trecho) REFERENCES Trecho(codigo_trecho)
);