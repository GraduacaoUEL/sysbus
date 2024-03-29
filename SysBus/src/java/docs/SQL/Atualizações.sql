ALTER TABLE carro ALTER linha_carro SET NOT NULL;
ALTER TABLE carro ADD CHECK (codigo_carro > 0);
ALTER TABLE carro ADD CHECK (numero_passageiros > 0);
ALTER TABLE custo ADD CHECK (preco_quilometro > 0);
ALTER TABLE periodo ADD CHECK (fator_multiplicacao > 0);
ALTER TABLE trecho ADD CHECK (distancia_trecho > 0);
ALTER TABLE trecho ADD CONSTRAINT trecho_custo_trecho_fkey FOREIGN KEY (custo_trecho) REFERENCES custo (codigo_custo) MATCH SIMPLE;
ALTER TABLE venda ADD CHECK (valor_venda > 0);
ALTER TABLE venda ALTER vendedor SET NOT NULL;
ALTER TABLE venda ALTER carro_venda SET NOT NULL;