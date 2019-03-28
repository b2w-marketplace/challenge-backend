SELECT
    EV.event_type,
    (
		SELECT
            EV_PENUL.value
        FROM
            events EV_PENUL
        WHERE
            EV_PENUL.event_type = EV.event_type AND
            EV_PENUL.time = (	
								SELECT
									MAX(EV_PENUL_TIME.time)
								FROM
									events EV_PENUL_TIME
								WHERE
									EV_PENUL_TIME.event_type = EV.event_type AND
									EV_PENUL_TIME.time < MAX(EV.time)
							)
    ) -
    (
		SELECT
            EV_OLD.value
        FROM
            events EV_OLD
        WHERE
            EV_OLD.event_type = EV.event_type AND
            EV_OLD.time = MIN(EV.time)
    ) value
FROM
    events EV
WHERE
	EV.event_type IN (SELECT event_type FROM events GROUP BY event_type HAVING COUNT(time) > 1)
GROUP BY
    EV.event_type
ORDER BY
	EV.event_type ASC;