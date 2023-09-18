INSERT INTO Sport (Name, Icon) VALUES ('Swimming', 'swimming');
INSERT INTO Sport (Name, Icon) VALUES ('Athletics', 'athletics');
INSERT INTO Sport (Name, Icon) VALUES ('Football', 'football');

INSERT INTO Venue (Name, Location, Capacity, ImageUrl)
VALUES ('Sleeman Sports Complex',
        'Old Cleveland Rd & Tilley Rd, Chandler QLD 4155',
        3000,
        'https://oagames2022.org/wp-content/uploads/2022/07/brisbane_aquatic_centre_pool.jpeg.webp');

INSERT INTO Venue (Name, Location, Capacity, ImageUrl)
VALUES ('Suncorp Stadium',
        '40 Castlemaine St, Milton QLD 4064',
        42000,
        'https://www.austadiums.com/stadiums/photos/suncorp-stadium-2.jpg');

INSERT INTO Venue (Name, Location, Capacity, ImageUrl)
VALUES ('The Gabba',
        'Vulture St, Woolloongabba QLD 4102',
        48000,
        'https://resources.afl.com.au/photo-resources/2019/11/13/1697edf7-a8c4-4bc7-b1e3-202b30d1ff04/Q2BrRi19JSP517696197.JPG?width=1000&height=1000'
       );

SET @url = 'https://l13.alamy.com/360/PN8C9G/football-stadium-in-stockholm-sweden-PN8C9G.jpg';

INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 1, 1);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 1, 2);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 1, 3);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 1, 4);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 2, 1);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 2, 2);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 2, 3);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 2, 4);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 3, 1);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 3, 2);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 3, 3);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@url, 3, 4);