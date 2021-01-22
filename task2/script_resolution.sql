SELECT lastEvent.event_type, (penultimateEvent.value - lastEvent.value) AS 'value' 
FROM events AS lastEvent
INNER JOIN events AS penultimateEvent
	ON lastEvent.event_type = penultimateEvent.event_type
		AND penultimateEvent.time = (
			SELECT time
			FROM events
			WHERE event_type = penultimateEvent.event_type
			ORDER BY time DESC LIMIT 1 OFFSET 1
		)
		AND lastEvent.time = (
			SELECT time
			FROM events
			WHERE event_type = lastEvent.event_type
			ORDER BY time ASC LIMIT 1
		)

