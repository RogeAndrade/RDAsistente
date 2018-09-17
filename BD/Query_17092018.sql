create table clt_tipo_tiempo_libre(
	id tinyint not null primary key identity(1,1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table clt_ejercicios(
	id smallint not null primary key identity(1,1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table clt_comida(
	id smallint not null primary key identity(1,1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table clt_gusto(
	id tinyint not null primary key identity(1,1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table tbl_tiempo_libre(
	id int not null primary key identity(1, 1),
	id_tipo_tiempo_libre tinyint not null,
	fecha_inicio datetime,
	fecha_fin datetime,
	duracion float not null,
	costo float not null,
	id_ejercicio smallint,
	id_comida smallint,
	id_persona int not null,
	id_gusto tinyint not null,
	foreign key (id_tipo_tiempo_libre) references clt_tipo_tiempo_libre(id),
	foreign key (id_ejercicio) references clt_ejercicios(id),
	foreign key (id_comida) references clt_comida(id),
	foreign key (id_persona) references tbl_persona(id),
	foreign key (id_gusto) references clt_gusto(id),
);
