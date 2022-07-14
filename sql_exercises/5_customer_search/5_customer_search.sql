USE sakila;
SELECT first_name, last_name FROM customer WHERE (first_name  LIKE '%M%' OR first_name LIKE '%L%') AND (last_name LIKE '%M%' OR last_name LIKE '%L%');








