package com.marketingapp.Entites;

import javax.persistence.*;

@Entity
@Table(name="leads")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="firstname",nullable= false)
	private String firstname;
	@Column(name="lastname",nullable= false)
	private String lastname;
	@Column(name="email",nullable= false,unique=true)
	private String email;
	@Column(name="mobile",nullable= false,unique=true)
	private long mobile;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	
	
	
}
