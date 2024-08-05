package com.fgmedia.fgmediawebapp.wallet.feignClient.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class QuotaReqDto {

    private int buyAmount;

    private String buyCurrency;

    private Date conversionDate;

    private int sellAmount;

    private String sellCurrency;

    private String validity;

}
