insert into user values(null,'Jenny');
insert into user values(null,'Kiki');
insert into user values(null,'Kevin');
insert into user values(null,'Yuki');
insert into user values(null,'Sebastian');
insert into user values(null,'Alex');

insert into message(id,user_id,username,content,create_timestamp) values (null,1,'Jenny','Recently I am reading Harry Potter.',CURRENT_TIMESTAMP);
insert into message(id,user_id,username,content,create_timestamp) values (null,2,'Kiki','I miss my dog!',CURRENT_TIMESTAMP);
insert into message(id,user_id,username,content,create_timestamp) values (null,3,'Kevin','Google assistant is really cool',CURRENT_TIMESTAMP);
insert into message(id,user_id,username,content,create_timestamp) values (null,4,'Yuki','I enjoy watching movie.',CURRENT_TIMESTAMP);
insert into message(id,user_id,username,content,create_timestamp) values (null,5,'Sebastian','I am trying to losing weight these days.',CURRENT_TIMESTAMP);
insert into message(id,user_id,username,content,create_timestamp) values (null,1,'Jenny','I am reading a book.',CURRENT_TIMESTAMP);
insert into message(id,user_id,username,content,create_timestamp) values (null,3,'Kevin','Lights will guide you home.',CURRENT_TIMESTAMP);
insert into message(id,user_id,username,content,create_timestamp) values (null,2,'Kiki','We are the champion!',CURRENT_TIMESTAMP);

insert into follow(follower_id,friend_id,create_timestamp) values(1,2,CURRENT_TIMESTAMP);
insert into follow(follower_id,friend_id,create_timestamp) values(2,1,CURRENT_TIMESTAMP);
insert into follow(follower_id,friend_id,create_timestamp) values(3,2,CURRENT_TIMESTAMP);
insert into follow(follower_id,friend_id,create_timestamp) values(4,2,CURRENT_TIMESTAMP);