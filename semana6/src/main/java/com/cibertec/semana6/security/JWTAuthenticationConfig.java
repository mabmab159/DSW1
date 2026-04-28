package com.cibertec.semana6.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.cibertec.semana6.security.Constants.*;

@Configuration
public class JWTAuthenticationConfig {
    public String getJWTToken(String username, String nombres, String apellidos) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN");

        String token = Jwts.builder()
                .setId("MabMab")
                .setSubject(username)
                .claim("nombres", nombres)
                .claim("apellidos", apellidos)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(SUPER_SECRET_TEXT), SignatureAlgorithm.HS256).compact();
        return "Bearer " + token;
    }

    public Claims decodeToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(getSigningKey(SUPER_SECRET_TEXT))
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
