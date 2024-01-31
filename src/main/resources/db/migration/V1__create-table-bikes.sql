create table bikes(

    id bigint not null auto_increment,
    descricao varchar(150) not null,
    modelo varchar(100) not null,
    preco double(7,2) not null,
    data_compra date,
    comprador varchar(100) not null,
    loja varchar(100) not null,

    primary key(id)

);