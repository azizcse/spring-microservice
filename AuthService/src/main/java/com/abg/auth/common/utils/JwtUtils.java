package com.abg.auth.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 12/5/2023
 */
public class JwtUtils {
    public static String generateToken(String userName, String expiryTime, String jwtSecretKey) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName, expiryTime, jwtSecretKey);
    }

    public static String generateToken(Map<String, Object> claims,
                                       String userName,
                                       String expiryTime,
                                       String jwtSecretKey) {
        return createToken(claims, userName, expiryTime, jwtSecretKey);
    }

    public static String extractUserName(String token, String jwtSecretKey) {
        return extractClaim(token, jwtSecretKey, Claims::getSubject);
    }

    public static <T> T extractClaimByKey(String token, String jwtSecretKey, String key, Class<T> classType) {
        return extractClaim(token, jwtSecretKey, claims -> claims.get(key, classType));
    }

    public static Date extractExpiration(String token, String jwtSecretKey) {
        return extractClaim(token, jwtSecretKey, Claims::getExpiration);
    }

    public static String trimToken(String barerToken, String jwtTokenPrefix) {
        String tokenPrefix = String.format("%s ", jwtTokenPrefix);
        return StringUtils.replace(barerToken, tokenPrefix, "");
    }


    private static String createToken(Map<String, Object> claims,
                                      String subject,
                                      String expiryTime,
                                      String jwtSecretKey) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + getExpiryMilli(expiryTime)))
                .signWith(getSignInKey(jwtSecretKey), SignatureAlgorithm.HS256)
                .compact();
    }

    private static int getExpiryMilli(String expiryTime) {
        int expMinutes = Integer.valueOf(expiryTime);
        return convertToMilli(expMinutes, Calendar.MINUTE);
    }

    private static <T> T extractClaim(String token,
                                      String jwtSecretKey,
                                      Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token, jwtSecretKey);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token, String jwtSecretKey) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey(jwtSecretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private static Key getSignInKey(String jwtSecretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static boolean isTokenExpired(String token, String jwtSecretKey) {
        return extractExpiration(token, jwtSecretKey).before(new Date());
    }

    public static int convertToMilli(int minute, int calenderFlag) {
        if (Calendar.HOUR == calenderFlag) return 1000 * 60 * 60 * minute;
        if (Calendar.MINUTE == calenderFlag) return 1000 * 60 * minute;
        return 0;
    }



}
