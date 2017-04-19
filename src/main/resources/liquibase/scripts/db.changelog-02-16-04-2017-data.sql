--liquibase formatted sql

--changeset lnadalete:02
--comment: Data mass to test - Livros

INSERT INTO livro(titulo,editor,edicao,autor,nr_paginas) VALUES ('Livro 1','Novatec','4','Felipe Casseb',156);
INSERT INTO livro(titulo,editor,edicao,autor,nr_paginas) VALUES ('Livro 2','Novatec','1','Felipe Casseb',200);
INSERT INTO livro(titulo,editor,edicao,autor,nr_paginas) VALUES ('Livro 3','Novatec','2','Leonardo',233);
INSERT INTO livro(titulo,editor,edicao,autor,nr_paginas) VALUES ('Livro 4','Novatec','1','Miqueias',988);

--rollback DELETE FROM livro;


--changeset lnadalete:03
--comment: Data mass to test - Leitor

INSERT INTO leitor(nome,email) VALUES ('Lucas Nadalete','lucas.nadalete@fatec.sp.gov.br');
INSERT INTO leitor(nome,email) VALUES ('Miqueias da Silva','miqueias@fatec.sp.gov.br');
INSERT INTO leitor(nome,email) VALUES ('Paulo Rangel','paulo.rangel@fatec.sp.gov.br');

--rollback DELETE FROM leitor;

--changeset lnadalete:04
--comment: Data mass to test - Historico

INSERT INTO historico(id_leitor,id_livro, data) VALUES (1,1,CURDATE());
INSERT INTO historico(id_leitor,id_livro, data) VALUES (1,2,CURDATE());
INSERT INTO historico(id_leitor,id_livro, data) VALUES (2,3,CURDATE());
INSERT INTO historico(id_leitor,id_livro, data) VALUES (2,4,CURDATE());
INSERT INTO historico(id_leitor,id_livro, data) VALUES (3,1,CURDATE());
INSERT INTO historico(id_leitor,id_livro, data) VALUES (3,2,CURDATE());

--rollback DELETE FROM historio;