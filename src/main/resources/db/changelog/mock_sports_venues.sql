INSERT INTO Sport (Name, Icon) VALUES ('Swimming', 'swimming');
INSERT INTO Sport (Name, Icon) VALUES ('Athletics', 'athletics');
INSERT INTO Sport (Name, Icon) VALUES ('Football', 'football');

INSERT INTO Venue (Name, Location) VALUES ('Sleeman Sports Complex', 'Old Cleveland Rd & Tilley Rd, Chandler QLD 4155');
INSERT INTO Venue (Name, Location) VALUES ('Suncorp Stadium', '40 Castlemaine St, Milton QLD 4064');
INSERT INTO Venue (Name, Location) VALUES ('The Gabba', 'Vulture St, Woolloongabba QLD 4102');


SET @url = 'https://l13.alamy.com/360/PN8C9G/football-stadium-in-stockholm-sweden-PN8C9G.jpg';

INSERT INTO Section(ImageURL, VenueId) Values(@url, 1);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 1);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 1);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 1);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 2);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 2);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 2);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 2);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 3);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 3);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 3);
INSERT INTO Section(ImageURL, VenueId) Values(@url, 3);