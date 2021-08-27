PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE Sponsor(
contactFee double not null,
type char(255) not null, 
companyFullName char(255) not null,
clubID integer not null,
constraint FK_sponsor foreign key(companyFullName)
references company(fullName),
constraint FK_sponsor foreign key(clubID)
references club(ID)
);
INSERT INTO Sponsor VALUES(100000.0,'sport','Adidas',1);
INSERT INTO Sponsor VALUES(200000.0,'sport','Adidas',3);
INSERT INTO Sponsor VALUES(150000.0,'sport','Nike',2);
INSERT INTO Sponsor VALUES(30000.0,'sport','Jordan',4);
INSERT INTO Sponsor VALUES(40000.0,'sport','Puma',5);
INSERT INTO Sponsor VALUES(50000.0,'sport','Under Armour',6);
INSERT INTO Sponsor VALUES(60000.0,'sport','Asics',7);
INSERT INTO Sponsor VALUES(70000.0,'sport','New Balance',8);
INSERT INTO Sponsor VALUES(80000.0,'sport','Kappa',9);
INSERT INTO Sponsor VALUES(90000.0,'sport','Lotto',10);
CREATE TABLE CoachClub(
fee double not null,
startingDate date not null,
endingDate not null,
coachID integer not null,
clubID integer not null,
constraint FK_coach_club foreign key(coachID)
references coach(ID),
constraint FK_coach_club foreign key(clubID)
references club(ID)
);
INSERT INTO CoachClub VALUES(40000.0,'2016-03-02','2024-09-10',3,2);
INSERT INTO CoachClub VALUES(60000.0,'2018-02-06','2023-01-01',2,3);
INSERT INTO CoachClub VALUES(12000.0,'2019-01-29','2029-07-01',1,1);
INSERT INTO CoachClub VALUES(30000.0,'2010-03-07','2022-01-01',4,5);
INSERT INTO CoachClub VALUES(40000.0,'2020-09-01','2028-12-09',5,4);
INSERT INTO CoachClub VALUES(50000.0,'2016-01-01','2024-06-12',6,9);
INSERT INTO CoachClub VALUES(60000.0,'2018-10-02','2026-04-04',10,7);
INSERT INTO CoachClub VALUES(80000.0,'2019-02-27','2023-07-23',8,6);
INSERT INTO CoachClub VALUES(20000.0,'2017-09-20','2022-02-01',9,8);
INSERT INTO CoachClub VALUES(10000.0,'2020-03-18','2021-09-12',7,10);
CREATE TABLE ParticipationGameClub (
    clubID INTEGER NOT NULL,
    gameID INTEGER NOT NULL,
    CONSTRAINT PK_ParticipationGameClub Primary key (clubID, gameID)
    CONSTRAINT FK_ParticipationGameClub FOREIGN KEY (
        clubID
    )
    REFERENCES club (ID),
    
    CONSTRAINT FK_ParticipationGameClub FOREIGN KEY (
        gameID
    )
    REFERENCES Game (ID) 
);
INSERT INTO ParticipationGameClub VALUES(1,3);
INSERT INTO ParticipationGameClub VALUES(2,1);
INSERT INTO ParticipationGameClub VALUES(3,2);
INSERT INTO ParticipationGameClub VALUES(4,6);
INSERT INTO ParticipationGameClub VALUES(5,7);
INSERT INTO ParticipationGameClub VALUES(6,4);
INSERT INTO ParticipationGameClub VALUES(7,8);
INSERT INTO ParticipationGameClub VALUES(8,10);
INSERT INTO ParticipationGameClub VALUES(9,5);
INSERT INTO ParticipationGameClub VALUES(10,9);
CREATE TABLE club (ID integer PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, name char (255) NOT NULL, city char (255) NOT NULL, stadiumName char (255) NOT NULL, nickname char (255) NOT NULL, establishDate date NOT NULL, country char (255) NOT NULL, color char (255) NOT NULL);
INSERT INTO club VALUES(1,'Manchester United','Manchester','Old Trafford','Red devils',1878,'UK','red');
INSERT INTO club VALUES(2,'Barcelona','Barcelona','Camp Nou','Blaugrana',1899,'Spain','blue and red');
INSERT INTO club VALUES(3,'Bayern Munich','Munich','Allianz Arena','Bavarians',1900,'Germany','red');
INSERT INTO club VALUES(4,'Manchester city','Manchester','Etihad','Cityzens',1880,'UK','blue');
INSERT INTO club VALUES(5,'Real Madrid','Madrid','Santiago Benabeu','Los Blancos',1902,'Spain','white');
INSERT INTO club VALUES(6,'Borussia Dortmund','Dortmund','Westfalenstadion','Die Borussen',1909,'Germany','yellow');
INSERT INTO club VALUES(7,'Juventus','Juventus','Juventus Stadium','I Bianconeri',1897,'Italy','black and white');
INSERT INTO club VALUES(8,'Inter Milan','Milan','San Siro','La Beneamata',1908,'Italy','blue');
INSERT INTO club VALUES(9,'Liverpool ','Liverpool','Anfield','The Reds',1892,'UK','Red');
INSERT INTO club VALUES(10,'Valencia','Valencia','Mestalla','Los murciélagos ',1919,'Spain','Orange');
CREATE TABLE coach (ID integer PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, name char (255) NOT NULL, nationality char (255) NOT NULL, overall integer NOT NULL);
INSERT INTO coach VALUES(1,'Gunnar Solskjaer','Norway',78);
INSERT INTO coach VALUES(2,'Hans-Dieter','Germany',70);
INSERT INTO coach VALUES(3,'Ronald Koeman','Netherlands',80);
INSERT INTO coach VALUES(4,'Zinedine Zidane','France',90);
INSERT INTO coach VALUES(5,'Pep Guardiola','spain',96);
INSERT INTO coach VALUES(6,'Jürgen Klopp','Germany',96);
INSERT INTO coach VALUES(7,'Javi Gracia','Spain',70);
INSERT INTO coach VALUES(8,'Edin Terzić','Germany',65);
INSERT INTO coach VALUES(9,'Antonio Conte','Italy',75);
INSERT INTO coach VALUES(10,'Andrea Pirlo','Italy',80);
CREATE TABLE company (fullName varchar (255) PRIMARY KEY UNIQUE NOT NULL);
INSERT INTO company VALUES('Adidas');
INSERT INTO company VALUES('Nike');
INSERT INTO company VALUES('Puma');
INSERT INTO company VALUES('Under Armour');
INSERT INTO company VALUES('Asics');
INSERT INTO company VALUES('New Balance');
INSERT INTO company VALUES('Kappa');
INSERT INTO company VALUES('Reebok');
INSERT INTO company VALUES('Lotto');
INSERT INTO company VALUES('Jordan');
CREATE TABLE Game (ID integer PRIMARY KEY NOT NULL UNIQUE, date date NOT NULL, country char (255) NOT NULL, result char (255) NOT NULL, tournamentStartDate date NOT NULL, CONSTRAINT FK_game FOREIGN KEY (tournamentStartDate) REFERENCES tournament (startingDate));
INSERT INTO Game VALUES(1,'2020-05-02','UK','3-0','2020-06-29');
INSERT INTO Game VALUES(2,'2020-05-24','UK','2-4','2018-01-02');
INSERT INTO Game VALUES(3,'2020-06-01','UK','3-3','2019-06-02');
INSERT INTO Game VALUES(4,'2020-02-12','Germany','1-1','2019-01-03');
INSERT INTO Game VALUES(5,'2020-02-13','Germany','3-2','2020-06-29');
INSERT INTO Game VALUES(6,'2020-01-02','UK','0-0','2020-01-20');
INSERT INTO Game VALUES(7,'2020-07-12','Spain','2-6','2019-01-01');
INSERT INTO Game VALUES(8,'2020-07-02','Italy','3-2','2019-01-05');
INSERT INTO Game VALUES(9,'2020-03-01','Spain','2-1','2020-02-01');
INSERT INTO Game VALUES(10,'2020-03-02','Italy','0-1','2020-04-12');
CREATE TABLE Player (ID integer PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, number integer NOT NULL, nationality char (255) NOT NULL, name char (255) NOT NULL, overall integer NOT NULL, fee double NOT NULL, startingDate date NOT NULL, endingDate date NOT NULL, coachID integer NOT NULL, clubID integer NOT NULL, CONSTRAINT Fk_player FOREIGN KEY (coachID) REFERENCES coach (ID), CONSTRAINT Fk_player FOREIGN KEY (clubID) REFERENCES club (ID));
INSERT INTO Player VALUES(1,2,'France','Paul Pogba',73,20000.0,'2017-02-05','2027-02-29',1,1);
INSERT INTO Player VALUES(2,10,'Argantina','Lionel Messi',90,400000.0,'2010-02-34','2034-08-02',3,2);
INSERT INTO Player VALUES(3,7,'Germany','Thomas Muller',70,70000.0,'2008-07-02','2021-12-11',2,3);
INSERT INTO Player VALUES(4,7,'Portugal','Cristiano Ronaldo',93,60000.0,'2017-02-02','2023-09-12',10,7);
INSERT INTO Player VALUES(5,19,'Argentina','Sergio Agüero',80,30000.0,'2012-09-30','2022-08-07',5,4);
INSERT INTO Player VALUES(6,9,'France','Karim Benzema',82,40000.0,'2010-02-04','2024-01-05',4,5);
INSERT INTO Player VALUES(7,11,'Germany','Marco Reus',71,20000.0,'2019-01-02','2023-01-01',8,6);
INSERT INTO Player VALUES(8,9,'Belgium','Romelu Lukaku',82,30000.0,'2020-02-25','2028-02-04',9,8);
INSERT INTO Player VALUES(9,11,'Egypt','Mohamed Salah',82,50000.0,'2018-12-01','2029-03-01',6,9);
INSERT INTO Player VALUES(10,10,'South Korea','Lee Kang-in',79,50000.0,'2014-03-02','2021-02-04',7,10);
CREATE TABLE tournament (trophy char (255) NOT NULL, startingDate date PRIMARY KEY UNIQUE NOT NULL, championClubID integer NOT NULL, CONSTRAINT FK_tournament FOREIGN KEY (championClubID) REFERENCES club (ID));
INSERT INTO tournament VALUES('Premier League trophy','2020-01-20',1);
INSERT INTO tournament VALUES('La Liga trophy','2020-02-01',2);
INSERT INTO tournament VALUES('Bundesliga trophy','2020-04-17',3);
INSERT INTO tournament VALUES('Champion league trophy','2020-06-29',1);
INSERT INTO tournament VALUES('Series A trophy','2020-04-12',7);
INSERT INTO tournament VALUES('Premier League trophy','2018-01-02',4);
INSERT INTO tournament VALUES('La Liga trophy','2019-01-01',5);
INSERT INTO tournament VALUES('Bundesliga trophy','2019-01-03',6);
INSERT INTO tournament VALUES('Series A trophy','2019-01-05',8);
INSERT INTO tournament VALUES('Champion league trophy','2019-06-02',7);
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('club',10);
INSERT INTO sqlite_sequence VALUES('coach',10);
INSERT INTO sqlite_sequence VALUES('Player',10);
COMMIT;
