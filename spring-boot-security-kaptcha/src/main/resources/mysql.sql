create database if not exists spring_boot default character set utf8 collate utf8_general_ci;

use spring_boot;

create table if not exists t_users(
  id integer auto_increment primary key,
  username varchar(20),
  password varchar(100),
  role varchar(20),
  token varchar(100)
)default charset=utf8;


create table if not exists persistent_logins(
  username varchar(64) not null,
  series varchar(64) primary key,
  token varchar(64) not null,
  last_used timestamp not null
)default charset=utf8;