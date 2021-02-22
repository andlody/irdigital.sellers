package com.irdigital.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_seller_opening_hours")
public class SellerOpeningHours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public int sellerId;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	public WeekDays day;
	
	@Column(length=15)
	public String startTime;
	
	@Column(length=15)
	public String endTime;
	
	public static enum WeekDays {
		LUN,
		MAR,
		MIE,
		JUE,
		VIE,
		SAB,
		DOM;
	}
}
