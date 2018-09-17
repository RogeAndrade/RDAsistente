create table clt_tipo_cuenta(
	id tinyint not null primary key identity(1,1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table tbl_cuentas(
	id int not null primary key identity(1, 1),
	id_tipo_cuenta tinyint not null,
	nombre varchar(70) not null,
	id_usuario int not null,
	foreign key (id_tipo_cuenta) references clt_tipo_cuenta(id),
	foreign key (id_usuario) references tbl_usuario(id)
);

create table clt_tipo_dato_cuenta(
	id tinyint not null primary key identity(1,1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table tbl_campos_cuenta(
	id bigint not null primary key identity(1, 1),
	id_cuenta int not null,
	id_tipo_dato_cuenta tinyint not null,
	valor varchar(255) not null,
	foreign key (id_cuenta) references tbl_cuentas(id),
	foreign key (id_tipo_dato_cuenta) references clt_tipo_dato_cuenta(id)
);