CREATE SEQUENCE sequencia_venda
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE venda ALTER COLUMN codigo_venda SET DEFAULT NEXTVAL('sequencia_venda'::regclass);


CREATE SEQUENCE sequencia_colaborador
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE colaborador ALTER COLUMN codigo_colaborador SET DEFAULT NEXTVAL('sequencia_colaborador'::regclass);


CREATE SEQUENCE sequencia_cargo
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE cargo ALTER COLUMN codigo_cargo SET DEFAULT NEXTVAL('sequencia_cargo'::regclass);


CREATE SEQUENCE sequencia_linha
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE linha ALTER COLUMN codigo_linha SET DEFAULT NEXTVAL('sequencia_linha'::regclass);


CREATE SEQUENCE sequencia_itinerario
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE itinerario ALTER COLUMN codigo_itinerario SET DEFAULT NEXTVAL('sequencia_itinerario'::regclass);


CREATE SEQUENCE sequencia_trecho
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE trecho ALTER COLUMN codigo_trecho SET DEFAULT NEXTVAL('sequencia_trecho'::regclass);


CREATE SEQUENCE sequencia_custo
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE custo ALTER COLUMN codigo_custo SET DEFAULT NEXTVAL('sequencia_custo'::regclass);


CREATE SEQUENCE sequencia_demanda
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE demanda ALTER COLUMN codigo_demanda SET DEFAULT NEXTVAL('sequencia_demanda'::regclass);


CREATE SEQUENCE sequencia_periodo
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;


ALTER TABLE periodo ALTER COLUMN codigo_periodo SET DEFAULT NEXTVAL('sequencia_periodo'::regclass);