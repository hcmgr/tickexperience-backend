ALTER TABLE Event ADD ImageURL VARCHAR(255) NOT NULL;
ALTER TABLE Event ADD Gender VARCHAR(255);

-- Swimming
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL, Gender) VALUES (1, 1, 'Freestyle Heats', '2032-07-23T09:00:00', '2032-07-23T11:00:00', 'https://images.pexels.com/photos/1263348/pexels-photo-1263348.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 'M');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL, Gender) VALUES (1, 1, 'Freestyle Finals', '2032-07-30T15:00:00', '2032-07-30T17:00:00', 'https://images.pexels.com/photos/1263349/pexels-photo-1263349.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 'M');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL, Gender) VALUES (1, 1, 'Medley Heats', '2032-07-24T10:00:00', '2032-07-24T12:00:00', 'https://images.pexels.com/photos/1263425/pexels-photo-1263425.jpeg?auto=compress&cs=tinysrgb&w=1600', 'F');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL, Gender) VALUES (1, 1, 'Medley Finals', '2032-07-31T14:00:00', '2032-07-31T16:00:00', 'https://media.istockphoto.com/id/77930887/photo/three-swimmers-coming-to-ledge-of-pool.jpg?b=1&s=612x612&w=0&k=20&c=SDAeBPo0e0lTVu-MGfRGrzhoCsiGIV6v2sLL4XSE1iM=', 'F');
-- Athletics
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL) VALUES (2, 3, 'Session 1', '2032-07-28T10:30:00', '2032-07-28T13:30:00', 'https://wallpaperaccess.com/full/8224731.jpg');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL) VALUES (2, 3, 'Session 2', '2032-07-28T14:30:00', '2032-07-28T17:30:00', 'https://images.pexels.com/photos/3764011/pexels-photo-3764011.jpeg?auto=compress&cs=tinysrgb&w=1600');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL) VALUES (2, 2, 'Session 3', '2032-07-30T10:30:00', '2032-07-30T13:30:00', 'https://images.pexels.com/photos/2524739/pexels-photo-2524739.jpeg?auto=compress&cs=tinysrgb&w=1600');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL) VALUES (2, 2, 'Session 4', '2032-07-30T14:30:00', '2032-07-30T17:30:00', 'https://images.pexels.com/photos/2228741/pexels-photo-2228741.jpeg?auto=compress&cs=tinysrgb&w=1600');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL) VALUES (2, 3, 'Session 5', '2032-08-04T16:00:00', '2032-08-04T19:00:00', 'https://images.pexels.com/photos/15432888/pexels-photo-15432888/free-photo-of-woman-throwing-javelin-on-stadium.jpeg?auto=compress&cs=tinysrgb&w=1600');
-- Rugby
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL, Gender) VALUES (3, 2, 'Pool 1 Rounds', '2032-08-05T11:00:00', '2032-08-05T14:00:00', 'https://cdn.pixabay.com/photo/2016/06/15/01/11/soccer-1457988_1280.jpg', 'M');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL, Gender) VALUES (3, 2, 'Pool 2 Rounds', '2032-08-06T11:00:00', '2032-08-07T14:00:00', 'https://images.pexels.com/photos/3148452/pexels-photo-3148452.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 'M');
INSERT INTO Event (SportId, VenueId, Name, StartTime, EndTime, ImageURL, Gender) VALUES (3, 3, 'Finals Rounds', '2032-08-07T11:00:00', '2032-08-07T14:00:00', 'https://images.unsplash.com/photo-1650676182612-a2a5a435ce39?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHx8&w=1000&q=80', 'M');