/*

MySQL Script - Back End Challenge Task 2

Query to attend the challenge proposed in task 2

Autor: Rafael Felix de Moraes. All Rights Reserved

*/

SELECT ev1.event_type, (ev2.value - ev1.value) AS value 
FROM events ev1
JOIN events ev2
ON
ev1.event_type = ev2.event_type
AND
ev1.time = (SELECT time FROM events temp1 WHERE temp1.event_type = ev1.event_type ORDER BY time ASC LIMIT 1)
AND
ev2.time = (SELECT time FROM events temp2 WHERE temp2.event_type = ev2.event_type ORDER BY time DESC LIMIT 1 OFFSET 1);