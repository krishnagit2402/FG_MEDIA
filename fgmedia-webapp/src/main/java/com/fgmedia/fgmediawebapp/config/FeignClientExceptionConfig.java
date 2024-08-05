package com.fgmedia.fgmediawebapp.config;

import com.fgmedia.fgmediawebapp.exception.FeignCustomErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suraj.gaur
 * @implNote managing feign error codes
 */
@Configuration
public class FeignClientExceptionConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignCustomErrorDecoder();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
