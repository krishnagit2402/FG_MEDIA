package com.fgmedia.fgmediawebapp.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UtilClass {

    @SuppressWarnings("unchecked")
    public static LinkedHashMap<String, Object> getFeignResponse(ResponseEntity<?> responseEntity) {
        LinkedHashMap<String, Object> map = null;

        if(responseEntity.getStatusCode().is2xxSuccessful())
            if(responseEntity.getBody() != null)
                if(responseEntity.getBody() instanceof ArrayList<?>) {
                    List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) responseEntity.getBody();

                    map = new LinkedHashMap<>();
                    map.put(CommonConstant.RESULT_LIST, list);
                }
                else
                    map = (LinkedHashMap<String, Object>) responseEntity.getBody();

        return map;
    }

    public static Float objectToFloat(Object o) {
        if (o == null)
            return null;

        if (o instanceof Float)
            return (Float) o;

        try {
            return Float.valueOf(o.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
