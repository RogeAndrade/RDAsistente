alter table tbl_tareas
add fecha_inicio datetime not null default (GETDATE());

alter table tbl_tareas
add fecha_fecha_fin datetime not null default ('1970-01-01 00:00:00');


-- Store procedure ---

select * from tbl_tareas

create procedure sp_get_tareas(@idPersona int)
as
begin
declare @countTareas int;
select t.id, t.id_periodicidad, t.nombre_tarea, fecha_inicio, p.nombre, t.fecha_fecha_fin from tbl_tareas as t
inner join clt_periodicidad as p on p.id = t.id_periodicidad
where t.id_persona = @idPersona and (fecha_fecha_fin = '1970-01-01 00:00:00' or fecha_fecha_fin >= GETDATE());
end
