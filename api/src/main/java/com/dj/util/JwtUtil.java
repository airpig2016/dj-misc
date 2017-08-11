package com.dj.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dajiechen on 2017/8/4.
 */
public class JwtUtil {

    public static final String AUTHORIZATION_STARTER = "Bearer ";
    public static final String CLAIM_KEY_USERID = "userId";
    public static final String CLAIM_KEY_DATE = "date";


    public static String generateToken(String secret, String userId) {
        Date date = new Date();
        System.out.println("date: " + date);
        return generateToken(secret, userId, date.toString());
    }

    public static String generateToken(String secret, String userId, String date) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtUtil.CLAIM_KEY_USERID, userId);
        claims.put(JwtUtil.CLAIM_KEY_DATE, date);
        return Jwts.builder()
                .setClaims(claims)
//                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secret) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
    }

    public static Claims getClaimsFromToken(String token, String secret) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public static void main(String[] args) {

        String secret = "12344567890";

        String token = generateToken(secret, "18650072520");
        System.out.println("token: " + token);

        Claims cs = getClaimsFromToken(token, secret);
        System.out.println("username:" + cs.get(CLAIM_KEY_USERID));
        System.out.println("date:" + cs.get(CLAIM_KEY_DATE));

    }
}
