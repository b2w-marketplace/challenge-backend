select event1.event_type
     , (event2.value - event1.value) as value
  from events event1
     , events event2
 where event1.event_type = event2.event_type
   and event1.time = (select time
                             from events
                            where event_type = event1.event_type
					        order by time asc limit 1)
   and event2.time = (select time
                             from events
					        where event_type = event2.event_type
					        order by time desc
					        limit 1 offset 1);