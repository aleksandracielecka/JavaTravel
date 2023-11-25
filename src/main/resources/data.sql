INSERT INTO user_entity (name, surname, email, password, birthdate) VALUES
                       ('Adam','Admin','admin@gmail.com','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','2000-10-19'),
                       ('Marta','Klient','client@gmail.com','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','2002-02-20');

INSERT INTO role_entity (name) VALUES ('ROLE_ADMIN'),('ROLE_USER');
INSERT INTO user_x_roles VALUES (1,1),(2,2);