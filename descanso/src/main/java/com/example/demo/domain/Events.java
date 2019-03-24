package com.example.demo.domain;

import java.sql.Date;

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

	@Column(name = "event_type")
	@NotNull
	private Integer eventType;
	

	@Column(name = "value")
	@NotNull
	private Integer value;

	@Column(name = "time")
	@NotNull
	private Date time;

	
	public Events(Integer eventType,Integer value, Date time) {
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	



}
