--
-- PostgreSQL database dump
--

-- Started on 2011-10-13 16:49:15 BRT

SET statement_timeout = 0;
SET client_encoding = 'UNICODE';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 1532 (class 1259 OID 16616)
-- Dependencies: 3
-- Name: sequencia_cargo; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_cargo
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_cargo OWNER TO sysbus;

--
-- TOC entry 1893 (class 0 OID 0)
-- Dependencies: 1532
-- Name: sequencia_cargo; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_cargo', 2, true);


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1523 (class 1259 OID 16458)
-- Dependencies: 1822 1823 1824 1825 1826 1827 3
-- Name: cargo; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE cargo (
    codigo_cargo integer DEFAULT nextval('sequencia_cargo'::regclass) NOT NULL,
    nome_cargo character varying(20) NOT NULL,
    permissao_cargos boolean DEFAULT false,
    permissao_carros boolean DEFAULT false,
    permissao_itinerarios boolean DEFAULT false,
    permissao_vendas boolean DEFAULT false,
    permissao_custos boolean DEFAULT false
);


ALTER TABLE public.cargo OWNER TO sysbus;

--
-- TOC entry 1526 (class 1259 OID 16493)
-- Dependencies: 3
-- Name: carro; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE carro (
    codigo_carro integer NOT NULL,
    numero_passageiros integer NOT NULL,
    linha_carro integer
);


ALTER TABLE public.carro OWNER TO sysbus;

--
-- TOC entry 1538 (class 1259 OID 16690)
-- Dependencies: 3
-- Name: sequencia_colaborador; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_colaborador
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_colaborador OWNER TO sysbus;

--
-- TOC entry 1894 (class 0 OID 0)
-- Dependencies: 1538
-- Name: sequencia_colaborador; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_colaborador', 2, true);


--
-- TOC entry 1537 (class 1259 OID 16674)
-- Dependencies: 1832 3
-- Name: colaborador; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE colaborador (
    codigo_colaborador integer DEFAULT nextval('sequencia_colaborador'::regclass) NOT NULL,
    nome_colaborador character varying(40) NOT NULL,
    login_colaborador character varying(15) NOT NULL,
    senha_colaborador character(32) NOT NULL,
    cargo_colaborador integer NOT NULL
);


ALTER TABLE public.colaborador OWNER TO sysbus;

--
-- TOC entry 1540 (class 1259 OID 16698)
-- Dependencies: 3
-- Name: sequencia_custo; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_custo
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_custo OWNER TO sysbus;

--
-- TOC entry 1895 (class 0 OID 0)
-- Dependencies: 1540
-- Name: sequencia_custo; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_custo', 1, false);


--
-- TOC entry 1539 (class 1259 OID 16693)
-- Dependencies: 1833 3
-- Name: custo; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE custo (
    codigo_custo integer DEFAULT nextval('sequencia_custo'::regclass) NOT NULL,
    preco_quilometro numeric(5,2) NOT NULL
);


ALTER TABLE public.custo OWNER TO sysbus;

--
-- TOC entry 1536 (class 1259 OID 16631)
-- Dependencies: 3
-- Name: sequencia_demanda; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_demanda
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_demanda OWNER TO sysbus;

--
-- TOC entry 1896 (class 0 OID 0)
-- Dependencies: 1536
-- Name: sequencia_demanda; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_demanda', 1, true);


--
-- TOC entry 1524 (class 1259 OID 16478)
-- Dependencies: 1828 3
-- Name: demanda; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE demanda (
    codigo_demanda integer DEFAULT nextval('sequencia_demanda'::regclass) NOT NULL,
    nome_demanda character varying(20) NOT NULL
);


ALTER TABLE public.demanda OWNER TO sysbus;

--
-- TOC entry 1534 (class 1259 OID 16622)
-- Dependencies: 3
-- Name: sequencia_itinerario; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_itinerario
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_itinerario OWNER TO sysbus;

--
-- TOC entry 1897 (class 0 OID 0)
-- Dependencies: 1534
-- Name: sequencia_itinerario; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_itinerario', 1, false);


--
-- TOC entry 1527 (class 1259 OID 16518)
-- Dependencies: 1830 3
-- Name: itinerario; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE itinerario (
    codigo_itinerario integer DEFAULT nextval('sequencia_itinerario'::regclass) NOT NULL,
    nome_itinerario character varying(40) NOT NULL
);


ALTER TABLE public.itinerario OWNER TO sysbus;

--
-- TOC entry 1533 (class 1259 OID 16619)
-- Dependencies: 3
-- Name: sequencia_linha; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_linha
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_linha OWNER TO sysbus;

--
-- TOC entry 1898 (class 0 OID 0)
-- Dependencies: 1533
-- Name: sequencia_linha; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_linha', 1, true);


