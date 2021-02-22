package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_seller")
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
	@Enumerated(value = EnumType.STRING)
	public SellerStatus statusId;
	
	public static enum SellerStatus {
		NUEVO_REGISTRO, REGISTRADO;
	}
}