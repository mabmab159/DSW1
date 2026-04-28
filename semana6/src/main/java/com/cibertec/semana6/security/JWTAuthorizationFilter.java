package com.cibertec.semana6.security;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SignatureException;
import java.util.List;

import static com.cibertec.semana6.security.Constants.*;

@Component //Interceptar las peticiones y generar un filtro en base reglas
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private Claims setSigninKey(HttpServletRequest request) {
        String jwtToken = request.getHeader(Constants.HEADER_AUTHORIZATION).replace(TOKEN_PREFIX, ""); // Bearer jasfjklafsjklasdjkljklafs
        return Jwts.parserBuilder().setSigningKey(getSigningKey(Constants.SUPER_SECRET_TEXT)).build().parseClaimsJws(jwtToken).getBody();
    }

    private void setAuthentication(Claims claims) {
        List<String> authorities = claims.get("authorities", List.class);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(),
                null, authorities.stream().map(SimpleGrantedAuthority::new).toList());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public boolean isTokenValid(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(HEADER_AUTHORIZATION);
        return authenticationHeader != null && authenticationHeader.startsWith(TOKEN_PREFIX);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            if (isTokenValid(request)) {
                Claims claims = setSigninKey(request);
                if (claims.get("authorities") != null) {
                    setAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}
