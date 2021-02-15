package com.irdigital.app.controllers;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import com.irdigital.repository.*;
import com.irdigital.request.*;
import com.irdigital.jpa.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SellerController {
	
	@Autowired
	private ISellerRepository _sellerRepository;
	@Autowired
	private ISellerBankRepository _sellerBankRepository;
	@Autowired
	private ISellerBrandRepository _sellerBrandRepository;
	@Autowired
	private ISellerOpeningHoursRepository _sellerOpeningHoursRepository;
	@Autowired
	private ISellerAddressRepository _sellerAddressRepository;
	@Autowired
	private ISellerContactRepository _sellerContactRepository;	
	@Autowired
	private ISellerAgreementEcommerceRepository _sellerAgreementEcommerceRepository;
	@Autowired
	private ISellerDocumentRepository _sellerDocumentRepository;
	@Autowired
	private IDocumentFormatRepository _documentFormatRepository;
	@Autowired
	private IRequiredSellerDocumentRepository _requiredSellerDocumentRepository;
	@Autowired
	private ISellerCommissionRepository _sellerCommissionRepository;
	@Autowired
	private ISellerPhoneRepository _sellerPhoneRepository;
	@Autowired
	private ISellerEmailRepository _sellerEmailRepository;
	
	@PostMapping(value = "seller", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveSeller(@RequestBody SellerRequest sellerRequest) {	
		
		
		Seller seller = CastRepository.seller(sellerRequest);
		_sellerRepository.save(seller);
		
		SellerBank sellerBank = CastRepository.sellerBank(sellerRequest,seller.id);
		_sellerBankRepository.save(sellerBank);
		
		ArrayList<SellerBrand> sellerBrands = CastRepository.sellerBrand(sellerRequest,seller.id);
		for(SellerBrand sellerBrand:sellerBrands) _sellerBrandRepository.save(sellerBrand);
		
		ArrayList<SellerOpeningHours> sellerOpeningHours = CastRepository.sellerOpeningHours(sellerRequest,seller.id);
		for(SellerOpeningHours sellerOpeningHour:sellerOpeningHours) _sellerOpeningHoursRepository.save(sellerOpeningHour);
		
		SellerAddress sellerAddress = CastRepository.sellerAddress(sellerRequest,seller.id);
		_sellerAddressRepository.save(sellerAddress);	
		
		ArrayList<SellerContact> sellerContacts = CastRepository.sellerContact(sellerRequest,seller.id);
		for(SellerContact sellerContact:sellerContacts) _sellerContactRepository.save(sellerContact);
		
		ArrayList<SellerAgreementEcommerce> sellerAgreementEcommerces = CastRepository.sellerAgreementEcommerce(sellerRequest,seller.id);
		for(SellerAgreementEcommerce sellerAgreementEcommerce:sellerAgreementEcommerces) _sellerAgreementEcommerceRepository.save(sellerAgreementEcommerce);
		
		ArrayList<SellerDocument> sellerDocuments = CastRepository.sellerDocument(sellerRequest,seller.id);
		for(SellerDocument sellerDocument:sellerDocuments) {
			sellerDocument.documentFormatId = getDocumentFormatId(sellerDocument.documentFormat);
			_sellerDocumentRepository.save(sellerDocument);
		}
		
		ArrayList<RequiredSellerDocument> requiredSellerDocuments = CastRepository.requiredSellerDocument(sellerRequest,seller.id);
		for(RequiredSellerDocument requiredSellerDocument:requiredSellerDocuments) _requiredSellerDocumentRepository.save(requiredSellerDocument);
		
		SellerCommission sellerCommission = CastRepository.sellerCommission(sellerRequest,seller.id);
		_sellerCommissionRepository.save(sellerCommission);	
		
		SellerPhone sellerPhone = CastRepository.sellerPhone(sellerRequest,seller.id);
		_sellerPhoneRepository.save(sellerPhone);
		
		SellerEmail sellerEmail = CastRepository.sellerEmail(sellerRequest,seller.id);
		_sellerEmailRepository.save(sellerEmail);
		
		SellerResponse sellerResponse = new SellerResponse();
		sellerResponse.sellerId = seller.id;
		
		return "holi";
	}
	
	protected int getDocumentFormatId(String name) {
		DocumentFormat documentFormat = _documentFormatRepository.findByName(name);
		if(documentFormat==null) {
			documentFormat = new DocumentFormat();
			documentFormat.name=name;
			_documentFormatRepository.save(documentFormat);
		}
		return documentFormat.id;
	}
	
}