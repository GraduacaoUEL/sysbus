CREATE TABLE Percorre
(
	numero_linha INTEGER,
	numero_itinerario_percorrido INTEGER,
PRIMARY KEY(numero_linha, numero_itinerario_percorrido)
FOREIGN KEY(numero_linha) REFERENCES Linha(codigo_linha),
FOREIGN KEY(numero_itinerario_percorrido) REFERENCES Itinerario(codigo_itinerario)
);
