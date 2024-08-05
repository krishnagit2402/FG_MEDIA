package com.fgmedia.fgmediawebapp.payment.controller;

import com.fgmedia.fgmediawebapp.payment.service.PaymentService;
import com.fgmedia.fgmediawebapp.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private PaymentService paymentService;

    @GetMapping("/effectedAmount")
    public ResponseEntity<?> effectedAmount(@RequestParam String paymentMethod, @RequestParam Double amount) {
        try {
            ApiResponse<Double> apiResponse = new ApiResponse<>();

            Double result = paymentService.effectedAmount(paymentMethod, amount);

            apiResponse.setResult(result);
            apiResponse.setMessage("Effected Amount Calculated Successful!!");
            apiResponse.setStatus(HttpStatus.OK.value());

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            logger.info("/effectedAmount Exception: " + e.getMessage());
            logger.error("An error occurred in /effectedAmount: ", e);
            e.printStackTrace();

            ApiResponse<String> apiResponse = new ApiResponse<>();
            apiResponse.setResult("There is some error occurred !!");
            apiResponse.setMessage(e.getMessage());
            apiResponse.setStatus(HttpStatus.FORBIDDEN.value());

            return ResponseEntity.badRequest().body(apiResponse);
        }
    }
}
