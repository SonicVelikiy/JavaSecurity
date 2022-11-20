package uz.pdp.cardtransfer.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    String token;
    String keyword = "bukalitsuz";
    long expireTime = 36_000_000;

    public String generatorToken(String username) {
        Date exp = new Date(System.currentTimeMillis() + expireTime);
        token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, keyword)
                .compact();
        return token;
    }

    public boolean validateToken(String token) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(keyword)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserNameFromToken(String token) {
        String username = Jwts
                .parser()
                .setSigningKey(keyword)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        return username;
    }
}
