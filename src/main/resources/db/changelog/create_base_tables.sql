CREATE TABLE Session (
        Id int NOT NULL AUTO_INCREMENT,
        Location nvarchar(255) NOT NULL,
        StartTime DATETIME NOT NULL,
        EndTime DATETIME NOT NULL,
        PRIMARY KEY (Id)
);

CREATE TABLE Sport (
    Id int NOT NULL AUTO_INCREMENT,
    Name nvarchar(255) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE Event (
    Id int NOT NULL AUTO_INCREMENT,
    SessionId int NOT NULL,
    SportId int NOT NULL,
    Name nvarchar(255) NOT NULL,
    Location nvarchar(255) NOT NULL,
    StartTime DATETIME NOT NULL,
    EndTime DATETIME NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (SessionId) REFERENCES Session(Id),
    FOREIGN KEY (SportId) REFERENCES Sport(Id)
);


CREATE TABLE User (
  Id INT NOT NULL AUTO_INCREMENT,
  Username VARCHAR(255) NOT NULL,
  Password VARCHAR(255) NOT NULL,
  PRIMARY KEY (Id),
  UNIQUE KEY (Username)
);

CREATE TABLE Ticket (
    Id INT NOT NULL AUTO_INCREMENT,
    SeatNumber INT NOT NULL,
    Venue VARCHAR(255) NOT NULL,
    SessionId INT NOT NULL,
    UserId INT,
    PRIMARY KEY (Id),
    FOREIGN KEY (SessionId) REFERENCES Session(Id),
    FOREIGN KEY (UserId) REFERENCES User(Id),
    UNIQUE KEY (SeatNumber, Venue)
);


