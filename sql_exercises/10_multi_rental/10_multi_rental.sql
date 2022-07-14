
SELECT customer_id, rental_date,
 COUNT(*) AS number_of_rentals
FROM rental
GROUP BY customer_id, rental_date;














 
