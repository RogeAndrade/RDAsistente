create procedure sp_login_user(@usr varchar(40), @pass varchar(40), @type char(1))
as
begin
if (@type = 1)
begin
select u.id, u.id_persona, u.usr, u.recibe_notificaciones, u.id_tipo_usuario, p.nombre, p.apellidos, p.invitame_cafe, p.correo, p.nombre, p.telefono, p.url_img from tbl_usuario as u
inner join tbl_persona as p on p.id= u.id_persona where (u.usr = @usr or p.correo = @usr) and u.mail = 1 and u.activo = 1 and (u.psw = SUBSTRING(master.dbo.fn_varbintohexstr(HashBytes('SHA1', @pass)), 3, 32) or u.alter_pass = SUBSTRING(master.dbo.fn_varbintohexstr(HashBytes('SHA1', @pass)), 3, 32));
end
else if(@type = 2)
begin
select u.id, u.id_persona, u.usr, u.recibe_notificaciones, u.id_tipo_usuario, p.nombre, p.apellidos, p.invitame_cafe, p.correo, p.nombre, p.telefono, p.url_img from tbl_usuario as u
inner join tbl_persona as p on p.id= u.id_persona where (u.usr = @usr or p.correo = @usr) and u.facebook = 1 and u.activo = 1 and (u.psw = SUBSTRING(master.dbo.fn_varbintohexstr(HashBytes('SHA1', @pass)), 3, 32) or u.alter_pass = SUBSTRING(master.dbo.fn_varbintohexstr(HashBytes('SHA1', @pass)), 3, 32));
end
else if(@type = 3)
begin
select u.id, u.id_persona, u.usr, u.recibe_notificaciones, u.id_tipo_usuario, p.nombre, p.apellidos, p.invitame_cafe, p.correo, p.nombre, p.telefono, p.url_img from tbl_usuario as u
inner join tbl_persona as p on p.id= u.id_persona where (u.usr = @usr or p.correo = @usr) and u.google = 1 and u.activo = 1 and (u.psw = SUBSTRING(master.dbo.fn_varbintohexstr(HashBytes('SHA1', @pass)), 3, 32) or u.alter_pass = SUBSTRING(master.dbo.fn_varbintohexstr(HashBytes('SHA1', @pass)), 3, 32));
end
end
