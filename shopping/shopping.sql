create table category(
id int not null AUTO_INCREMENT,
name varchar(30) not null,
description varchar(100) not null,

primary key(id)
);

create table product(
id int not null AUTO_INCREMENT,
name varchar(100) not null,
description varchar(200) not null,
price decimal(7,2),
category_id int not null,

primary key (id),
foreign key (category_id) references category(id)
);

create table t_order(
id bigint not null AUTO_INCREMENT,
order_number varchar(36) not null,

primary key (id)
);

create table order_line_item(
id bigint not null auto_increment,
sku_code varchar(36) not null,
price decimal(7,2) not null,
quantity int,
order_id bigint not null,

primary key (id),
foreign key (order_id) references t_order(id)   
);

create table inventry(
id bigint not null auto_increment,
sku_code varchar(36) not null,
quantity int not null,

primary key(id)
);

drop table order_line_item;
drop table product;

insert into category values(3, "clothing","ethnic and western clothing");

insert into inventry values(1, "1234567890",2);




