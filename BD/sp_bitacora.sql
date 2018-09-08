create procedure sp_register_bitacora(@mensaje text, @id_usuario int, @ret int output)
as
begin
declare @countBitacora int;
declare @countBitacoraAfter int;
declare @validateUser int;
declare @transactiosActive int;
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
save transaction addBitacora
end
else
begin
begin transaction addBitacora
end
set @countBitacora =(select count(*) from tbl_bitacora);
set @validateUser = (SELECT count(*) FROM tbl_usuario WHERE id = @id_usuario);
if(@validateUser>0)
begin
insert into tbl_bitacora values(@mensaje, GETDATE(), @id_usuario);
set @countBitacoraAfter = (select count(*) from tbl_bitacora);
if(@countBitacora<@countBitacoraAfter)
begin
set @ret = 1;
return;
end
else
begin
set @ret = -1;
rollback transaction addBitacora;
return;
end
end
else
begin
set @ret = -1;
rollback transaction addBitacora;
return;
end
end