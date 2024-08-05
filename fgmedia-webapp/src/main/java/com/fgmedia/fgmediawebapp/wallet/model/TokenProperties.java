package com.fgmedia.fgmediawebapp.wallet.model;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class TokenProperties {

    private String token;

    @Temporal(TemporalType.DATE)
    private Date expiresAt;

}

