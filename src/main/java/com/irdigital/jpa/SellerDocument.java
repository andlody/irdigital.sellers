package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="tb_seller_document")
public class SellerDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public int sellerId;
	
	@Column(length=100)
	public String documentName;
	
	@Column
	public int documentFormatId;
	
	@Column(length=150)
	public String documentUrl;
	
	@Transient
	public String documentFormat;
}
