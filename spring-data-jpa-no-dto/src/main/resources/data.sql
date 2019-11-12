insert into instructor(id, first_name, last_name, email) values(1, 'Fulano', 'Caetano', 'fc@gmail.com');
insert into instructor(id, first_name, last_name, email) values(2, 'Ciclano', 'Pereira', 'cp@gmail.com');
insert into instructor(id, first_name, last_name, email) values(3, 'Beltrano', 'Normando', 'bn@gmail.com');

insert into user(id, user_name, password, enabled) values(1, 'fulano', 'fulano', true);
insert into user(id, user_name, password, enabled) values(2, 'ciclano', 'ciclano', true);
insert into user(id, user_name, password, enabled) values(3, 'beltrano', 'beltrano', false);

insert into authority(id, user_name, authority) values(1, 'fulano', 'ROLE_USER');
insert into authority(id, user_name, authority) values(2, 'ciclano', 'ROLE_USER');
insert into authority(id, user_name, authority) values(3, 'beltrano', 'ROLE_ADMIN');
