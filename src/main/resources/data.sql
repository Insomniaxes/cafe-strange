INSERT INTO `cafe-strange`.user (birthday, email, first_name, gender, join_date, last_name, nationality, password, username, picture_media_id) VALUES ('1978-02-04', 'stef@sitefun.be', 'Stefan', 0, '2018-01-09', 'Meynen', null, 't', 'Stef', null);
INSERT INTO `cafe-strange`.user (birthday, email, first_name, gender, join_date, last_name, nationality, password, username, picture_media_id) VALUES ('1970-06-18', 'blubber@sitefun.be', 'Marie', 1, '2018-01-09', 'Anders', null, 't', 'Elize', null);
INSERT INTO `cafe-strange`.user (birthday, email, first_name, gender, join_date, last_name, nationality, password, username, picture_media_id) VALUES ('1985-11-18', 'blabber@sitefun.be', 'Jef', 2, '2018-01-09', 'Bastiaens', null, 't', 'Erika', null);
INSERT INTO `cafe-strange`.role (role) VALUES (0);
INSERT INTO `cafe-strange`.role (role) VALUES (1);
INSERT INTO `cafe-strange`.role (role) VALUES (2);
INSERT INTO `cafe-strange`.user_roles (user_user_id, roles_role_id) VALUES (1, 1);
INSERT INTO `cafe-strange`.user_roles (user_user_id, roles_role_id) VALUES (2, 3);
INSERT INTO `cafe-strange`.user_roles (user_user_id, roles_role_id) VALUES (3, 2);
INSERT INTO `cafe-strange`.opening_hours (weekday, closed, open) VALUES (0, null, null);
INSERT INTO `cafe-strange`.opening_hours (weekday, closed, open) VALUES (1, '02:00', '19:00');
INSERT INTO `cafe-strange`.opening_hours (weekday, closed, open) VALUES (2, '02:00', '19:00');
INSERT INTO `cafe-strange`.opening_hours (weekday, closed, open) VALUES (3, '02:00', '19:00');
INSERT INTO `cafe-strange`.opening_hours (weekday, closed, open) VALUES (4, '02:00', '19:00');
INSERT INTO `cafe-strange`.opening_hours (weekday, closed, open) VALUES (5, '02:00', '19:00');
INSERT INTO `cafe-strange`.opening_hours (weekday, closed, open) VALUES (6, '02:00', '19:00');
INSERT INTO `cafe-strange`.general_info (extended_info, intro, title) VALUES ('Een hele hoop uitleg, want als hier geen 250 characters staan, dan heeft mijn functie om deze tekst te splitsen helemaal geen nut. dat zou enorm zonde zijn van het werk he. Hopelijk zit ik er al lang aan, want anders moet ik hier later terug wat extra tekst komen typen en ik heb daar altijd zo weinig inspiratie voor he.', 'Een beetje uitleg', 'Welkom ofzo');
INSERT INTO `cafe-strange`.category (category) VALUES ('Flyer');
INSERT INTO `cafe-strange`.event (date, description, summary, title, picture_media_id) VALUES ('2017-12-31', 'Het nieuwjaarsfeest gaat plaats vinden. Dit event is ondertussel al verleden.', 'Feesten geblazen', 'Nieuwjaar 2018!', null);
INSERT INTO `cafe-strange`.event (date, description, summary, title, picture_media_id) VALUES ('2030-12-31', 'Er gaat weer een nieuwjaarsfeest plaats vinden. Ik moet uiteraard ook een aankomend event hebben he.', 'Opnieuw feesten geblazen', 'Nieuwjaar 2031!', null);