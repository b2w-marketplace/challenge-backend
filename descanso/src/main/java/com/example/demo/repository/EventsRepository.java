package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Events;

public interface EventsRepository extends JpaRepository<Events, Integer>  {

	@Query(value="SELECT *, (ev2.value-ev1.value) FROM events ev1 JOIN events ev2 ON ev1.event_type=ev2.event_type AND ev1.time = (SELECT time FROM events temp1 WHERE temp1.event_type=ev1.event_type ORDER BY time DESC LIMIT 1) AND ev2.time = (SELECT time FROM events temp2 WHERE temp2.event_type=ev2.event_type ORDER BY time DESC LIMIT 1 OFFSET 1)", nativeQuery=true)
	List<Events> findAllEventsType();
	
}
