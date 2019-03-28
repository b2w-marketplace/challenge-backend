SELECT
e.event_type,
	(SELECT `value` FROM `events` WHERE event_type = e.event_type ORDER BY time DESC LIMIT 1 OFFSET 1) -
	(SELECT `value` FROM `events` WHERE event_type = e.event_type ORDER BY time ASC LIMIT 1) as returned_value
FROM
	`events` e
	GROUP BY event_type
	HAVING returned_value IS NOT NULL
	ORDER BY event_type	