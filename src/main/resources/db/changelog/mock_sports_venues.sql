INSERT INTO Sport (Name, Icon) VALUES ('Swimming', 'swimming');
INSERT INTO Sport (Name, Icon) VALUES ('Athletics', 'athletics');
INSERT INTO Sport (Name, Icon) VALUES ('Football', 'football');
INSERT INTO SPORT (Name, Icon) VALUES ('Basketball', 'basketball');
INSERT INTO SPORT (Name, Icon) VALUES ('Boxing', 'boxing');
INSERT INTO SPORT (Name, Icon) VALUES ('Cycling', 'cycling');
INSERT INTO SPORT (Name, Icon) VALUES ('Diving', 'diving');
INSERT INTO SPORT (Name, Icon) VALUES ('Fencing', 'fencing');
INSERT INTO SPORT (Name, Icon) VALUES ('Judo', 'judo');
INSERT INTO SPORT (Name, Icon) VALUES ('Surfing', 'surfing');
INSERT INTO SPORT (Name, Icon) VALUES ('Table Tennis', 'table-tennis');


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
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (1, 'https://media-cldnry.s-nbcnews.com/image/upload/newscms/2021_24/1734015/olympic-swimmers-kb-inline-210615-5.jpg');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (1, 'https://www.sleemansports.com.au/CMSPages/GetFile.aspx?guid=24bfe501-7191-4e4b-a5bb-2e5334f8e2a3');

INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (2, 'https://www.austadiums.com/stadiums/photos/suncorp-stadium-2.jpg');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (2, 'https://populous.com/wp-content/uploads/2018/01/Suncorp-Getty-1.jpg');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (2, 'https://www.multiplex.global/media/3m5jvhxw/banner_suncorp-stadium_img_6974brisbane-projects-71.jpg?anchor=center&mode=crop&width=1200&height=630&rnd=132581644478930000');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (2, 'https://populous.com/wp-content/uploads/2023/05/Populous_SuncorpStadium_Aerial_CrowdAFCAsianCup2015_Image-Credit-Ethan-Rohloff-scaled.jpg');

INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (3, 'https://resources.afl.com.au/photo-resources/2019/11/13/1697edf7-a8c4-4bc7-b1e3-202b30d1ff04/Q2BrRi19JSP517696197.JPG?width=1064&height=600');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (3, 'https://images.squarespace-cdn.com/content/v1/57451850c2ea516211202d79/1597711765593-MAJHRX9KDULFO8EAM948/Gabba-AFL-2019.jpg');
INSERT INTO VenueImage (VenueId, ImageUrl) VALUES (3, 'https://www.austadiums.com/stadiums/photos/the-gabba-aerial1.jpg');

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