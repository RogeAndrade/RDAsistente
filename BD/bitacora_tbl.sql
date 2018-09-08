create table tbl_bitacora(
	id bigint not null primary key identity(1, 1),
	mensaje text not null,
	fecha datetime not null,
	id_usuario int not null,
	foreign key (id_usuario) references tbl_usuario(id)
);
