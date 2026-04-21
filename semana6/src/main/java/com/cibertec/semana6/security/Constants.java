package com.cibertec.semana6.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {
    //Spring security
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    //JWT
    public static final String SUPER_SECRET_TEXT = "X7k$9Lm!qR2vZp@8#dF4tYw0BnC3uHjK5sE&aM6QxLrPzT";
    public static final long EXPIRATION_TIME = 600_000; // 10 minutos - expresados en milisegundos

    public static Key getSigningKeyB64(String secret){
        byte[] bytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(bytes);
    }

    public static Key getSigningKey(String secret){
        byte[] bytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(bytes);
    }
}
