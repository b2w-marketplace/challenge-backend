package com.example.demo.controller.dtos;

import java.sql.Timestamp;

import com.example.demo.domain.Events;

public class EventsRequest {


	private Integer eventType;

	private Timestamp time;

	private Integer value;

	
	public Events toEntity(){
        return new Events(eventType, value, time);
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

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


	
	
}
