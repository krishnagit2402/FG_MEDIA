package com.fgmedia.fgmediawebapp.wallet.feignClient.client;

import com.fgmedia.fgmediawebapp.config.FeignClientExceptionConfig;
import com.fgmedia.fgmediawebapp.wallet.config.TokenHeaderFeignConfig;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreateCardReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreatePaymentReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.QuotaReqDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "airwallex-service", url = "${airwallex.api.url}", configuration = {TokenHeaderFeignConfig.class, FeignClientExceptionConfig.class})
public interface AirwallexServiceFeign {

    @GetMapping(value = "balances/current")
    @Headers("Content-Type: application/json")
    ResponseEntity<?> getBalances();

    @PostMapping(value = "fx/quotes/create")
    @Headers("Content-Type: application/json")
    ResponseEntity<?> getQuota(@RequestBody QuotaReqDto dto);

    @GetMapping(value = "payments/{id}")
    ResponseEntity<?> getPaymentStatusById(@PathVariable String id);

    @PostMapping(value = "issuing/cards/create")
    @Headers("Content-Type: application/json")
    ResponseEntity<?> createCard(@RequestBody CreateCardReqDto reqDto);

    @PostMapping(value = "payments/create")
    @Headers("Content-Type: application/json")
    ResponseEntity<?> createPayment(@RequestBody CreatePaymentReqDto reqDto);

}
