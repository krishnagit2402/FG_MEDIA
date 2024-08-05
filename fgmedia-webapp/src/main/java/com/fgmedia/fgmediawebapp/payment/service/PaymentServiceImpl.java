package com.fgmedia.fgmediawebapp.payment.service;

import com.fgmedia.fgmediawebapp.payment.entity.ChargeMaster;
import com.fgmedia.fgmediawebapp.payment.repository.ChargeMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private ChargeMasterRepo chargeMasterRepo;

    @Override
    public Double effectedAmount(String paymentMethod, Double amount) {
        ChargeMaster chargeMaster = chargeMasterRepo.findByPaymentMethod(paymentMethod);

        Float chargePercentage = chargeMaster.getChargesPercentage();

        return amount - (amount * chargePercentage) / 100;
    }
}
