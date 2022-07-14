USE sakila; 

SELECT rental_id, date(rental_date) AS date_wo_time, rental_date,  inventory_id, customer_id, return_date, staff_id, last_update FROM rental
WHERE rental_date <= '2005-06-17 10:00:00' AND rental_date >= '2005-06-17 00:00:00' 
ORDER BY rental_date DESC
LIMIT 10;


