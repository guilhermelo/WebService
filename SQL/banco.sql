
create database noticiario;

use noticiario;
create table noticias (
	id integer,
	titulo varchar(20),
	descricao text,
	dt_update date
);