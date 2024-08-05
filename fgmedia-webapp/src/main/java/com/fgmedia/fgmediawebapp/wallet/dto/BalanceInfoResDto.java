package com.fgmedia.fgmediawebapp.wallet.dto;

import lombok.Data;

@Data
public class BalanceInfoResDto {

    private Float availableAmount;

    private String currency;

    private Float pendingAmount;

    private Float reservedAmount;

    private Float totalAmount;

}
