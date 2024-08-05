package com.fgmedia.fgmediawebapp.wallet.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginHeaderFeignConfig {

    @Value("${airwallex.feign.x-client-id}")
    private String xClientId;

    @Value("${airwallex.feign.x-api-key}")
    private String xApiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header("x-client-id", xClientId);
            template.header("x-api-key", xApiKey);
            template.header("Content-Type", "application/json");
        };
    }

}
