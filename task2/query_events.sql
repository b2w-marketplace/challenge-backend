-- Os resultados da planilha nao estao em conformidade com a proposta do exercicio
-- Por exemplo, na base teste2, os dois registros mais antigos de event_type = 2 sao
-- 2015-05-09 12:42:00 com value = 5 e 2015-05-09 12:54:39 com value = 7,
-- ou seja, a diferenca e 7-5 = 2, e nao -3. Este cenario se repete nas outras bases

select ev.event_type as EVENT_TYPE,
       (select penultimate.value
        from events penultimate
        where penultimate.event_type = ev.event_type
        order by time asc
        limit 1 offset 1)
         -
       (select last.value from events last where last.event_type = ev.event_type order by time asc limit 1) as VALUE
from events ev
group by ev.event_type
having count(ev.event_type) > 1;