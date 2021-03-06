create table clt_tipo_movimiento_finanzas(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table clt_periodicidad(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table clt_tipo_entrada(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table clt_estatus_finanzas(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table tbl_entidad_financiera(
	id smallint not null primary key identity(1, 1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table tbl_finanzas(
	id int not null primary key identity(1, 1),
	total float not null,
	id_persona int not null,
	id_estatus_finanzas tinyint not null,
	foreign key (id_persona) references tbl_persona (id),
	foreign key (id_estatus_finanzas) references clt_estatus_finanzas(id)
);

create table tbl_movimiento_finanzas(
	id int not null primary key identity(1, 1),
	fijo char(1) not null,
	id_tipo_movimiento tinyint not null,
	id_periodicidad tinyint not null,
	fecha_alta datetime not null,
	id_tipo_entrada tinyint not null,
	id_finanzas int not null,
	id_entidad_financiera smallint not null,
	nombre_movimiento varchar(100) not null,
	foreign key (id_tipo_movimiento) references clt_tipo_movimiento_finanzas (id),
	foreign key (id_periodicidad) references clt_periodicidad (id),
	foreign key (id_tipo_entrada) references clt_tipo_entrada (id),
	foreign key (id_finanzas) references tbl_finanzas (id),
	foreign key (id_entidad_financiera) references tbl_entidad_financiera (id)
);
