package com.homemekar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="contractor")
public class ConDtls {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String number;
	private String address;
	private String pincode;
	private String lenplot;
	private String widthplot;
	private String plotfacing;
	private String floor;
	private String imageUrl;
	private String states;
	
	
	@ManyToOne
	private UserDtls user;
	
	public ConDtls() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getLenplot() {
		return lenplot;
	}


	public void setLenplot(String lenplot) {
		this.lenplot = lenplot;
	}


	public String getWidthplot() {
		return widthplot;
	}


	public void setWidthplot(String widthplot) {
		this.widthplot = widthplot;
	}


	public String getPlotfacing() {
		return plotfacing;
	}


	public void setPlotfacing(String plotfacing) {
		this.plotfacing = plotfacing;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getStates() {
		return states;
	}


	public void setStates(String states) {
		this.states = states;
	}


	@Override
	public String toString() {
		return "ConDtls [id=" + id + ", name=" + name + ", number=" + number + ", address=" + address + ", pincode="
				+ pincode + ", lenplot=" + lenplot + ", widthplot=" + widthplot + ", plotfacing=" + plotfacing
				+ ", floor=" + floor + ", image=" + imageUrl + "]";
	}


	public UserDtls getUser() {
		return user;
	}


	public void setUser(UserDtls user) {
		this.user = user;
	}
	
	


}
