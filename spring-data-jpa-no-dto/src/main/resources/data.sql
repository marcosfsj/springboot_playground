insert into instructor(id, first_name, last_name, email, age) values(1, 'Fulano', 'Caetano', 'fc@gmail.com', 20);
insert into instructor(id, first_name, last_name, email, age) values(2, 'Ciclano', 'Pereira', 'cp@gmail.com', 30);
insert into instructor(id, first_name, last_name, email, age) values(3, 'Beltrano', 'Normando', 'bn@gmail.com', 40);

insert into user(id, user_name, password, enabled) values(1, 'fulano', 'fulano', true);
insert into user(id, user_name, password, enabled) values(2, 'ciclano', 'ciclano', true);
insert into user(id, user_name, password, enabled) values(3, 'beltrano', 'beltrano', false);

insert into authority(id, user_name, authority) values(1, 'fulano', 'ROLE_USER');
insert into authority(id, user_name, authority) values(2, 'ciclano', 'ROLE_USER');
insert into authority(id, user_name, authority) values(3, 'beltrano', 'ROLE_ADMIN');
