USE sakila; 
SHOW TABLES;
CREATE TABLE IF NOT EXISTS  rating (
primary_key INT PRIMARY KEY AUTO_INCREMENT,
number_of_stars INT NOT NULL,
description_text VARCHAR(255) NOT NULL
);
INSERT INTO rating ( number_of_stars, description_text)
VALUES (5, 'greatest movie made'), 
(4, 'pretty good movie'), 
( 2, 'could have been better'), 
(4, 'loved the movie'), 
(3, 'it was meh');

SELECT * FROM rating; 


