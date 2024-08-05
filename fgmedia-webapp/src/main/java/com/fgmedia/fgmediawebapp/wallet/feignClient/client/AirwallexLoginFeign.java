package com.fgmedia.fgmediawebapp.wallet.feignClient.client;

import com.fgmedia.fgmediawebapp.config.FeignClientExceptionConfig;
import com.fgmedia.fgmediawebapp.wallet.config.LoginHeaderFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "airwallex-login", url = "${airwallex.api.url}", configuration = {LoginHeaderFeignConfig.class, FeignClientExceptionConfig.class})
public interface AirwallexLoginFeign {

    @PostMapping(value = "authentication/login")
    ResponseEntity<?> getAuthToken();

}
