package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(length=20)
	public String ruc;
	
	@Column(length=150)
	public String businessName;
	
	@Column(length=150)
	public String tradeName;
	
	@Column
	public int dispatchTypeId;
	
	@Column
	public String termsConditions;
	
	@Column
	public String returnPolicy;
	
	@Column(length=80)
	public String companyLogo;
	
	@Column(length=80)
	public String companyDescription;
	
	@Column
	public int statusId;
}