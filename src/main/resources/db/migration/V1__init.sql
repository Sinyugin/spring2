create table products
(
    id bigserial primary key,
    title        varchar(255),
    price        int
);

create table PRODUCT_IN_CART
(
    id bigserial primary key,
    title        varchar(255),
    price        int,
    quantity     int
);

insert into products (title , price) values
('Milk', 80), ('Bread', 25), ('Cheese', 300);

create table users
(
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null
--    email      varchar(50) not null,
--    created_at timestamp default current_timestamp,
--    updated_at timestamp default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null
--    created_at timestamp default current_timestamp,
--    updated_at timestamp default current_timestamp
);

create table users_roles
(
    user_id    bigserial not null references users(id),
    role_id    bigserial not null references users(id),
--    created_at timestamp default current_timestamp,
--    updated_at timestamp default current_timestamp,
    primary key (user_id, role_id)
);

insert into roles (name)
values('ROLE_USER'),
      ('ROLE_ADMIN');

insert into users (username, password)
values('bob', '12345'),
      ('jon', 'dghhgkhvkuhbkrhtgkurotjgio5uy856teiefvkh');

insert into users_roles (user_id, role_id)
values(1, 1),
      (2, 2);