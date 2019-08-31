create table user(
  id varchar(100),
  username varchar(100),
  password varchar(100),
  password_expired varchar(100),
  role varchar(100),
  create_time timestamp  default current_timestamp
);