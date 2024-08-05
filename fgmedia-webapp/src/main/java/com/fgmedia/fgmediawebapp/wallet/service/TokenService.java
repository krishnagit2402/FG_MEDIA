package com.fgmedia.fgmediawebapp.wallet.service;

import com.fgmedia.fgmediawebapp.utils.CommonConstant;
import com.fgmedia.fgmediawebapp.utils.UtilClass;
import com.fgmedia.fgmediawebapp.wallet.feignClient.client.AirwallexLoginFeign;
import com.fgmedia.fgmediawebapp.wallet.model.TokenInfoRecord;
import com.fgmedia.fgmediawebapp.wallet.model.TokenProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TokenService {

    @Autowired
    private TokenProperties tokenProperties;

    @Autowired
    private AirwallexLoginFeign airwallexLoginFeign;

    private final Lock lock = new ReentrantLock();

    public TokenInfoRecord getAuthToken() {
        lock.lock();    // Synchronizing the token update process
        try {
            if (isValidToken())
                this.generateAuthToken();
        } finally {
            lock.unlock();
        }

        return new TokenInfoRecord(tokenProperties.getExpiresAt(), tokenProperties.getToken());
    }

    private boolean isValidToken() {
        return tokenProperties.getExpiresAt() == null || tokenProperties.getExpiresAt().before(new Date());
    }

    private void generateAuthToken() {
        LinkedHashMap<String, Object> tokenMap = UtilClass.getFeignResponse(airwallexLoginFeign.getAuthToken());

        SimpleDateFormat formatter = new SimpleDateFormat(CommonConstant.EXPIRE_AT_DATETIME);
        formatter.setTimeZone(TimeZone.getTimeZone(CommonConstant.UTC));

        Date expireAt;
        try {
            expireAt = formatter.parse(tokenMap.get(CommonConstant.EXPIRES_AT).toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.updateToken(tokenMap.get(CommonConstant.TOKEN).toString(), expireAt);
    }

    private void updateToken(String token, Date expiry) {
        tokenProperties.setToken(token);
        tokenProperties.setExpiresAt(expiry);
    }

}
