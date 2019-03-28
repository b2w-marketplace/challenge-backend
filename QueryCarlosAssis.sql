select o.event_type,
	   -- subtrair o valor dos eventos
					((select value 
					   from events pen
					   where o.event_type = pen.event_type
					   order by time desc
					   limit 1,1) -
                       (o.value)) value
from events o
-- buscar registro mais antigo
where o.time = (select min(time)
					     from events aux
                         where aux.event_type = o.event_type)
-- buscar eventos que ocorreram mais de uma vez
and 1 < (select count(1)
				from events aux
                where aux.event_type = o.event_type)
order by o.event_type asc;