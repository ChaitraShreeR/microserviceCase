package com.ibm.loginms.util;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

private String SECRET_KEY="secret";
	
	public String generateToken(String userName){
		HashMap<String,Object> claims=new HashMap<String, Object>();
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*1))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
		
	}
	

}
