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
	private int latInf;
	private int latSup;
	private int longInf;
	private int longSup;
	
	private TemperatureEntity() {}
	
	public TemperatureEntity(double value, Date date, int latInf, int latSup, int longInf, int longSup) {
		this.id = latInf + "." + latSup + "_" + longInf + "." + longSup;
		this.value = value;
		this.date = date;
		this.latInf = latInf;
		this.latSup = latSup;
		this.longInf = longInf;
		this.longSup = longSup;
	}
	
	/**
	 * Force id to take good value
	 */
	@OnSave void onSave() {
		updateId();
	}
	
	public void updateId() {
		this.id = this.latInf + "." + this.latSup + "_" + this.longInf + "." + this.longSup;
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

	public int getLatInf() {
		return latInf;
	}

	public void setLatInf(int latInf) {
		this.latInf = latInf;
		updateId();
	}

	public int getLatSup() {
		return latSup;
	}

	public void setLatSup(int latSup) {
		this.latSup = latSup;
		updateId();
	}

	public int getLongInf() {
		return longInf;
	}

	public void setLongInf(int longInf) {
		this.longInf = longInf;
		updateId();
	}

	public int getLongSup() {
		return longSup;
	}

	public void setLongSup(int longSup) {
		this.longSup = longSup;
		updateId();
	}
}