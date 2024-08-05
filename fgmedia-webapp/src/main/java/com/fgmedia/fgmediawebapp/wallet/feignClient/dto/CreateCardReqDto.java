package com.fgmedia.fgmediawebapp.wallet.feignClient.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class CreateCardReqDto {
    private String clientData;

    private String createdBy;

    private String formFactor;

    private String issueTo;

    private String nameOnCard;

    private String note;

    private String requestId;

    private AuthorizationControls authorizationControls;

    private PrimaryContactDetails primaryContactDetails;
}

@Data
class AuthorizationControls {
    private int allowedMerchantCategories;

    private String allowedTransactionCount;

    private List<PerTransactionLimit> perTransactionLimits;
}

@Data
class PerTransactionLimit {
    private String currency;

    private int limit;

    private boolean unlimited;
}

@Data
class PrimaryContactDetails {
    private String dateOfBirth;

    private String fullName;

    private String mobileNumber;
}
