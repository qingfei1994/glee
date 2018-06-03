drop table user if exists;
drop table message if exists;
drop table follow if exists;
create table user
(
    id bigint auto_increment primary key,
    username varchar(255) not null
);
create table message
(
      id bigint auto_increment primary key,
      user_id bigint not null,
      username varchar(255) not null,
      content varchar(140) not null,
      create_timestamp timestamp not null
);
create table follow
(
    follower_id bigint not null,
    friend_id bigint not null,
    create_timestamp timestamp not null
);