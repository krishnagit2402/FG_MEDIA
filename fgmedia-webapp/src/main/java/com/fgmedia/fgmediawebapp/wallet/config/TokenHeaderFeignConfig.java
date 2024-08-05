package com.fgmedia.fgmediawebapp.wallet.config;

import com.fgmedia.fgmediawebapp.wallet.model.TokenInfoRecord;
import com.fgmedia.fgmediawebapp.wallet.service.TokenService;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenHeaderFeignConfig {

    @Autowired
    private TokenService tokenService;

    private TokenInfoRecord getAirwallexToken() {
        return tokenService.getAuthToken();
    }

    @Bean
    public RequestInterceptor authInterceptor() {
        return template -> {
            template.header("Authorization", "Bearer " + getAirwallexToken().token());
        };
    }

}
