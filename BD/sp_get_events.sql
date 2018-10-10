

create procedure sp_get_events(@idPersona int)
as
begin
select e.id, e.fecha, e.envio_invitacion, e.nombre, e.id_prioridad_evento, e.id_fuente_evento, e.anticipacion_aviso, e.id_tipo_evento, e.fecha_alta from tbl_eventos as e
inner join clt_prioridad_evento as pe on pe.id=e.id_prioridad_evento inner join clt_fuente_evento as fe on fe.id = e.id_fuente_evento
inner join clt_tipo_evento as te on te.id=e.id_tipo_evento
where e.id_persona = @idPersona and e.fecha <= GETDATE();
end