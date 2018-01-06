package com.sensing.entity;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.OnSave;

@Entity
public class TemperatureEntity {

	@Id
	private String id;
	private double value;
	private Date date;
	private double latitude;
	private double longitude;
	
	private TemperatureEntity() {}
	
	public TemperatureEntity(double value, Date date, double latitude, double longitude) {
		this.value = value;
		this.date = date;
		this.latitude = latitude;
		this.longitude = longitude;
		
		updateId();
	}
	
	/**
	 * Force id to take good value
	 */
	@OnSave void onSave() {
		updateId();
	}
	
	public void updateId() {
		this.id = this.latitude + "_" + this.longitude;
	}

	public String getId() {
		return id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
		updateId();
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
		updateId();
	}
}