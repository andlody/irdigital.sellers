package com.irdigital.repository;


import java.util.ArrayList;
import com.irdigital.jpa.*;
import com.irdigital.jpa.Seller.SellerStatus;
import com.irdigital.jpa.SellerOpeningHours.WeekDays;
import com.irdigital.request.*;


public class CastRepository {
	
	public static Seller seller(SellerRequest sellerRequest) {
		
		Seller seller = new Seller();
		seller.ruc			= sellerRequest.general.ruc;
		seller.businessName	= sellerRequest.general.businessName;
		seller.tradeName	= sellerRequest.general.tradeName;
		
		seller.dispatchTypeId 	= sellerRequest.logistics.dispatchType;
		seller.termsConditions	= sellerRequest.content.termsAndConditions;
		
		seller.companyLogo 			= (sellerRequest.content.logo.length>0)?sellerRequest.content.logo[0].name:null;
		seller.companyDescription	= sellerRequest.content.descriptionCompany;
		
		seller.returnPolicy = "";
		seller.statusId = SellerStatus.NUEVO_REGISTRO;
		
		return seller;
	}
	
	public static SellerBank sellerBank(SellerRequest sellerRequest,int sellerId) {
		
		SellerBank sellerBank = new SellerBank();
		sellerBank.sellerId = sellerId;
		sellerBank.bankName = "";
		sellerBank.accountType = ""+sellerRequest.accountant.bankTypeId;
		sellerBank.accountNumber = sellerRequest.accountant.bankAccount;
		sellerBank.cci = sellerRequest.accountant.cci;
		
		return sellerBank;
	}
	
	public static ArrayList<SellerBrand> sellerBrand(SellerRequest sellerRequest,int sellerId) {
		
		ArrayList<SellerBrand> sellerBrands = new ArrayList<SellerBrand>();
		
		for(String brand : sellerRequest.content.brands) {
			SellerBrand sellerBrand = new SellerBrand();
			sellerBrand.sellerId = sellerId;
			sellerBrand.brand=brand;
			
			sellerBrands.add(sellerBrand);
		}
		return sellerBrands;
	}
	
	public static ArrayList<SellerOpeningHours> sellerOpeningHours(SellerRequest sellerRequest,int sellerId) {
		
		ArrayList<SellerOpeningHours> sellerOpeningHours = new ArrayList<SellerOpeningHours>();
		
		for(HourAttend hourAttend : sellerRequest.logistics.hourAttend) {
			SellerOpeningHours sellerOpeningHour = new SellerOpeningHours();
			sellerOpeningHour.sellerId 	= sellerId;
			sellerOpeningHour.day 		= getWeekDays(Integer.parseInt(""+hourAttend.id));
			sellerOpeningHour.startTime  	= hourAttend.from;
			sellerOpeningHour.endTime  	= hourAttend.to;
			
			sellerOpeningHours.add(sellerOpeningHour);
		}
		return sellerOpeningHours;
	}
	
	public static WeekDays getWeekDays(int i) {
		WeekDays day = WeekDays.LUN;
		switch(i){
			case 1:day = WeekDays.LUN;break;
			case 2:day = WeekDays.MAR;break;
			case 3:day = WeekDays.MIE;break;
			case 4:day = WeekDays.JUE;break;
			case 5:day = WeekDays.VIE;break;
			case 6:day = WeekDays.SAB;break;
			case 7:day = WeekDays.DOM;break;
		}
		return day;
	}
	
	public static SellerAddress sellerAddress(SellerRequest sellerRequest,int sellerId) {
		
		SellerAddress sellerAddress = new SellerAddress();
		sellerAddress.sellerId = sellerId;
		sellerAddress.address = sellerRequest.logistics.address;
		sellerAddress.addressReference = sellerRequest.logistics.reference;
		
		sellerAddress.addressTypeId=1;// Aqui se debe reemplazar por el tipo que llegue por el JSON
		
		sellerAddress.department = sellerRequest.logistics.location.departmentCode;
		sellerAddress.province = sellerRequest.logistics.location.provinceCode;
		sellerAddress.district = sellerRequest.logistics.location.districtCode;
		
		return sellerAddress;
	}
	
