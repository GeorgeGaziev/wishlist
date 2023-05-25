drop table if exists person cascade;
drop table if exists wish cascade;

create table person (
 id bigserial not null,
 birthday date not null,
 created_on timestamp(6),
 firstname varchar(50) not null,
 lastname varchar(50) not null,
 updated_on timestamp(6),
 primary key (id));

create table wish (
 id bigserial not null,
 comment varchar(50) not null,
 created_on timestamp(6),
 description varchar(50) not null,
 status varchar(255),
 updated_on timestamp(6),
 owner_id bigint,
 primary key (id));