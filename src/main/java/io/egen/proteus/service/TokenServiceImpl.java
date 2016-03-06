package io.egen.proteus.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.egen.proteus.dto.AuthTokenDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@Service
public class TokenServiceImpl implements TokenService {	
	
	//TODO:Random key generator
	private static final String SECRET_KEY = "secret_key";

	@Override
	public AuthTokenDTO encryptToken(String email,String role, Date expirationDate) {
				
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 1);	
		
		return new AuthTokenDTO(Jwts.builder().setSubject(email)
	            .claim("role", role).setExpiration(expirationDate==null?c.getTime():expirationDate).setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact());	
	}

	@Override
	public Claims decryptToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
			    .parseClaimsJws(token).getBody();
		return claims;
	}
}
