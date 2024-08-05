package com.fgmedia.fgmediawebapp.wallet.controller;

import com.fgmedia.fgmediawebapp.utils.ApiResponse;
import com.fgmedia.fgmediawebapp.wallet.dto.BalanceInfoResDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreateCardReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.CreatePaymentReqDto;
import com.fgmedia.fgmediawebapp.wallet.feignClient.dto.QuotaReqDto;
import com.fgmedia.fgmediawebapp.wallet.model.TokenInfoRecord;
import com.fgmedia.fgmediawebapp.wallet.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private WalletService walletService;

    @GetMapping("welcome")
    public ResponseEntity<?> welcome(@RequestParam String name) {
        try {
            ApiResponse<String> apiResponse = new ApiResponse<>();

            String result = "Welcome! " + name;

            apiResponse.setResult(result);
            apiResponse.setMessage("Welcome Message Delivered Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/welcome Exception: " + e.getMessage());
            logger.error("An error occurred in /welcome: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("loginAirwallex")
    public ResponseEntity<?> loginAirwallex() {
        try {
            ApiResponse<TokenInfoRecord> apiResponse = new ApiResponse<>();

            TokenInfoRecord result = walletService.loginAirwallex();

            apiResponse.setResult(result);
            apiResponse.setMessage("Login into Airwallex Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/loginAirwallex Exception: " + e.getMessage());
            logger.error("An error occurred in /loginAirwallex: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @GetMapping("getBalances")
    public ResponseEntity<?> getBalances(@RequestParam String currencyType) {
        try {
            ApiResponse<List<BalanceInfoResDto>> apiResponse = new ApiResponse<>();

            List<BalanceInfoResDto> result = walletService.getBalances(currencyType);

            apiResponse.setResult(result);
            apiResponse.setMessage("Get User Balances Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/getBalances Exception: " + e.getMessage());
            logger.error("An error occurred in /getBalances: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("getQuota")
    public ResponseEntity<?> getQuota(@RequestBody QuotaReqDto reqDto) {
        try {
            ApiResponse<LinkedHashMap<String, Object>> apiResponse = new ApiResponse<>();

            LinkedHashMap<String, Object> result = walletService.getQuota(reqDto);

            apiResponse.setResult(result);
            apiResponse.setMessage("Get User Quota Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/getQuota Exception: " + e.getMessage());
            logger.error("An error occurred in /getQuota: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @GetMapping("getPaymentStatusById/{id}")
    public ResponseEntity<?> getPaymentStatusById(@PathVariable String id) {
        try {
            ApiResponse<LinkedHashMap<String, Object>> apiResponse = new ApiResponse<>();

            LinkedHashMap<String, Object> result = walletService.getPaymentStatusById(id);

            apiResponse.setResult(result);
            apiResponse.setMessage("Get Payment Status Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/getPaymentStatusById Exception: " + e.getMessage());
            logger.error("An error occurred in /getPaymentStatusById: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("createCard")
    public ResponseEntity<?> createCard(@RequestBody CreateCardReqDto reqDto) {
        try {
            ApiResponse<LinkedHashMap<String, Object>> apiResponse = new ApiResponse<>();

            LinkedHashMap<String, Object> result = walletService.createCard(reqDto);

            apiResponse.setResult(result);
            apiResponse.setMessage("Creating Card Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/createCard Exception: " + e.getMessage());
            logger.error("An error occurred in /createCard: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("createPayment")
    public ResponseEntity<?> createPayment(@RequestBody CreatePaymentReqDto reqDto) {
        try {
            ApiResponse<LinkedHashMap<String, Object>> apiResponse = new ApiResponse<>();

            LinkedHashMap<String, Object> result = walletService.createPayment(reqDto);

            apiResponse.setResult(result);
            apiResponse.setMessage("Creating Payment Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/createPayment Exception: " + e.getMessage());
            logger.error("An error occurred in /createPayment: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }
}