--
-- TOC entry 1525 (class 1259 OID 16483)
-- Dependencies: 1829 3
-- Name: linha; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE linha (
    codigo_linha integer DEFAULT nextval('sequencia_linha'::regclass) NOT NULL,
    nome_linha character varying(40) NOT NULL,
    hora_inicio_linha time without time zone NOT NULL,
    demanda_linha integer NOT NULL
);


ALTER TABLE public.linha OWNER TO sysbus;

--
-- TOC entry 1528 (class 1259 OID 16523)
-- Dependencies: 3
-- Name: percorre; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE percorre (
    numero_linha integer NOT NULL,
    numero_itinerario_percorrido integer NOT NULL
);


ALTER TABLE public.percorre OWNER TO sysbus;

--
-- TOC entry 1542 (class 1259 OID 16706)
-- Dependencies: 3
-- Name: sequencia_periodo; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_periodo
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_periodo OWNER TO sysbus;

--
-- TOC entry 1899 (class 0 OID 0)
-- Dependencies: 1542
-- Name: sequencia_periodo; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_periodo', 1, false);


--
-- TOC entry 1541 (class 1259 OID 16701)
-- Dependencies: 1834 3
-- Name: periodo; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE periodo (
    codigo_periodo integer DEFAULT nextval('sequencia_periodo'::regclass) NOT NULL,
    inicio_periodo time without time zone NOT NULL,
    fim_periodo time without time zone NOT NULL,
    fator_multiplicacao numeric(3,2) NOT NULL
);


ALTER TABLE public.periodo OWNER TO sysbus;

--
-- TOC entry 1530 (class 1259 OID 16563)
-- Dependencies: 3
-- Name: possui; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE possui (
    numero_itinerario integer NOT NULL,
    numero_trecho integer NOT NULL
);


ALTER TABLE public.possui OWNER TO sysbus;

--
-- TOC entry 1531 (class 1259 OID 16578)
-- Dependencies: 3
-- Name: segue; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE segue (
    numero_demanda integer NOT NULL,
    numero_periodo integer NOT NULL
);


ALTER TABLE public.segue OWNER TO sysbus;

--
-- TOC entry 1535 (class 1259 OID 16625)
-- Dependencies: 3
-- Name: sequencia_trecho; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_trecho
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_trecho OWNER TO sysbus;

--
-- TOC entry 1900 (class 0 OID 0)
-- Dependencies: 1535
-- Name: sequencia_trecho; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_trecho', 1, false);


--
-- TOC entry 1544 (class 1259 OID 16769)
-- Dependencies: 3
-- Name: sequencia_venda; Type: SEQUENCE; Schema: public; Owner: sysbus
--

CREATE SEQUENCE sequencia_venda
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.sequencia_venda OWNER TO sysbus;

--
-- TOC entry 1901 (class 0 OID 0)
-- Dependencies: 1544
-- Name: sequencia_venda; Type: SEQUENCE SET; Schema: public; Owner: sysbus
--

SELECT pg_catalog.setval('sequencia_venda', 1, true);


--
-- TOC entry 1529 (class 1259 OID 16553)
-- Dependencies: 1831 3
-- Name: trecho; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE trecho (
    codigo_trecho integer DEFAULT nextval('sequencia_trecho'::regclass) NOT NULL,
    origem_trecho character varying(20) NOT NULL,
    destino_trecho character varying(20) NOT NULL,
    tempo_trecho time without time zone NOT NULL,
    distancia_trecho numeric(3,1) NOT NULL,
    custo_trecho integer NOT NULL
);


ALTER TABLE public.trecho OWNER TO sysbus;

--
-- TOC entry 1543 (class 1259 OID 16751)
-- Dependencies: 1835 1836 1837 1838 3
-- Name: venda; Type: TABLE; Schema: public; Owner: sysbus; Tablespace: 
--

CREATE TABLE venda (
    codigo_venda integer DEFAULT nextval('sequencia_venda'::regclass) NOT NULL,
    data_venda timestamp without time zone NOT NULL,
    tipo_pagamento character varying(8) DEFAULT 'Dinheiro'::character varying,
    valor_venda numeric(5,2) NOT NULL,
    passagem_entregue boolean DEFAULT false,
    via_web boolean DEFAULT false,
    vendedor integer,
    carro_venda integer
);


ALTER TABLE public.venda OWNER TO sysbus;

--
-- TOC entry 1875 (class 0 OID 16458)
-- Dependencies: 1523
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY cargo (codigo_cargo, nome_cargo, permissao_cargos, permissao_carros, permissao_itinerarios, permissao_vendas, permissao_custos) FROM stdin;
1	Gerente	t	t	t	t	t
2	Vendedor	f	f	f	t	f
\.


