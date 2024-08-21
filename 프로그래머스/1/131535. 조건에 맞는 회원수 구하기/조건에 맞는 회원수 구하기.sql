SELECT COUNT(user_id) AS USERS FROM USER_INFO 
WHERE DATE_FORMAT(JOINED, '%Y') = 2021
AND AGE >= 20 
AND AGE <= 29;