INSERT INTO user_entity (name, surname, email, password, birthdate) VALUES
                       ('Adam','Admin','admin@gmail.com','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','2000-10-19'),
                       ('Marta','Klient','client@gmail.com','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','2002-02-20');

INSERT INTO role_entity (name) VALUES ('ROLE_ADMIN'),('ROLE_USER');
INSERT INTO user_x_roles VALUES (1,1),(2,2);


INSERT INTO location_entity (continent, country, city,address)
VALUES
    ('EUROPA','Polska','Wrocław','addresWro'),
    ('EUROPA','Polska','Kraków','addres'),
    ('EUROPA','Hiszpania','Malaga','addres'),
    ('AFRYKA','Egipt','Hurghada','addres'),
    ('AZJA','Japonia','Tokio','addres'),
    ('AMERYKA_PÓŁNOCNA','USA','New York','addres'),
    ('AMERYKA_POLUDNIOWA','Peru','Lima','addres'),
    ('AUSTRALIA','Australia','Sydney','addres'),
    ('AUSTRALIA','Australia','Brisbane','addres');

INSERT INTO airport_entity (code, name, location_id)
VALUES
    ('WRO','Mikołaja Kopernika',1),
    ('KRK','Jana Pawła II, Balice',2),
    ('AGP','Pablo Ruiz Picasso',3),
    ('HRG','Hurghada',4),
    ('HDN','Tokyo Haneda International',5),
    ('JRB','Downtown Manhattan H/p',6),
    ('LIM','Jorge Chavez International',7),
    ('SWZ','Sydney West',8);

INSERT INTO hotel_entity (name, description, stars,location_id)
VALUES

    ('Hotel Vincci Málaga',' opisMálaga',4,3),
    ('Hurghada HOTEL','opisHurghada',3,4),
    ('Tokio hotel','opisTokio',5,5),
    ('New York hotel','opisYork',3,6),
    ('Lima hotel','opisLima',2,7),
    ('Sydney hotel','opisSydney',4,8);


INSERT INTO standard_entity (standard_type)
VALUES
    ('OB'),
    ('BB'),
    ('HB'),
    ('FB'),
    ('AI');

INSERT INTO trip_entity (start_date,end_date,max_adult_number,max_child_number,airport_from_code,airport_to_code,hotel_id)
VALUES
    ('2023-12-14','2023-12-16',20,10,'WRO','AGP',1),
    ('2023-12-16','2023-12-18',9,5,'KRK','HRG',2);
--     ('2023-12-20','2023-12-22',25,5,'WRO','AGP',1);



INSERT INTO price_entity (price_per_day,flight_price)
VALUES
    (4000,500),
    (7000,1000),
    (3000,400);

INSERT INTO purchase_entity (adult_number,child_number)
VALUES

    (3,1),
    (3,1);




--
-- INSERT INTO location_entity (continent, country, city,address)
-- VALUES
--     ('EUROPA','Polska','Wrocław','addresWro'),
--     ('EUROPA','Polska','Kraków','addres'),
--
--     ('EUROPA','Polska','Warszawa','addres'),
--     ('EUROPA','Polska','Gdańsk','addres'),
--     ('EUROPA','Włochy','Mediolan','addres'),
--     ('EUROPA','Hiszpania','Malaga','addres'),
--     ('EUROPA','Portugalia','Lizbona','addres'),
--     ('AFRYKA','Egipt','Hurghada','addres'),
--     ('AFRYKA','Tanzania','Zanzibar','addres'),
--     ('AZJA','Tajlandia','Bangkok','addres'),
--     ('AZJA','Japonia','Tokio','addres'),
--     ('AMERYKA_PÓŁNOCNA','USA','New York','addres'),
--     ('AMERYKA_PÓŁNOCNA','USA','Los Angeles','addres'),
--     ('AMERYKA_POLUDNIOWA','Meksyk','Acapulco','addres'),
--     ('AMERYKA_POLUDNIOWA','Peru','Lima','addres'),
--     ('AUSTRALIA','Australia','Melbourne','addres'),
--     ('AUSTRALIA','Australia','Sydney','addres'),
--     ('AUSTRALIA','Australia','Brisbane','addres');
--
-- INSERT INTO airport_entity (code, name, location_id)
-- VALUES
--     ('WRO','Mikołaja Kopernika',1),
--     ('KRK','Jana Pawła II, Balice',2),
--     ('WMI','Modlin',3),
--     ('GDN','Lecha Wałęsy, Rębiechowo',4),
--     ('MXP','Malpensa',5),
--     ('AGP','Pablo Ruiz Picasso',6),
--     ('ZYD','LISBON TP',7),
--     ('HRG','Hurghada',8),
--     ('ZNZ','Kisauni',9),
--     ('BKK','Suvarnabhumi International',10),
--     ('HDN','Tokyo Haneda International  ',11),
--     ('JRB','Downtown Manhattan H/p',12),
--     ('LAX','LOS ANGELES International',13),
--     ('ACA','General Juan N. Alvarez International',14),
--     ('LIM','Jorge Chavez International',15),
--     ('MEL','Tullamarine',16),
--     ('SWZ','Sydney West',17);
--
-- INSERT INTO hotel_entity (name, description, stars,location_id)
-- VALUES
--
--     ('Leonardo Hotel Milan City Center','desc',5,5),
--     ('Hotel Vincci Málaga',' opisMálaga',4,6),
--     ('Lizbona Hotel','opisLizbona',3,7),
--     ('Hurghada HOTEL','opisHurghada',3,8),
--     ('hotel Zanzibar','opis',3,9),
--     ('Bangkok hotel','opisBangkok',3,10),
--     ('Tokio hotel','opisTokio',5,11),
--     ('New York hotel','opisYork',3,12),
--     ('Los Angeles hotel','opisLos Angeles',4,13),
--     ('Acapulco hotel','opisAcapulco',5,14),
--     ('Lima hotel','opisLima',2,15),
--     ('Melbourne hotel','opisMelbourne',5,16),
--     ('Sydney hotel','opisSydney',4,17);
--
--
-- INSERT INTO standard_entity (standard_type)
-- VALUES
--     ('OB'),
--     ('BB'),
--     ('HB'),
--     ('FB'),
--     ('AI');
--
-- INSERT INTO trip_entity (start_date,end_date,max_adult_number,max_child_number,airport_from_code,airport_to_code,hotel_id)
-- VALUES
--     ('2024-06-25','2024-07-05',20,10,'WRO','WRO',5),
--     ('2024-07-25','2024-08-05',25,5,null,null,null);
--
--
--
-- INSERT INTO price_entity (price_per_day,flight_price)
-- VALUES
--     (4000,500),
--     (7000,600);
--
--
--
--
--
