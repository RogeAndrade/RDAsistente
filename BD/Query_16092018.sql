create table tbl_tareas(
	id int not null primary key identity(1, 1),
	id_periodicidad tinyint not null,
	nombre_tarea varchar(50) not null,
	id_persona int not null,
	foreign key (id_persona) references tbl_persona(id)
);

create table clt_menu(
	id int not null primary key identity(1, 1),
	nombre varchar(60) not null,
	descripcion varchar(150) not null
);

create table clt_permisos(
	id int not null primary key identity(1, 1),
	id_usuario int not null,
	id_menu int not null,
	foreign key (id_usuario) references tbl_usuario(id),
	foreign key (id_menu) references clt_menu(id)
);

create table tbl_invitacion_eventos(
	id_persona_creada int not null,
	id_persona_invitada int not null,
	acepto char(1) not null
);

create table clt_prioridad_evento(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(60) not null,
	descripcion varchar(150) not null
);

create table clt_fuente_evento(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(60) not null,
	descripcion varchar(150) not null
);

create table clt_tipo_evento(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(60) not null,
	descripcion varchar(150) not null
);

create table tbl_eventos(
	id int not null primary key identity(1, 1),
	id_persona int not null,
	fecha datetime not null,
	anticipacion_aviso float not null,
	envio_invitacion char(1) not null,
	nombre varchar(70) not null,
	id_prioridad_evento tinyint not null,
	id_fuente_evento tinyint not null,
	id_tipo_evento tinyint not null,
	foreign key (id_persona) references tbl_persona(id),
	foreign key (id_prioridad_evento) references clt_prioridad_evento(id),
	foreign key (id_fuente_evento) references clt_fuente_evento(id),
	foreign key (id_tipo_evento) references clt_tipo_evento(id)
);

/*create table clt_tipo_campos_extras(
	id int not null primary key identity(1, 1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null
);

create table tbl_capos_extras(
	id int not null primary key identity(1, 1),
	nombre varchar(120) not null,

);*/