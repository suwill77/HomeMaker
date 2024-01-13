package com.homemekar.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="ENTITY")
public class UserDtls {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String number;
	private String whatsAppNumber;
	private int pincode;
	private String password;
	private String verifyPassword;
	private String role;

	 
	
	
	@OneToMany(cascade =CascadeType.ALL,fetch =FetchType.LAZY,mappedBy="user")
	private List<ApnaDtls> apna = new ArrayList<>();
	
	
	
	@OneToMany(cascade =CascadeType.ALL,fetch =FetchType.LAZY,mappedBy="user")
	private List<ConDtls> cont = new ArrayList<>();
	
	public UserDtls() {
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
	public String getWhatsAppNumber() {
		return whatsAppNumber;
	}
	public void setWhatsAppNumber(String whatsAppNumber) {
		this.whatsAppNumber = whatsAppNumber;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", number=" + number + ", whatsAppNumber=" + whatsAppNumber
				+ ", pincode=" + pincode + ", password=" + password + ", verifyPassword=" + verifyPassword + ", role="
				+ role + "]";
	}
	public List<ApnaDtls> getApna() {
		return apna;
	}
	public void setApna(List<ApnaDtls> apna) {
		this.apna = apna;
	}
	
	public List<ConDtls> getCont() {
		return cont;
	}
	public void setCont(List<ConDtls> cont) {
		this.cont = cont;
	}
	
	

}






