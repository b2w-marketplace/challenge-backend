package com.example.demo.domain;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Events  {

	@Id
	@GeneratedValue 
	@JsonIgnore
    private Integer id;

	@Column(name = "event_type")
	@NotNull
	private Integer eventType;
	

	@Column(name = "value")
	@NotNull
	private Integer value;

	@Basic(optional = false)
	@Column(name = "time", insertable = false, updatable = false)
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	
	public Events(Integer id,Integer eventType,Integer value, Date time) {
		this.id = id;
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
