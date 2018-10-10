create procedure sp_activate_user(@idUser int, @ret int output)
as 
begin
declare @transactiosActive int;
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
save transaction activateUser
end
else
begin
begin transaction activateUser
end
declare @validateUser int;
set @validateUser = (select count(*) from tbl_usuario where activo = 0 and id = @idUser);
if(@validateUser > 0)
begin
update tbl_usuario set activo = 1 where id = @idUser;
declare @validateActivo int;
set @validateActivo = (select count(*) from tbl_usuario where activo = 1 and id = @idUser);
if(@validateActivo > 0)
begin
set @ret = 1;
commit transaction activateUser;
return;
end
else
begin
set @ret = -2;
rollback transaction activateUser;
return;
end
end
else
begin
set @ret = -1;
rollback transaction activateUser;
return;
end
end