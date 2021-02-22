package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_seller_bank")
public class SellerBank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public int sellerId;
	
	@Column(length=50)
	public String bankName;
	
	@Column(length=100)
	public String accountType;
	
	@Column(length=20)
	public String accountNumber;
	
	@Column(length=20)
	public String cci;
}
