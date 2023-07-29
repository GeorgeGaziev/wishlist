--insert into person (birthday, created_on, firstname, lastname, updated_on) values ('2001-10-10 11:30:30', '2022-08-07 19:47:36.072253', 'David', 'Wassermann', '2022-08-07 19:47:36.072253');

insert into person (birthday, firstname, lastname, created_on, updated_on) values ('2002-10-10', 'Samantha', 'Connor', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into person (birthday, firstname, lastname, created_on, updated_on) values ('1950-01-02', 'Marc', 'Azimov', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into wish (description, comment, status, owner_id, created_on, updated_on) values ('Red bike', 'Preferably a hike one', 'NEW', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into wish (description, comment, status, owner_id, created_on, updated_on) values ('New notebook', 'At least 80 pages', 'TAKEN', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into wish (description, comment, status, owner_id, created_on, updated_on) values ('Green sweatshirt', 'From natural wool', 'FULFILLED', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

