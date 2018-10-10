create procedure sp_save_tarea (@periodicidad tinyint, @nombre varchar(50), @idPersona int, @ret int output)
as
begin
declare @countTask int;
set @countTask = (select count(*) from tbl_tareas);
declare @transactiosActive int;
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
save transaction saveTask
end
else
begin
begin transaction saveTask
end
insert into tbl_tareas(id_periodicidad, nombre_tarea, id_persona) values(@periodicidad, @nombre, @idPersona);
declare @countTaskFin int;
set @countTaskFin = (select count(*) from tbl_tareas);
if(@countTask<@countTaskFin)
begin
commit transaction saveTask;
set @ret = 1;
return;
end
else
begin
rollback transaction saveTask;
set @ret = -1;
return;
end
end

select * from tbl_tareas

insert into clt_periodicidad values('Semanal', 'Que se debería ejecutar cada semana')

declare @ret int;
exec sp_save_tarea 1, 'Correr', 1, @ret output;
select @ret;

