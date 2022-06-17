package uz.yt.springdata.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${spring.security.secret.key}")
    private String secretKey;

    private final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    public String generateToken(String uuid){
        return Jwts.builder()
                .setSubject(uuid)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Claims getClaims(String token){
            return Jwts
                    .parserBuilder()
                    .setSigningKey(secretKey)
                    .build()//parser
                    .parseClaimsJws(token)
                    .getBody();
    }

    /**
     * Returns null if token is invalid
     * @return String or null
     */
    public String validateTokenAndGetSubject(String token){
        try {
            return getClaims(token).getSubject();
        }catch (ExpiredJwtException e){
            logger.error("Token expired: " + token);
            return null;
        }
        catch (Exception e){
            return null;
        }
    }


}
