package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_seller_agreement_ecommerce")
public class SellerAgreementEcommerce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public int sellerId;
	
	@Column
	public int ecommerceId;
}
