package com.fgmedia.fgmediawebapp.payment.repository;

import com.fgmedia.fgmediawebapp.payment.entity.ChargeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeMasterRepo extends JpaRepository<ChargeMaster, Integer> {

    ChargeMaster findByPaymentMethod(String paymentMethod);

}
