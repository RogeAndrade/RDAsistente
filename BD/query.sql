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
	alter_pass varchar(255) not null,
	recibe_notificaciones char(1) not null,
	foreign key (id_persona) references tbl_persona(id)
);

exec sp_register_user 'Rogelio', 'Andrade', '4771112781', 'rogeandrade1@gmail.com', null, 'randrade', 'RDAsistenteSYSRandrade_123', 0, 0, 1, 0

select * from tbl_usuario

drop table tbl_usuario

create procedure sp_register_user (@nombre varchar(50), @apellidos varchar(120), @telefono varchar(15), @correo varchar(150), @url_img varchar(255), 
@usr varchar(40), @psw varchar(20), @facebook char(1), @google char(1), @mail char(1), @ret int output)
as
begin transaction
declare @countRegisterBef int;
declare @countRegisterAft int;
declare @countUserBef int;
declare @countUserAft int;
declare @idPersona int;
declare @idUsuario int;
set @countRegisterBef = (select COUNT(*) from tbl_persona);
set @countUserBef = (select COUNT(*) from tbl_persona);
if(@countRegisterBef is null)
begin
set @countRegisterBef = 0;
end
if(@countUserBef is null)
begin
set @countUserBef = 0;
end
insert into tbl_persona values(@nombre, @apellidos, @telefono, @correo, @url_img);
set @countRegisterAft = (select COUNT(*) from tbl_persona);
if(@countRegisterAft is null)
begin
set @ret = -1;
rollback transaction;
end
else
begin
if(@countRegisterBef<@countRegisterAft)
begin
set @idPersona = (select MAX(id) from tbl_persona);
if(@idPersona > 0 and @idPersona is not null)
begin
insert into tbl_usuario values(@idPersona, HASHBYTES('SHA2_256',@psw), @usr, @facebook, @google, @mail, HASHBYTES('SHA2_256','RDAsistenteSYS2018#$853'), 1);
set @countUserAft = (select COUNT(*) from tbl_persona)
if(@countUserBef<@countRegisterAft)
begin
set @idUsuario = (select MAX(id) from tbl_usuario);
if(@idUsuario>0 and @idUsuario is not null)
begin
set @ret = @idUsuario;
commit transaction;
end
else
begin
set @ret = -3;
rollback transaction;
end
end
else
begin
set @ret = -3;
rollback transaction;
end
end
else
begin
set @ret = -2;
rollback transaction;
end
end
else
begin
set @ret = 1;
rollback transaction;
end
end
go
