package com.irdigital.request;

import javax.persistence.Column;

public class General {
	
	@Column(length=20)
	public String ruc;
	public String businessName;
	public String tradeName;
	public String fiscalAddress;
	public String principalPhone;
	public String principalEmail;
}
