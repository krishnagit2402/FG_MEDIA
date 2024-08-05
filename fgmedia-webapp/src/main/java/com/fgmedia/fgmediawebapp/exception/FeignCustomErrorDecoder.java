package com.fgmedia.fgmediawebapp.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

public class FeignCustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        String errorMessage = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            errorMessage = IOUtils.toString(bodyIs, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException("Error reading response body", e);
        }

        return switch (HttpStatus.valueOf(response.status())) {
            case BAD_REQUEST -> new BadRequestException("Bad Request: " + errorMessage);
            case NOT_FOUND -> new NotFoundException("Not Found: " + errorMessage);
            case INTERNAL_SERVER_ERROR -> new InternalServerErrorException("Internal Server Error: " + errorMessage);
            default -> new Exception("Generic error: " + errorMessage);
        };
    }
}
