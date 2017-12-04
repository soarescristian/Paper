-- Database: bdacademicnet
-- DROP DATABASE bdacademicnet;
CREATE DATABASE bdacademicnet
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;


-- Table: tbcliente
-- DROP TABLE tbcliente;

CREATE TABLE  IF NOT EXISTS tbaluno(
  matricula bigint NOT NULL,  
  nome character varying(255),
  telefone character varying(255),  
  email character varying(255),
  datacadastro date,
  CONSTRAINT tbaluno_pkey PRIMARY KEY (matricula)
);
