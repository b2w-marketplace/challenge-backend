SELECT 
	oldest.event_type, 
	(penultimate.value - oldest.value) AS value
FROM teste.events AS oldest 
INNER JOIN teste.events AS penultimate 
	ON oldest.event_type = penultimate.event_type
WHERE oldest.time = (
	SELECT time 
    FROM teste.events 
    WHERE event_type = oldest.event_type 
    ORDER BY time ASC LIMIT 1
) 
AND penultimate.time = (
	SELECT time 
    FROM teste.events 
    WHERE event_type = penultimate.event_type 
    ORDER BY time DESC LIMIT 1 OFFSET 1
);

-- event_type|value|
-- ----------|-----|
-- 2         |2    |
-- 3         |0    |


-- ----------------------------------------------------------
SELECT 
	oldest.event_type, 
	(penultimate.value - oldest.value) AS value
FROM teste2.events AS oldest 
INNER JOIN teste2.events AS penultimate 
	ON oldest.event_type = penultimate.event_type
WHERE oldest.time = (
	SELECT time 
    FROM teste2.events 
    WHERE event_type = oldest.event_type 
    ORDER BY time ASC LIMIT 1
) 
AND penultimate.time = (
	SELECT time 
    FROM teste2.events 
    WHERE event_type = penultimate.event_type 
    ORDER BY time DESC LIMIT 1 OFFSET 1
);

-- event_type|value|
-- ----------|-----|
-- 2         |-3   |
-- 3         |0    |
-- 4         |-42  |


-- ----------------------------------------------------------
SELECT 
	oldest.event_type, 
	(penultimate.value - oldest.value) AS value
FROM teste3.events AS oldest 
INNER JOIN teste3.events AS penultimate 
	ON oldest.event_type = penultimate.event_type
WHERE oldest.time = (
	SELECT time 
    FROM teste3.events 
    WHERE event_type = oldest.event_type 
    ORDER BY time ASC LIMIT 1
) 
AND penultimate.time = (
	SELECT time 
    FROM teste3.events 
    WHERE event_type = penultimate.event_type 
    ORDER BY time DESC LIMIT 1 OFFSET 1
);

-- event_type|value|
-- ----------|-----|
-- 1         |0    |
-- 2         |0    |
-- 3         |0    |
-- 4         |0    |
-- 5         |0    |
-- 6         |0    |


-- ----------------------------------------------------------
SELECT 
	oldest.event_type, 
	(penultimate.value - oldest.value) AS value
FROM teste4.events AS oldest 
INNER JOIN teste4.events AS penultimate 
	ON oldest.event_type = penultimate.event_type
WHERE oldest.time = (
	SELECT time 
    FROM teste4.events 
    WHERE event_type = oldest.event_type 
    ORDER BY time ASC LIMIT 1
) 
AND penultimate.time = (
	SELECT time 
    FROM teste4.events 
    WHERE event_type = penultimate.event_type 
    ORDER BY time DESC LIMIT 1 OFFSET 1
);

-- event_type|value|
-- ----------|-----|
-- 1         |0    |
-- 2         |0    |
-- 3         |1    |
-- 4         |-1   |
-- 5         |0    |
-- 6         |-1   |
-- 7         |0    |
