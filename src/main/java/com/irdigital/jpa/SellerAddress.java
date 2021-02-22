package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_seller_address")
public class SellerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public int sellerId;
	
	@Column
	public int addressTypeId;
	
	@Column(length=150)
	public String address;
	
	@Column(length=150)
	public String department;
	
	@Column(length=150)
	public String province;
	
	@Column(length=150)
	public String district;
	
	@Column(length=150)
	public String addressReference;
}
