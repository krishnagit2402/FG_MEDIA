package com.fgmedia.fgmediawebapp.wallet.config;

import com.fgmedia.fgmediawebapp.wallet.service.TokenService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Autowired
    private TokenService tokenService;

    @PostConstruct
    public void init() {
        tokenService.getAuthToken();
    }
}
