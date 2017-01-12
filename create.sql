create table item (
id integer not null generated always as identity (start with 1, increment by 1),
nombre varchar(64) not null,
nulo smallint default 0,
primary key(id),
unique(nombre)
);

create table caja (
    id integer not null generated always as identity (start with 1, increment by 1),
    item integer not null,
    cantidad integer not null,
    nulo smallint default 0,
    primary key(id),
    unique (item,cantidad),
    check (cantidad >= 0),
    constraint fk_caja_item foreign key (item) references item(id)
);

create table movimiento (
    id integer not null generated always as identity (start with 1, increment by 1),
    caja integer not null,
    hora timestamp not null,
    cantidad integer not null,
    nulo smallint default 0,
    check( cantidad <> 0),
    primary key(id),
    constraint fk_movimiento_caja foreign key (caja) references caja(id)
);

create view stock as
select i.nombre as item,sum(c.cantidad*m.cantidad) as stock from item i
left join caja c on c.item = i.id
left join movimiento m on m.caja = c.id
where i.nulo = 0 and c.nulo = 0 and m.nulo = 0
group by i.nombre
order by i.nombre

