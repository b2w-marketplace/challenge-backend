package com.example.demo.controller.dtos;

import java.sql.Date;
import java.sql.Timestamp;

import com.example.demo.domain.Events;

public class EventsRequest {


	private Integer eventType;

	private Date time;

	private Integer value;

	
	public Events toEntity(){
        return new Events(null,eventType, value, time);
    }

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}


	
	
}
