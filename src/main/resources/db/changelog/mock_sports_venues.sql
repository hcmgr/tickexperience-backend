INSERT INTO Sport (Name, Icon) VALUES ('Swimming', 'swimming');
INSERT INTO Sport (Name, Icon) VALUES ('Athletics', 'athletics');
INSERT INTO Sport (Name, Icon) VALUES ('Football', 'football');

INSERT INTO Venue (Name, Location, Capacity)
VALUES ('Sleeman Sports Complex',
        'Old Cleveland Rd & Tilley Rd, Chandler QLD 4155',
        3000);

INSERT INTO Venue (Name, Location, Capacity)
VALUES ('Suncorp Stadium',
        '40 Castlemaine St, Milton QLD 4064',
        42000);


INSERT INTO Venue (Name, Location, Capacity)
VALUES ('The Gabba',
        'Vulture St, Woolloongabba QLD 4102',
        48000);

INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (1, 'https://oagames2022.org/wp-content/uploads/2022/07/brisbane_aquatic_centre_pool.jpeg.webp');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (1, 'https://www.austadiums.com/stadiums/photos/suncorp-stadium-2.jpg');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (1, 'https://resources.afl.com.au/photo-resources/2019/11/13/1697edf7-a8c4-4bc7-b1e3-202b30d1ff04/Q2BrRi19JSP517696197.JPG?width=1000&height=1000');


INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (2, 'https://oagames2022.org/wp-content/uploads/2022/07/brisbane_aquatic_centre_pool.jpeg.webp');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (2, 'https://www.austadiums.com/stadiums/photos/suncorp-stadium-2.jpg');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (2, 'https://resources.afl.com.au/photo-resources/2019/11/13/1697edf7-a8c4-4bc7-b1e3-202b30d1ff04/Q2BrRi19JSP517696197.JPG?width=1000&height=1000');

INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (3, 'https://oagames2022.org/wp-content/uploads/2022/07/brisbane_aquatic_centre_pool.jpeg.webp');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (3, 'https://www.austadiums.com/stadiums/photos/suncorp-stadium-2.jpg');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (3, 'https://resources.afl.com.au/photo-resources/2019/11/13/1697edf7-a8c4-4bc7-b1e3-202b30d1ff04/Q2BrRi19JSP517696197.JPG?width=1000&height=1000');

SET @fieldTopURL = 'https://l13.alamy.com/360/PMEMXK/allianz-arena-munich-PMEMXK.jpg';
SET @fieldLeftURL = 'https://c8.alamy.com/comp/MFR2HJ/november-2017-madrid-440-x-180-degree-panorama-of-the-santiago-bernabeu-stadium-of-the-spanish-football-club-real-madrid-MFR2HJ.jpg';
SET @fieldBottomURL = 'https://l13.alamy.com/360/PN0GT9/interior-of-santiago-bernabeu-stadium-madrid-PN0GT9.jpg';
SET @fieldRightURL = 'https://l13.alamy.com/360/PN8C9G/football-stadium-in-stockholm-sweden-PN8C9G.jpg';

-- 1: top, 2: right, 3: bottom, 4: left
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldTopURL, 1, 1);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldRightURL, 1, 2);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldBottomURL, 1, 3);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldLeftURL, 1, 4);

INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldTopURL, 2, 1);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldRightURL, 2, 2);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldBottomURL, 2, 3);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldLeftURL, 2, 4);

INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldTopURL, 3, 1);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldRightURL, 3, 2);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldBottomURL, 3, 3);
INSERT INTO Section(ImageURL, VenueId, Location) Values(@fieldLeftURL, 3, 4);