--
-- TOC entry 1878 (class 0 OID 16493)
-- Dependencies: 1526
-- Data for Name: carro; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY carro (codigo_carro, numero_passageiros, linha_carro) FROM stdin;
912	60	1
\.


--
-- TOC entry 1884 (class 0 OID 16674)
-- Dependencies: 1537
-- Data for Name: colaborador; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY colaborador (codigo_colaborador, nome_colaborador, login_colaborador, senha_colaborador, cargo_colaborador) FROM stdin;
2	Helio	helioalb	e10adc3949ba59abbe56e057f20f883e	1
\.


--
-- TOC entry 1885 (class 0 OID 16693)
-- Dependencies: 1539
-- Data for Name: custo; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY custo (codigo_custo, preco_quilometro) FROM stdin;
\.


--
-- TOC entry 1876 (class 0 OID 16478)
-- Dependencies: 1524
-- Data for Name: demanda; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY demanda (codigo_demanda, nome_demanda) FROM stdin;
1	Norte do Paraná
\.


--
-- TOC entry 1879 (class 0 OID 16518)
-- Dependencies: 1527
-- Data for Name: itinerario; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY itinerario (codigo_itinerario, nome_itinerario) FROM stdin;
\.


--
-- TOC entry 1877 (class 0 OID 16483)
-- Dependencies: 1525
-- Data for Name: linha; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY linha (codigo_linha, nome_linha, hora_inicio_linha, demanda_linha) FROM stdin;
1	Londrina-Curitiba	10:00:00	1
\.


--
-- TOC entry 1880 (class 0 OID 16523)
-- Dependencies: 1528
-- Data for Name: percorre; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY percorre (numero_linha, numero_itinerario_percorrido) FROM stdin;
\.


--
-- TOC entry 1886 (class 0 OID 16701)
-- Dependencies: 1541
-- Data for Name: periodo; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY periodo (codigo_periodo, inicio_periodo, fim_periodo, fator_multiplicacao) FROM stdin;
\.


--
-- TOC entry 1882 (class 0 OID 16563)
-- Dependencies: 1530
-- Data for Name: possui; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY possui (numero_itinerario, numero_trecho) FROM stdin;
\.


--
-- TOC entry 1883 (class 0 OID 16578)
-- Dependencies: 1531
-- Data for Name: segue; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY segue (numero_demanda, numero_periodo) FROM stdin;
\.


--
-- TOC entry 1881 (class 0 OID 16553)
-- Dependencies: 1529
-- Data for Name: trecho; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY trecho (codigo_trecho, origem_trecho, destino_trecho, tempo_trecho, distancia_trecho, custo_trecho) FROM stdin;
\.


--
-- TOC entry 1887 (class 0 OID 16751)
-- Dependencies: 1543
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: sysbus
--

COPY venda (codigo_venda, data_venda, tipo_pagamento, valor_venda, passagem_entregue, via_web, vendedor, carro_venda) FROM stdin;
1	2011-10-11 18:47:00	Cartão	10.00	t	t	2	912
\.


--
-- TOC entry 1840 (class 2606 OID 16467)
-- Dependencies: 1523 1523
-- Name: cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (codigo_cargo);


--
-- TOC entry 1846 (class 2606 OID 16497)
-- Dependencies: 1526 1526
-- Name: carro_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY carro
    ADD CONSTRAINT carro_pkey PRIMARY KEY (codigo_carro);


--
-- TOC entry 1858 (class 2606 OID 16678)
-- Dependencies: 1537 1537
-- Name: colaborador_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY colaborador
    ADD CONSTRAINT colaborador_pkey PRIMARY KEY (codigo_colaborador);


--
-- TOC entry 1860 (class 2606 OID 16697)
-- Dependencies: 1539 1539
-- Name: custo_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY custo
    ADD CONSTRAINT custo_pkey PRIMARY KEY (codigo_custo);


--
-- TOC entry 1842 (class 2606 OID 16482)
-- Dependencies: 1524 1524
-- Name: demanda_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY demanda
    ADD CONSTRAINT demanda_pkey PRIMARY KEY (codigo_demanda);


--
-- TOC entry 1848 (class 2606 OID 16522)
-- Dependencies: 1527 1527
-- Name: itinerario_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY itinerario
    ADD CONSTRAINT itinerario_pkey PRIMARY KEY (codigo_itinerario);


--
-- TOC entry 1844 (class 2606 OID 16487)
-- Dependencies: 1525 1525
-- Name: linha_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY linha
    ADD CONSTRAINT linha_pkey PRIMARY KEY (codigo_linha);


