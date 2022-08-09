package com.example.demo;

public class timeZone {

	private String tz;
	private String name;
	public String getTz() {
		return tz;
	}
	public void setTz(String tz) {
		this.tz = tz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	
	public boolean DoesEqual(timeZone tz) {
		if(this.getName().equals(tz.getName()) && this.getTz().equals(tz.getTz())) {
			return true;
		}
		return false; 
	}
	
}
