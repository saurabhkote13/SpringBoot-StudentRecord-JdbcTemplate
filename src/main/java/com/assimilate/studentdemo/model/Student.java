package com.assimilate.studentdemo.model;

public class Student {
	private Integer roll_number;
	@Override
	public String toString() {
		return "Student [roll_number=" + roll_number + ", name=" + name + ", city=" + city + ", email_id=" + email_id
				+ ", contact_number=" + contact_number + "]";
	}
	public Student(Integer roll_number, String name, String city, String email_id, String contact_number) {
		super();
		this.roll_number = roll_number;
		this.name = name;
		this.city = city;
		this.email_id = email_id;
		this.contact_number = contact_number;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Integer getRoll_number() {
		return roll_number;
	}
	public void setRoll_number(Integer roll_number) {
		this.roll_number = roll_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	private String name;
	private String city;
	private String email_id;
	private String contact_number;
}
