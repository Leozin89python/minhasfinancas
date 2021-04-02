CREATE SCHEMA financas;

DROP SCHEMA financas;

CREATE TABLE financas.usuario(
	id BIGSERIAL NOT NULL PRIMARY KEY,
	nome CHARACTER VARYING(150),
	email CHARACTER VARYING(100),
	senha CHARACTER VARYING(20),
	data_cadastro DATE DEFAULT NOW()
);

DROP TABLE financas.usuario;



CREATE TABLE financas.lancamento(
	id BIGSERIAL NOT NULL PRIMARY KEY,
	descricao CHARACTER VARYING(100) NOT NULL,
	mes INTEGER NOT NULL,
	ano INTEGER NOT NULL,
	valor NUMERIC(16, 2)NOT NULL,
	tipo CHARACTER VARYING(20) CHECK( tipo IN ('RECEITA','DESPESA') )  NOT NULL,
	status CHARACTER VARYING(20)  CHECK( status IN ('PENDENTE','CANCELADO','EFETIVADO') ) NOT NULL,
	id_usuario BIGINT REFERENCES financas.usuario(id) NOT NULL,
	data_cadastro DATE DEFAULT NOW()
);

DROP TABLE financas.lancamento


SELECT * FROM financas.usuario;
SELECT * FROM financas.lancamento;

INSERT INTO financas.usuario VALUES(1,'Mendes Sousa','mendes@gmail.com','1234');

