SELECT oldest_event.event_type, (penultimate_event.value - oldest_event.value) AS value 
FROM events AS oldest_event 
JOIN events AS penultimate_event ON 
oldest_event.event_type = penultimate_event.event_type AND 
oldest_event.time = (SELECT time 
    FROM events 
    WHERE event_type = oldest_event.event_type 
    ORDER BY time ASC LIMIT 1) AND 
penultimate_event.time = (SELECT time 
    FROM events 
    WHERE event_type = penultimate_event.event_type 
    ORDER BY time DESC LIMIT 1 OFFSET 1);