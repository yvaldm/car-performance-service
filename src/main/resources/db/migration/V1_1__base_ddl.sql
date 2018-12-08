create table track (

  id bigserial primary key,
  name text not null,
  description text not null,
  length numeric not null,
  unit text not null
);

create table car (

  id bigserial primary key,
  track_id bigint not null references  track,
  code text not null,
  transmission text not null,
  ai text not null,
  value numeric not null,
  unit text not null
);
