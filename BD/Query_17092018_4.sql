create table tbl_persona_salud(
	id int not null primary key identity(1,1),
	id_persona int not null,
	peso float,
	altura float,
	edad tinyint,
	foreign key (id_persona) references tbl_persona(id)
);

create table tbl_pasos(
	id bigint not null primary key identity(1, 1),
	id_persona int not null,
	fecha datetime not null,
	pasos int not null,
	foreign key (id_persona) references tbl_persona(id)
);

create table tbl_salud(
	id int not null primary key identity(1,1),
	calorias_consumidas smallint not null,
	fecha datetime not null,
	id_persona_salud int not null,
	calorias_perdidas smallint not null,
	alerta_calorias smallint not null,
	foreign key (id_persona_salud) references tbl_persona_salud(id)
);

alter table tbl_persona
add invitame_cafe char(1) not null default('0');