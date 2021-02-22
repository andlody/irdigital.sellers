# irdigital.sellers

Para que funcione los foreign key, insertar los valores:
* insert into tb_dispatch_type (id,name) values (1,'undefined')
* insert into tb_address_type (id,name) values (1,'undefined')
* insert into tb_ecommerce (id,name,vtex) values (3,'undefined',false),(4,'undefined',false)
* insert into tb_commission_type (id,name) values (1,'undefined'), (4,'undefined')
* insert into tb_email_type (id,name) values (1,'undefined')
* insert into tb_phone_type (id,name) values (1,'undefined')

Los datos se guardan de la siguiente forma:

```
{
    "general": {
        "ruc": "seller.ruc",
        "businessName": "seller.business_name",
        "tradeName": "seller.trade_name",
        "fiscalAddress": "San Isidro",
        "principalPhone": "seller_phone.phon_number",
        "principalEmail": "seller_email.email"
    },
    "accountant": {
        "commission": "seller_commission.commission",
        "bankId": 2,
        "bankTypeId": "seller_bank.account_type",
        "bankAccount": "seller_bank.account_number",
        "cci": "seller_bank.cci",
        "billingEmail": "f@p.com",
        "taxes": [
            "SELLER_COMMISION.COMMISION_TYPE_ID"
        ],
        "agreementEcommerce": [
            "seller_agreement_ecommerce.ecommerce_id"
        ],
        "accountingName": "seller_contact.contact_name",
        "accountingEmail": "seller_contact.contact_email",
        "accountingPhone": "seller_contact.contact_phone_number",
        "attachments": [{
            "id": 1,
            "name": "seller_document.document_name",
            "format": "document_format.name",
            "file": "cC54bWxQSwUGAAAAAA0ADQBHAwAASb0CAAAA",
            "size": 180390,
            "mimeType": "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "url": "SELLER_DOCUMENT.URL"
        }]
    },
    "contact": {
        "negotiationName": "seller_contact.contact_name",
        "negotiationPhone": "seller_contact.contact_phone_number",
        "negotiationEmail": "seller_contact.contact_email",
        "marketingName": "seller_contact.contact_name",
        "marketingEmail": "seller_contact.contact_email",
        "marketingPhone": "seller_contact.contact_phone_number",
        "afterSaleName": "seller_contact.contact_name",
        "afterSaleEmail": "seller_contact.contact_email",
        "afterSalePhone": "seller_contact.contact_phone_number"
    },
    "logistics": {
        "address": "seller_address.address ",
        "reference": "seller_address.address_reference",
        "dispatchType": "seller.dispatch_type_id",
        "hourAttend": [{
            "id": "seller_opening_hour.day",
            "from": "seller_opening_hour.start_time",
            "to": "seller_opening_hour.end_time"
        }],
        "warehouseName": "seller_contact.contact_name",
        "warehouseEmail": "seller_contact.contact_email",
        "warehousePhone": "seller_contact.contact_phone_number",
        "location": {
            "departmentCode": "seller_address.department",
            "provinceCode": "seller_address.province",
            "districtCode": "seller_address.district"
        }
    },
    "content": {
        "brands": [
            "seller_brand.brand"
        ],
        "descriptionCompany": "seller.company_description",
        "termsAndConditions": "seller.terms_conditions",
        "contactName": "seller_contact.contact_name",
        "contactEmail": "seller_contact.contact_email",
        "contactPhone": "seller_contact.contact_phone_number",
        "logo": [{
            "key": 0,
            "name": "SELLER_DOCUMENT.name",
            "format": "SELLER_DOCUMENT.format_id", 
            "file": "AdHoCbY0L+koAAAAAElFTkSuQmCC",
            "size": 9078,
            "mimeType": "image/png",
            "url": "SELLER_DOCUMENT.URL"
        }]
    }
}
```
