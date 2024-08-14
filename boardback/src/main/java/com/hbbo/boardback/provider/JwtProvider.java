package com.hbbo.boardback.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    
    // private String secretKey =  ;
    // 이렇게 비밀 키 정보를 올려두면 다른 사람들이 볼 수 있기 때문에 다른 곳에서 작성한다. (resources/application.properties)

    @Value("${secret-key}")
    private String secretKey;

    public String create(String email){
    
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        String jwt = Jwts.builder()
            .signWith(key, SignatureAlgorithm.HS256)
            .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
            .compact();

        return jwt;
    }

    public String validate(String jwt){

        Claims claims = null;
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        try{
            claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }

        return claims.getSubject();
    }
}
