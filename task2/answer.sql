SELECT oldest.event_type, (penultimate.value - oldest.value) AS value  FROM
events oldest 
JOIN
events penultimate
ON
oldest.event_type = penultimate.event_type
AND
oldest.time = (SELECT time FROM events temp1 WHERE
           temp1.event_type=oldest.event_type ORDER BY time ASC LIMIT 1)
AND
penultimate.time = (SELECT time FROM events temp2 WHERE
           temp2.event_type=penultimate.event_type ORDER BY time DESC LIMIT 1 OFFSET 1)