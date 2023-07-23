create table brand (
    id integer not null,
    name varchar(255),
    primary key (id)
) engine=InnoDB;

create table brand_seq (
    next_val bigint
) engine=InnoDB;

insert into brand_seq values ( 1 );

create table customer (
    id integer not null,
    birth_date varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
) engine=InnoDB;

create table customer_seq (
    next_val bigint
) engine=InnoDB;

insert into customer_seq values ( 1 );

create table leasing_contract (
    contract_number integer not null,
    monthly_rate float(53),
    customer integer,
    vehicle_id integer,
    primary key (contract_number)
) engine=InnoDB;

create table model (
    id integer not null,
    name varchar(255),
    brand integer,
    primary key (id)
) engine=InnoDB;

create table model_seq (
    next_val bigint
) engine=InnoDB;

insert into model_seq values ( 1 );

create table vehicle (
    id integer not null,
    brand varchar(255),
    model varchar(255),
    price float(53),
    production_year varchar(255),
    vin varchar(255),
    primary key (id)
) engine=InnoDB;

create table vehicle_seq (
    next_val bigint
) engine=InnoDB;

insert into vehicle_seq values ( 1 );

alter table leasing_contract
   add constraint FKa02mhx2nxbgk0kppfrouygq58
   foreign key (customer)
   references customer (id);

alter table leasing_contract
   add constraint FKqpkf9hkk4ps9mg91ifuc16qni
   foreign key (vehicle_id)
   references vehicle (id);

alter table model
   add constraint FKk4e5pld68erlnvdqyq0bpyg6a
   foreign key (brand)
   references brand (id);