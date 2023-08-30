-- Insert dummy data into Sport table
INSERT INTO Sport (Name) VALUES ('Football');
INSERT INTO Sport (Name) VALUES ('Basketball');
INSERT INTO Sport (Name) VALUES ('Tennis');
INSERT INTO Sport (Name) VALUES ('Swimming');

-- Insert dummy data into Session table
INSERT INTO Session (Location, StartTime, EndTime)
VALUES ('Gabba', '2023-08-30 15:00:00', '2023-08-30 18:00:00');
INSERT INTO Session (Location, StartTime, EndTime)
VALUES ('Rackers house', '2023-08-30 15:00:00', '2023-08-30 18:00:00');

-- Insert dummy data into Event table
INSERT INTO Event (SessionId, SportId, Name, Location, StartTime, EndTime)
VALUES (1, 1, 'Football Match 1', 'Stadium A', '2023-08-30 15:00:00', '2023-08-30 17:00:00');
INSERT INTO Event (SessionId, SportId, Name, Location, StartTime, EndTime)
VALUES (1, 2, 'Basketball Game 1', 'Arena B', '2023-08-31 10:00:00', '2023-08-31 12:00:00');
INSERT INTO Event (SessionId, SportId, Name, Location, StartTime, EndTime)
VALUES (2, 3, 'Tennis Tournament 1', 'Court X', '2023-09-01 09:00:00', '2023-09-01 15:00:00');
INSERT INTO Event (SessionId, SportId, Name, Location, StartTime, EndTime)
VALUES (2, 1, 'Football Match 2', 'Stadium C', '2023-09-02 16:00:00', '2023-09-02 18:00:00');

