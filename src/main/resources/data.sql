INSERT INTO AUTORES(id, nome) VALUES(1,'Maurice Leblanc');
INSERT INTO AUTORES(id, nome) VALUES( 2,'Arthur Conan Doyle');
INSERT INTO AUTORES(id, nome) VALUES( 3,'George Orwell');

INSERT INTO EDITORAS(id, nome) VALUES(1,'Lafonte');
INSERT INTO EDITORAS(id, nome) VALUES( 2,'Prime');


INSERT INTO LIVROS(id, autor_id, editora_id, titulo) VALUES(1, 1, 1, 'O ladrão de Casaca');
INSERT INTO LIVROS(id, autor_id, editora_id, titulo) VALUES(2, 2, 1, 'O cão dos Baskervilles');
INSERT INTO LIVROS(id, autor_id, editora_id, titulo) VALUES(3, 3, 2, 'Revolução dos bichos');