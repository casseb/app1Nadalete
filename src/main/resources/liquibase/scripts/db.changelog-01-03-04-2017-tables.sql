--liquibase formatted sql

--changeset lnadalete:01
--comment: Create main tables

CREATE TABLE leitor (
  id_leitor INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_leitor),
  UNIQUE INDEX id_leitor_UNIQUE (id_leitor ASC));
   
   
CREATE TABLE livro (
  id_livro INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(200) NOT NULL,
  editor VARCHAR(200) NOT NULL,
  edicao VARCHAR(200) NOT NULL,
  autor VARCHAR(200) NOT NULL,
  nr_paginas INT NOT NULL,
  PRIMARY KEY (id_livro))
ENGINE = InnoDB;
   
CREATE TABLE historico (
  id_leitor INT(11) NOT NULL,
  id_livro INT(11) NOT NULL,
  data DATE NOT NULL,
  PRIMARY KEY (id_leitor, id_livro),
  INDEX fk_leitor_historico_idx (id_leitor ASC),
  INDEX fk_livro_historico_idx (id_livro ASC),
  CONSTRAINT fk_leitor_historico
    FOREIGN KEY (id_leitor)
    REFERENCES leitor (id_leitor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_livro_historico
    FOREIGN KEY (id_livro)
    REFERENCES livro (id_livro)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

--rollback SET FOREIGN_KEY_CHECKS = 0;
--rollback drop table if exists historico;
--rollback drop table if exists livro;
--rollback drop table if exists leitor;
--rollback SET FOREIGN_KEY_CHECKS = 1;