--
-- TOC entry 1850 (class 2606 OID 16527)
-- Dependencies: 1528 1528 1528
-- Name: percorre_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY percorre
    ADD CONSTRAINT percorre_pkey PRIMARY KEY (numero_linha, numero_itinerario_percorrido);


--
-- TOC entry 1862 (class 2606 OID 16705)
-- Dependencies: 1541 1541
-- Name: periodo_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY periodo
    ADD CONSTRAINT periodo_pkey PRIMARY KEY (codigo_periodo);


--
-- TOC entry 1854 (class 2606 OID 16567)
-- Dependencies: 1530 1530 1530
-- Name: possui_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY possui
    ADD CONSTRAINT possui_pkey PRIMARY KEY (numero_itinerario, numero_trecho);


--
-- TOC entry 1856 (class 2606 OID 16582)
-- Dependencies: 1531 1531 1531
-- Name: segue_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY segue
    ADD CONSTRAINT segue_pkey PRIMARY KEY (numero_demanda, numero_periodo);


--
-- TOC entry 1852 (class 2606 OID 16557)
-- Dependencies: 1529 1529
-- Name: trecho_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY trecho
    ADD CONSTRAINT trecho_pkey PRIMARY KEY (codigo_trecho);


--
-- TOC entry 1864 (class 2606 OID 16758)
-- Dependencies: 1543 1543
-- Name: venda_pkey; Type: CONSTRAINT; Schema: public; Owner: sysbus; Tablespace: 
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (codigo_venda);


--
-- TOC entry 1866 (class 2606 OID 16498)
-- Dependencies: 1526 1525 1843
-- Name: carro_linha_carro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY carro
    ADD CONSTRAINT carro_linha_carro_fkey FOREIGN KEY (linha_carro) REFERENCES linha(codigo_linha);


--
-- TOC entry 1872 (class 2606 OID 16679)
-- Dependencies: 1839 1537 1523
-- Name: colaborador_cargo_colaborador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY colaborador
    ADD CONSTRAINT colaborador_cargo_colaborador_fkey FOREIGN KEY (cargo_colaborador) REFERENCES cargo(codigo_cargo);


--
-- TOC entry 1865 (class 2606 OID 16488)
-- Dependencies: 1525 1841 1524
-- Name: linha_demanda_linha_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY linha
    ADD CONSTRAINT linha_demanda_linha_fkey FOREIGN KEY (demanda_linha) REFERENCES demanda(codigo_demanda);


--
-- TOC entry 1868 (class 2606 OID 16533)
-- Dependencies: 1527 1528 1847
-- Name: percorre_numero_itinerario_percorrido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY percorre
    ADD CONSTRAINT percorre_numero_itinerario_percorrido_fkey FOREIGN KEY (numero_itinerario_percorrido) REFERENCES itinerario(codigo_itinerario);


--
-- TOC entry 1867 (class 2606 OID 16528)
-- Dependencies: 1525 1528 1843
-- Name: percorre_numero_linha_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY percorre
    ADD CONSTRAINT percorre_numero_linha_fkey FOREIGN KEY (numero_linha) REFERENCES linha(codigo_linha);


--
-- TOC entry 1869 (class 2606 OID 16568)
-- Dependencies: 1530 1847 1527
-- Name: possui_numero_itinerario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY possui
    ADD CONSTRAINT possui_numero_itinerario_fkey FOREIGN KEY (numero_itinerario) REFERENCES itinerario(codigo_itinerario);


--
-- TOC entry 1870 (class 2606 OID 16573)
-- Dependencies: 1530 1851 1529
-- Name: possui_numero_trecho_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY possui
    ADD CONSTRAINT possui_numero_trecho_fkey FOREIGN KEY (numero_trecho) REFERENCES trecho(codigo_trecho);


--
-- TOC entry 1871 (class 2606 OID 16583)
-- Dependencies: 1524 1531 1841
-- Name: segue_numero_demanda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY segue
    ADD CONSTRAINT segue_numero_demanda_fkey FOREIGN KEY (numero_demanda) REFERENCES demanda(codigo_demanda);


--
-- TOC entry 1874 (class 2606 OID 16764)
-- Dependencies: 1845 1526 1543
-- Name: venda_carro_venda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_carro_venda_fkey FOREIGN KEY (carro_venda) REFERENCES carro(codigo_carro);


--
-- TOC entry 1873 (class 2606 OID 16759)
-- Dependencies: 1543 1857 1537
-- Name: venda_vendedor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: sysbus
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_vendedor_fkey FOREIGN KEY (vendedor) REFERENCES colaborador(codigo_colaborador);


--
-- TOC entry 1892 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2011-10-13 16:49:17 BRT

--
-- PostgreSQL database dump complete
--

