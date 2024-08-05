package com.fgmedia.fgmediawebapp.wallet.service;

import com.fgmedia.fgmediawebapp.utils.CommonConstant;
import com.fgmedia.fgmediawebapp.utils.UtilClass;
import com.fgmedia.fgmediawebapp.wallet.dto.BalanceInfoResDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.client.AirwallexServiceFeign;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreateCardReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreatePaymentReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.QuotaReqDto;
import com.fgmedia.fgmediawebapp.wallet.model.TokenInfoRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AirwallexServiceFeign airwallexServiceFeign;

    @Override
    public TokenInfoRecord loginAirwallex() {
        return tokenService.getAuthToken();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BalanceInfoResDto> getBalances(String currencyType) {
        LinkedHashMap<String, Object> result = UtilClass.getFeignResponse(airwallexServiceFeign.getBalances());
        List<LinkedHashMap<String, Object>> resList = (List<LinkedHashMap<String, Object>>) result.get(CommonConstant.RESULT_LIST);

        List<BalanceInfoResDto> resDto = new ArrayList<>();
        resList.forEach(res -> {
            BalanceInfoResDto dto = new BalanceInfoResDto();

            dto.setAvailableAmount(UtilClass.objectToFloat(res.get("available_amount")));
            dto.setCurrency(res.get("currency").toString());
            dto.setPendingAmount(UtilClass.objectToFloat(res.get("pending_amount")));
            dto.setReservedAmount(UtilClass.objectToFloat(res.get("reserved_amount")));
            dto.setTotalAmount(UtilClass.objectToFloat(res.get("total_amount")));

            resDto.add(dto);
        });

        if(!currencyType.equalsIgnoreCase(""))
            return resDto.stream()
                    .filter(itm -> itm.getCurrency().equalsIgnoreCase(currencyType))
                    .collect(Collectors.toList());

        return resDto;
    }

    @Override
    public LinkedHashMap<String, Object> getQuota(QuotaReqDto reqDto) {
        return UtilClass.getFeignResponse(airwallexServiceFeign.getQuota(reqDto));
    }

    @Override
    public LinkedHashMap<String, Object> getPaymentStatusById(String id) {
        return UtilClass.getFeignResponse(airwallexServiceFeign.getPaymentStatusById(id));
    }

    @Override
    public LinkedHashMap<String, Object> createCard(CreateCardReqDto reqDto) {
        return UtilClass.getFeignResponse(airwallexServiceFeign.createCard(reqDto));
    }

    @Override
    public LinkedHashMap<String, Object> createPayment(CreatePaymentReqDto reqDto) {
        return UtilClass.getFeignResponse(airwallexServiceFeign.createPayment(reqDto));
    }

}
