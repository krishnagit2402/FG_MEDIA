package com.fgmedia.fgmediawebapp.wallet.feignClient.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class CreatePaymentReqDto {
    private String paymentAmount;

    private String paymentCurrency;

    private String paymentMethod;

    private String reason;

    private String reference;

    private String requestId;

    private String sourceCurrency;

    private Payer payer;

    private Beneficiary beneficiary;
}

@Data
class Beneficiary {
    private String dateOfBirth;

    private String entityType;

    private String firstName;

    private String lastName;

    private Address address;

    private BankDetails bankDetails;

    private AdditionalInfo additionalInfo;
}

@Data
class AdditionalInfo {
    private String businessArea;

    private String businessRegistrationNumber;
}

@Data
class Address {
    private String city;

    private String countryCode;

    private String postcode;

    private String state;

    private String streetAddress;
}

@Data
class BankDetails {
    private String accountCurrency;

    private String accountName;

    private String accountNumber;

    private String accountRoutingType1;

    private String accountRoutingValue1;

    private String bankCountryCode;

    private String bankName;
}

@Data
class Payer {
    private Address address;

    private String companyName;

    private String entityType;

    private AdditionalInfo additionalInfo;
}
