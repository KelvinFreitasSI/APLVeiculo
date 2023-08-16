create table veiculo(
	idveiculo int primary key,
	marca varchar(20) not null,
	modelo varchar(20) not null
);
 insert into veiculo(idveiculo, marca, modelo)
 values('359', 'RAM', 'DODGE RAM');
 
 select * from veiculo;
