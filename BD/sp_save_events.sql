alter table tbl_eventos
add fecha_alta datetime not null default('1970-01-01 00:00:00');


create procedure sp_save_events(@idPersona int, @fecha datetime, @anticipacion float, @notificacion char(1), @nombre varchar(70), @prioridad tinyint, @fuente tinyint, @tipo tinyint, @fechaAlta datetime, @ret int output)
as
begin
declare @countEvents int;
set @countEvents = (select count(*) from tbl_eventos);
declare @transactiosActive int;
set @transactiosActive = (SELECT @@trancount);
if(@transactiosActive > 0)
begin
save transaction saveEvents
end
else
begin
begin transaction saveEvents
end
insert into tbl_eventos(id_persona, fecha, anticipacion_aviso, envio_invitacion, nombre, id_prioridad_evento, id_fuente_evento, id_tipo_evento, fecha_alta) values(@idPersona, @fecha, @anticipacion, @notificacion, @nombre, @prioridad, @fuente, @tipo, @fechaAlta);
declare @countEventsFin int;
set @countEvents = (select count(*) from tbl_eventos);
if(@countEvents<@countEventsFin)
begin
--commit transaction saveEvents;
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