SELECT penultimate.event_type AS event_type, (penultimate.value - oldest.value) AS value
FROM events penultimate
       JOIN
     events oldest
     ON
       penultimate.event_type = oldest.event_type
WHERE penultimate.time = (SELECT e1.time
                          FROM events e1
                          WHERE e1.event_type = penultimate.event_type
                          ORDER BY e1.time DESC
                          LIMIT 1 OFFSET 1)
  AND
    oldest.time = (SELECT e2.time
                   FROM events e2
                   WHERE e2.event_type = oldest.event_type
                   ORDER BY e2.time ASC
                   LIMIT 1)
ORDER BY penultimate.event_type ASC
