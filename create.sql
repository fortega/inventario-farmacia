create table item (
id integer not null generated always as identity (start with 1, increment by 1),
nombre varchar(64) not null,
primary key(id),
unique(nombre)
);

insert into item (nombre) values ('Atenolol 50mg');
insert into item (nombre) values ('Cardioplus D 20/12.5');
insert into item (nombre) values ('Glafornil XR 1000mg');

create table caja (
    id integer not null generated always as identity (start with 1, increment by 1),
    item integer not null,
    cantidad integer not null,
    primary key(id),
    unique (item,cantidad),
    check (cantidad >= 0),
    constraint fk_caja_item foreign key (item) references item(id) on delete cascade
);

insert into caja (item,cantidad) values (1,1);
insert into caja (item,cantidad) values (1,25);
insert into caja (item,cantidad) values (1,100);

insert into caja (item,cantidad) values (2,1);
insert into caja (item,cantidad) values (2,10);
insert into caja (item,cantidad) values (2,25);

insert into caja (item,cantidad) values (3,1);
insert into caja (item,cantidad) values (3,15);
insert into caja (item,cantidad) values (3,50);


create table movimiento (
    id integer not null generated always as identity (start with 1, increment by 1),
    caja integer not null,
    hora timestamp not null,
    cantidad integer not null,
    check( cantidad <> 0),
    primary key(id),
    constraint fk_movimiento_caja foreign key (caja) references caja(id) on delete restrict
);

create view stock as
select i.nombre as item,sum(c.cantidad*m.cantidad) as stock from item i
left join caja c on c.item = i.id
left join movimiento m on m.caja = c.id
where i.nulo = 0 and c.nulo = 0 and m.nulo = 0
group by i.nombre
order by i.nombre;