	public static ArrayList<SellerContact> sellerContact(SellerRequest sellerRequest,int sellerId) {
		
		SellerContact sellerContactNegotiation = new SellerContact();
		sellerContactNegotiation.sellerId = sellerId;
		sellerContactNegotiation.contactName = sellerRequest.contact.negotiationName;
		sellerContactNegotiation.contactEmail = sellerRequest.contact.negotiationEmail;
		sellerContactNegotiation.contactPhoneNumber = sellerRequest.contact.negotiationPhone;
		sellerContactNegotiation.contactTypeId = 1;//Negotiation
				
		SellerContact sellerContactMarketing = new SellerContact();
		sellerContactMarketing.sellerId = sellerId;
		sellerContactMarketing.contactName = sellerRequest.contact.marketingName;
		sellerContactMarketing.contactEmail = sellerRequest.contact.marketingEmail;
		sellerContactMarketing.contactPhoneNumber = sellerRequest.contact.marketingPhone;
		sellerContactMarketing.contactTypeId = 2;//Marketing
				
		SellerContact sellerContactAfterSale = new SellerContact();
		sellerContactAfterSale.sellerId = sellerId;
		sellerContactAfterSale.contactName = sellerRequest.contact.afterSaleName;
		sellerContactAfterSale.contactEmail = sellerRequest.contact.afterSaleEmail;
		sellerContactAfterSale.contactPhoneNumber = sellerRequest.contact.afterSalePhone;
		sellerContactAfterSale.contactTypeId = 3;//AfterSale
		
		SellerContact sellerContactWarehouse = new SellerContact();
		sellerContactWarehouse.sellerId = sellerId;
		sellerContactWarehouse.contactName = sellerRequest.logistics.warehouseName;
		sellerContactWarehouse.contactEmail = sellerRequest.logistics.warehouseEmail;
		sellerContactWarehouse.contactPhoneNumber = sellerRequest.logistics.warehousePhone;
		sellerContactWarehouse.contactTypeId = 4;//Warehouse
		
		SellerContact sellerContactContact = new SellerContact();
		sellerContactContact.sellerId = sellerId;
		sellerContactContact.contactName = sellerRequest.content.contactName;
		sellerContactContact.contactEmail = sellerRequest.content.contactEmail;
		sellerContactContact.contactPhoneNumber = sellerRequest.content.contactPhone;
		sellerContactContact.contactTypeId = 5;//Contact
		
		SellerContact sellerContactAccounting = new SellerContact();
		sellerContactAccounting.sellerId = sellerId;
		sellerContactAccounting.contactName = sellerRequest.accountant.accountingName;
		sellerContactAccounting.contactEmail = sellerRequest.accountant.accountingEmail;
		sellerContactAccounting.contactPhoneNumber = sellerRequest.accountant.accountingPhone;
		sellerContactAccounting.contactTypeId = 6;//Accounting
				
		 ArrayList<SellerContact> sellerContacts = new  ArrayList<SellerContact>();
		 sellerContacts.add(sellerContactNegotiation);
		 sellerContacts.add(sellerContactMarketing);
		 sellerContacts.add(sellerContactAfterSale);
		 
		 sellerContacts.add(sellerContactWarehouse);
		 sellerContacts.add(sellerContactContact);
		 sellerContacts.add(sellerContactAccounting);
		
		return sellerContacts;
	}
	
	public static ArrayList<SellerAgreementEcommerce> sellerAgreementEcommerce(SellerRequest sellerRequest,int sellerId) {
		
		ArrayList<SellerAgreementEcommerce> sellerAgreementEcommerces = new ArrayList<SellerAgreementEcommerce>();
		
		for(String agreementEcommerce : sellerRequest.accountant.agreementEcommerce) {
			SellerAgreementEcommerce sellerAgreementEcommerce = new SellerAgreementEcommerce();
			sellerAgreementEcommerce.sellerId = sellerId;
			sellerAgreementEcommerce.ecommerceId = Integer.parseInt(agreementEcommerce);
			
			sellerAgreementEcommerces.add(sellerAgreementEcommerce);
		}
		return sellerAgreementEcommerces;
	}
	
