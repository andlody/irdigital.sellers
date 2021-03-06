package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_required_seller_document")
public class RequiredSellerDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	//@Column
	//public int sellerId;
	
	@Column(length=80)
	public String documentName;
	
	@Column(length=150)
	public String allowedFormats;
	
	@Column
	public int maximunSizeAllowed;
}
