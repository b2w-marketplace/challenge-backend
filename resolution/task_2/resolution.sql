SELECT 
	event_type,
	(
		(SELECT
			value
		FROM events
		WHERE events.event_type = outer_events.event_type
		ORDER BY event_type DESC, time DESC LIMIT 1, 1)
    - 
		(SELECT
			value
		FROM events
		WHERE events.event_type = outer_events.event_type
		ORDER BY event_type, time LIMIT 1)
  ) AS value
FROM events outer_events
GROUP BY event_type
HAVING count(*) > 1;