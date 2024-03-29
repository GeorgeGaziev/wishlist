drop table if exists wish cascade;
drop table if exists person cascade;

create table person (
 id serial not null,
 birthday date not null,
 created_on timestamp(6),
 firstname varchar(50) not null,
 lastname varchar(50) not null,
 updated_on timestamp(6),
 primary key (id));

create table wish (
 id serial not null,
 owner_id bigint,
 comment varchar(255) not null,
 description varchar(50) not null,
 status varchar(20),
 created_on timestamp(6),
 updated_on timestamp(6),
 primary key (id));