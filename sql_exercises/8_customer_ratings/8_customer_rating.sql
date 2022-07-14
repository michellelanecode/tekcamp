-- add additional table to schema, store records of customer ratings for movies, 
-- foreign key constraints /cardinality should be set appropriately 
-- create 20-30 records in the customer ratings table 
-- list each movie including the highest lowest and average score they received 
-- as well as number of reviews DESCRIBE customer


USE sakila; 
-- 	CREATE TABLE customer_ratings (
-- 	rating_id INT,
--     film_id SMALLINT UNSIGNED,
-- 	customer_id SMALLINT UNSIGNED PRIMARY KEY,
-- 	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
--     FOREIGN KEY (film_id) REFERENCES film(film_id),
-- 	FOREIGN KEY (rating_id) REFERENCES rating(primary_key)
-- )


SELECT * from customer_ratings






