create database asistente;

use asistente;

go;

create table tbl_persona(
	id int identity(1, 1) not null primary key,
	nombre varchar(50) not null,
	apellidos varchar(120),
	telefono varchar(15) not null,
	correo varchar(150) not null,
	url_img varchar(255)
);

create table tbl_usuario(
	id int identity (1, 1) not null primary key,
	id_persona int not null,
	psw varchar(255) not null,
	usr varchar(40) not null,
	facebook char(1) not null,
	google char(1) not null,
	mail char(1) not null,
	recibe_notificaciones char(1) not null,
	foreign key (id_persona) references tbl_persona(id)
);

create procedure sp_register_user @nombre varchar(50), @apellidos varchar(120), @telefono varchar(15), @correo varchar(150), @url_img varchar(255), 
@usr varchar(40), @psw varchar(20), @tipo char(1)
as

