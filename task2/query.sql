select e.event_type, (select p.value from events p where p.event_type = e.event_type order by time desc limit 1 offset 1) - (select p.value from events p where p.event_type = e.event_type order by time asc limit 1) as value
from events e
group by e.event_type having count(e.event_type)>1