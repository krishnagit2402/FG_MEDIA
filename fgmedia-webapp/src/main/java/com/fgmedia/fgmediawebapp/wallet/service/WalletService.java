package com.fgmedia.fgmediawebapp.wallet.service;

import com.fgmedia.fgmediawebapp.wallet.dto.BalanceInfoResDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreateCardReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreatePaymentReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.QuotaReqDto;
import com.fgmedia.fgmediawebapp.wallet.model.TokenInfoRecord;

import java.util.LinkedHashMap;
import java.util.List;

public interface WalletService {

    TokenInfoRecord loginAirwallex();

    List<BalanceInfoResDto> getBalances(String currencyType);

    LinkedHashMap<String, Object> getQuota(QuotaReqDto reqDto);

    LinkedHashMap<String, Object> getPaymentStatusById(String id);

    LinkedHashMap<String, Object> createCard(CreateCardReqDto reqDto);

    LinkedHashMap<String, Object> createPayment(CreatePaymentReqDto reqDto);
}
