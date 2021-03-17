SELECT groupEvent.event_type,
       (
               (SELECT penultimate.value
                FROM events AS penultimate
                WHERE penultimate.event_type = groupEvent.event_type
                ORDER BY penultimate.time DESC
                LIMIT 1,1)
               -
               (SELECT oldestEvent.value
                FROM events AS oldestEvent
                WHERE oldestEvent.event_type = groupEvent.event_type
                ORDER BY oldestEvent.time
                LIMIT 1)
           ) AS value
FROM events AS groupEvent
GROUP BY groupEvent.event_type
HAVING count(*) > 1;
