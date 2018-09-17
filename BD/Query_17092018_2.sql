create table clt_tipo_usuario(
	id tinyint not null primary key identity(1, 1),
	nombre varchar(70) not null,
	descripcion varchar(150) not null 
);

insert into clt_tipo_usuario(nombre, descripcion) values('administrador', 'usuario administrador');
insert into clt_tipo_usuario(nombre, descripcion) values('usuario app', 'usuario normal');

ALTER TABLE tbl_usuario
add id_tipo_usuario tinyint not null default(2),
foreign key (id_tipo_usuario) references clt_tipo_usuario(id);

alter table clt_permisos
drop constraint FK__clt_permi__id_us__74AE54BC;

ALTER TABLE clt_permisos
DROP COLUMN id_usuario;

ALTER TABLE clt_permisos
add id_tipo_usuario tinyint not null,
foreign key (id_tipo_usuario) references clt_tipo_usuario(id);