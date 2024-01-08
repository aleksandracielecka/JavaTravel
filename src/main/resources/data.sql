INSERT INTO user_entity (name, surname, email, password, birthdate) VALUES
                       ('Adam','Admin','admin@gmail.com','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','2000-10-19'),
                       ('Marta','Klient','client@gmail.com','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','2002-02-20');

INSERT INTO role_entity (name) VALUES ('ROLE_ADMIN'),('ROLE_USER');
INSERT INTO user_x_roles VALUES (1,1),(2,2);


INSERT INTO location_entity (continent, country, city,address)
VALUES
    ('EUROPA','Polska','Wrocław','adres'),
    ('EUROPA','Polska','Kraków','adres'),
    ('EUROPA','Polska','Warszawa','adres'),
    ('EUROPA','Polska','Gdańsk','adres'),
    ('EUROPA','Włochy','Mediolan','adres'),
    ('EUROPA','Hiszpania','Malaga','adres'),
    ('EUROPA','Portugalia','Lizbona','adres'),
    ('AFRYKA','Egipt','Hurghada','adres'),
    ('AFRYKA','Tanzania','Zanzibar','adres'),
    ('AZJA','Tajlandia','Bangkok','adres'),
    ('AZJA','Japonia','Tokio','adres'),
    ('AMERYKA_PÓŁNOCNA','USA','New York','adres'),
    ('AMERYKA_PÓŁNOCNA','USA','Los Angeles','adres'),
    ('AMERYKA_POLUDNIOWA','Meksyk','Acapulco','adres'),
    ('AMERYKA_POLUDNIOWA','Peru','Lima','adres'),
    ('AUSTRALIA','Australia','Melbourne','adres'),
    ('AUSTRALIA','Australia','Sydney','adres');
--     ('AUSTRALIA','Australia','Brisbane','addres');

INSERT INTO airport_entity (code, name, location_id)
VALUES
    ('WRO','Mikołaja Kopernika',1),
    ('KRK','Jana Pawła II, Balice',2),
    ('WMI','Modlin',3),
    ('GDN','Lecha Wałęsy, Rębiechowo',4),
    ('MXP','Malpensa',5),
    ('AGP','Pablo Ruiz Picasso',6),
    ('ZYD','LISBON TP',7),
    ('HRG','Hurghada',8),
    ('ZNZ','Kisauni',9),
    ('BKK','Suvarnabhumi International',10),
    ('HDN','Tokyo Haneda International  ',11),
    ('JRB','Downtown Manhattan H/p',12),
    ('LAX','LOS ANGELES International',13),
    ('ACA','General Juan N. Alvarez International',14),
    ('LIM','Jorge Chavez International',15),
    ('MEL','Tullamarine',16),
    ('SWZ','Sydney West',17);
INSERT INTO hotel_entity (name, description, stars,location_id)
VALUES

    ('Leonardo Hotel Milan City Center','Hotel znajduje się w centrum Mediolanu. Świetna lokalizacja do głowych atrakcji miasta. Duże i czyste pokoje, smaczne posiłki.',5,5),
    ('Hotel Vincci Málaga','Hotel znajduje się przy plaży, posiada 3 baseny w tym jeden dla dzieci. Pokoje z widokiem na morze.',4,6),
    ('Lizbona Hotel','Hotel znajduje się przy oceanie, posiada 2 baseny w tym jeden dla dzieci. Pokoje z widokiem.',3,7),
    ('Hurghada HOTEL','Hotel idealny do zimowego wypoczynku. Wspaniałe atrakcje dla dzieci - animacje i plac zabaw.',3,8),
    ('Zanzibar hotel','Hotel znajduje się przy plaży, posiada 4 baseny oraz aquapark. Bardzo dobre wyżywienie oraz szeroka oferta  lokalnych alkoholi.',3,9),
    ('Bangkok hotel','Hotel w centrum miasta, idealny nocleg do zwiedzania.',3,10),
    ('Tokio hotel','Hotel w świetnej lokalizacj, pokoje dla palących, osobna łazienka.',5,11),
    ('New York hotel','Hotel z widokiem na Central Park, wspaniałe wyżywienie, idealna lokalizacja.',3,12),
    ('Los Angeles hotel','Hotel idealny na wypoczynek w "mieście aniołów", bardzo dobre posiłki, duże pokoje z TV i wi-fi.',4,13),
    ('Acapulco hotel','Hotel idealny dla turystów chcących aktywnie wypoczywać, prywatna plaża, dostęp do leżaków i parasoli bez limitu.',5,14),
    ('Lima hotel','Hotel z wspaniałym widokiem, w cenie wycieczki do pobliskich atrakcji turystycznych.',2,15),
    ('Melbourne hotel','Hotel w ponliżu oceanu, idealnu dla serferów i plażowiczów.',5,16),
    ('Sydney hotel','Hotel w pobliżu "Opera House", wpaniałe warunki noclegowe, bardzo dobre wyżywienie.',4,17);


INSERT INTO price_entity (price_per_day,flight_price,standard_type)
VALUES
    (100,500,'OB'),
    (200,600,'OB'),
    (300,500,'OB'),
    (400,550,'OB'),
    (500,500,'OB'),
    (600,200,'OB'),
    (700,4000,'OB'),
    (1000,2000,'OB');

INSERT INTO trip_entity (start_date,end_date,max_adult_number,max_child_number,airport_from_code,airport_to_code,hotel_id,price_id)
VALUES
    ('2023-01-05','2023-01-07',20,10,'WRO','AGP',2,1),
    ('2023-12-16','2023-12-18',90,50,'KRK','HRG',4,2),
    ('2023-12-14','2023-12-20',45,55,'GDN','SWZ',13,7),
    ('2023-12-15','2023-12-31',100,99,'WMI','ZNZ',5,8);




