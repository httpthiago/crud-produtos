insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (1, '70.311.193/0001-87', 'Mercado do João', 'João Mercado e Distribuidor de Alimentos Ltda', 'LTDA', '2009-03-02');
insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (2, '52.822.994/0001-25', 'Fale Mais', 'Fale Mais Telecom S.A.', 'SA', '1997-12-10');
insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (3, '41.952.519/0001-57', 'Maria de Souza da Silva', 'Maria de Souza da Silva', 'MEI', '2014-10-15');
insert into Empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao) values (4, '16.134.777/0001-89', 'Gomes Inovação', 'José Fernando Gomes EIRELI ME', 'EIRELI', '2009-03-02');


insert into categoria (descricao) values ('Doces');
insert into categoria (descricao) values ('Salgados');
	
insert into produto (nome, valor, estoque, categoria_id) values ('Bolo de Morango', 1.25, 10, 1);
insert into produto (nome, valor, estoque, categoria_id) values	('Coxinha de frango', 3.50, 2, 2);

