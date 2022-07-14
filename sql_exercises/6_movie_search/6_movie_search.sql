-- retrieve films that are over 2 hours long and have the same 3 letters of your choice in the title. 

SELECT title, length FROM film
WHERE length >= 120
AND title LIKE '%B%' AND
title LIKE '%E%' AND
title LIKE '%T%'