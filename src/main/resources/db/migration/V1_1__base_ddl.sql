create table track (

  id serial primary key,
  name text not null,
  description text not null,
  length numeric not null,
  unit text not null
);

create table car (

  id serial primary key,
  code text not null,
  transmission text not null,
  ai text not null,
  value numeric not null,
  unit text not null
);