	public static ArrayList<SellerDocument> sellerDocument(SellerRequest sellerRequest,int sellerId) {
		
		ArrayList<SellerDocument> sellerDocuments = new ArrayList<SellerDocument>();
		
		for(Attachments attachments : sellerRequest.accountant.attachments) {
			SellerDocument sellerDocument = new SellerDocument();
			sellerDocument.sellerId = sellerId;
			sellerDocument.documentName 	= attachments.name;
			sellerDocument.documentFormat 	= attachments.format;
			sellerDocument.documentUrl 	= attachments.url;
			
			sellerDocuments.add(sellerDocument);
		}
		
		for(Logo logo : sellerRequest.content.logo) {
			SellerDocument sellerDocument = new SellerDocument();
			sellerDocument.sellerId = sellerId;
			sellerDocument.documentName 	= logo.name;
			sellerDocument.documentFormat 	= logo.format;
			sellerDocument.documentUrl 	= logo.url;
			
			sellerDocuments.add(sellerDocument);
		}
		
		return sellerDocuments;
	}
	
	public static ArrayList<RequiredSellerDocument> requiredSellerDocument(SellerRequest sellerRequest,int sellerId) {
		
		ArrayList<RequiredSellerDocument> requiredSellerDocuments = new ArrayList<RequiredSellerDocument>();
		
		for(Attachments attachments : sellerRequest.accountant.attachments) {
			RequiredSellerDocument requiredSellerDocument = new RequiredSellerDocument();
			//requiredSellerDocument.sellerId = sellerId;
			requiredSellerDocument.documentName 		= attachments.name;
			requiredSellerDocument.maximunSizeAllowed 	= attachments.size;
			requiredSellerDocument.allowedFormats		= "";
			
			requiredSellerDocuments.add(requiredSellerDocument);
		}
		return requiredSellerDocuments;
	}
	
	public static ArrayList<SellerCommission> sellerCommissions(SellerRequest sellerRequest,int sellerId) {
		
		ArrayList<SellerCommission> sellerCommissions = new ArrayList<SellerCommission>();
		
		SellerCommission sellerCommission = new SellerCommission();
		sellerCommission.sellerId = sellerId;
		sellerCommission.commission = Integer.parseInt(sellerRequest.accountant.commission.replace("%", "").replace(" ", ""));
		sellerCommission.commissionTypeId = 1;
		
		sellerCommissions.add(sellerCommission);
		
		for(String taxe : sellerRequest.accountant.taxes) {
			SellerCommission _sellerCommission = new SellerCommission();
			_sellerCommission.sellerId = sellerId;
			_sellerCommission.commissionTypeId=Integer.parseInt(taxe);
			_sellerCommission.commission=_sellerCommission.commissionTypeId;
			
			sellerCommissions.add(_sellerCommission);
		}
		
		return sellerCommissions;
	}
	
	public static SellerPhone sellerPhone(SellerRequest sellerRequest,int sellerId) {
		
		SellerPhone sellerPhone = new SellerPhone();
		sellerPhone.sellerId = sellerId;
		sellerPhone.phoneNumber = sellerRequest.general.principalPhone;
		sellerPhone.phoneTypeId=1;
		
		return sellerPhone;
	}
	
	public static SellerEmail sellerEmail(SellerRequest sellerRequest,int sellerId) {
		
		SellerEmail sellerEmail = new SellerEmail();
		sellerEmail.sellerId = sellerId;
		sellerEmail.email = sellerRequest.general.principalEmail;
		sellerEmail.emailTypeId=1;
		
		return sellerEmail;
	}
}