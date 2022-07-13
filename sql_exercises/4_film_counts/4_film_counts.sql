USE sakila; 

SELECT store_id AS store_number, film_id, COUNT(film_id) AS number_of_films 
FROM inventory GROUP BY store_id, film_id ; 



