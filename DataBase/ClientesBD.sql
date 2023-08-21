-- Cria o banco
create database java_crud;
-- Seleciona ele
use java_crud;
-- Cria a tabela que será usada
create table clientes (
	id int not null primary key auto_increment,
    nome varchar(40),
    cpf char(11),
    nascimento date,
    situacao char(7)
);

