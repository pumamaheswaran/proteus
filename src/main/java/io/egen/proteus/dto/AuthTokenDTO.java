package io.egen.proteus.dto;

public class AuthTokenDTO {
	
	private String token;	

	public AuthTokenDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
