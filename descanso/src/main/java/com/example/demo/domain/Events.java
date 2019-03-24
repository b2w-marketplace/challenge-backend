package com.example.demo.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Events  {

	@Id
	@GeneratedValue 
    private Integer id;

	@Column(name = "event_type", unique = true)
	@NotNull
	private Integer eventType;
	

	@Column(name = "value")
	@NotNull
	private Integer value;

	@Column(name = "time", unique = true)
	@NotNull
	private Timestamp time;

	
	public Events(Integer eventType,Integer value, Timestamp time) {
        this.eventType = eventType;
        this.value = value;
        this.time = time;

    }
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
