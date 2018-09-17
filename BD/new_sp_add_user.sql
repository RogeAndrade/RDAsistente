USE [asistente]
GO
/****** Object:  StoredProcedure [dbo].[sp_register_user]    Script Date: 16/09/2018 12:56:28 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[sp_register_user] (@nombre varchar(50), @apellidos varchar(120), @telefono varchar(15), @correo varchar(150), @url_img varchar(255), 
@usr varchar(40), @psw varchar(20), @facebook char(1), @google char(1), @mail char(1), @ret int output)
as
begin
declare @transactiosActive int;
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
save transaction addUser
end
else
begin
begin transaction addUser
end
declare @valUser tinyint;
set @valUser = (select COUNT(*) from tbl_usuario where usr = @usr);
if(@valUser>0)
begin
set @ret = -4;
rollback transaction addUser;
return;
end
declare @valPhone tinyint;
set @valPhone = (select COUNT(*) from tbl_persona where telefono = @telefono);
if(@valPhone>0)
begin
set @ret = -6;
rollback transaction addUser;
return;
end
declare @valCorreo tinyint;
set @valCorreo = (select COUNT(*) from tbl_persona where correo = @correo);
if(@valCorreo>0)
begin
set @ret = -5;
rollback transaction addUser;
return;
end
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
insert into tbl_persona (nombre, apellidos, telefono, correo, url_img) values(@nombre, @apellidos, @telefono, @correo, @url_img);
set @countRegisterAft = (select COUNT(*) from tbl_persona);
if(@countRegisterAft is null)
begin
set @ret = -1;
rollback transaction addUser;
return;
end
else
begin
if(@countRegisterBef<@countRegisterAft)
begin
set @idPersona = (select MAX(id) from tbl_persona);
if(@idPersona is not null and @idPersona > 0)
begin
insert into tbl_usuario(id_persona, psw, usr, facebook, google, mail, alter_pass, recibe_notificaciones, activo) values(@idPersona, HASHBYTES('SHA1',@psw), @usr, @facebook, @google, @mail, HASHBYTES('SHA1','RDAsistenteSYS2018#$853'), 1, 1);
set @countUserAft = (select COUNT(*) from tbl_persona)
if(@countUserBef<@countRegisterAft)
begin
set @idUsuario = (select MAX(id) from tbl_usuario);
if(@idUsuario is not null and @idUsuario>0)
begin
set @ret = @idUsuario;
--set @transactiosActive = (SELECT @@trancount);
--if(@transactiosActive > 0)
--begin
--commit transaction addUser;
--end
return;
end
else
begin
set @ret = -3;
rollback transaction addUser;
return;
end
end
else
begin
set @ret = -3;
rollback transaction addUser;
return;
end
end
else
begin
set @ret = -2;
rollback transaction addUser;
return;
end
end
else
begin
set @ret = -1;
rollback transaction addUser;
return;
end
end
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
commit transaction addUser;
end
end