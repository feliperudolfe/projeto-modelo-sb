
INSERT INTO TB_PESSOAS (CODIGO, REGISTRO, ATUALIZACAO, DATA_NASCIMENTO, GENERO, NOME)
VALUES (1, '2018-12-04 00:00:00.000', null,'1986-04-02', 'M', 'Felipe Rudolfe');

INSERT INTO TB_PERMISSOES (CODIGO, REGISTRO, ATUALIZACAO, TITULO)
VALUES ('ADMIN', '2018-12-04 00:00:00.000', null, 'Administrador');

INSERT INTO TB_PERFIS (CODIGO, REGISTRO, ATUALIZACAO, TITULO)
VALUES (1, '2018-12-04 00:00:00.000', null, 'Administrador');

INSERT INTO TB_PERMISSOES_PERFIL (PERFIL, PERMISSAO)
VALUES (1, 'ADMIN');

INSERT INTO TB_USUARIOS (CODIGO, REGISTRO, ATUALIZACAO, LOGIN, SENHA)
VALUES (1, '2018-12-04 00:00:00.000', null, 'admin', 'admin');
