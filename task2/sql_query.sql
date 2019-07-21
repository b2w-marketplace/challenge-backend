SELECT first_event.event_type, (second_event.value - first_event.value) AS value 
FROM events first_event
JOIN events second_event
ON
first_event.event_type = second_event.event_type
AND
first_event.time = (SELECT time FROM events WHERE event_type = first_event.event_type ORDER BY time ASC LIMIT 1)
AND
second_event.time = (SELECT time FROM events WHERE event_type = second_event.event_type ORDER BY time DESC LIMIT 1 OFFSET 1);