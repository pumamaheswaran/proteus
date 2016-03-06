package io.egen.proteus.service;

import java.util.Date;

import io.egen.proteus.dto.AuthTokenDTO;
import io.jsonwebtoken.Claims;

public interface TokenService {
	
	public AuthTokenDTO encryptToken(String email, String role, Date expirationDate);
	
	public Claims decryptToken(String token);
	
}
