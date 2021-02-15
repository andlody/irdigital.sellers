package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SellerContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public int sellerId;
	
	@Column(length=100)
	public String contactName;
	
	@Column(length=100)
	public String contactEmail;
	
	@Column(length=80)
	public String contactPhoneNumber;
	
	@Column
	public int contactTypeId;
	
	@Column
	public int principal;
}
