create table item (
id integer not null generated always as identity (start with 1, increment by 1),
nombre varchar(64) not null,
primary key(id),
unique(nombre)
);


create table caja (
    id integer not null generated always as identity (start with 1, increment by 1),
    item integer not null,
    cantidad integer not null,
    primary key(id),
    unique (item,cantidad),
    check (cantidad >= 0),
    constraint fk_caja_item foreign key (item) references item(id) on delete cascade
);

create table movimiento (
    id integer not null generated always as identity (start with 1, increment by 1),
    caja integer not null,
    hora timestamp not null,
    cantidad integer not null,
    check( cantidad <> 0),
    primary key(id),
    constraint fk_movimiento_caja foreign key (caja) references caja(id) on delete restrict
);

create view stock (itemId,itemNombre,cajaId,cajaCantidad, stock) as
select i.id itemId,i.nombre itemNombre,c.id cajaId,c.cantidad cajaCantidad,sum(m.cantidad) stock from item i
left join caja c on i.id = c.item
left join movimiento m on c.id = m.caja
group by i.id,i.nombre,c.id,c.cantidad



