package com.example.demo.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
	
	
	private static final String SECRET_KEY = "edea680348487599a141ebe420ebdfe88bfcccc1bbd454fd1295f8ee6f7b3333ffc779b6fe10df0f0b3a0cf6cc169e3ad71636b6c1cdfabb38c412564187d205afd045f65fb910424350a98af2aa8f04ec36831ed84da3ae50459f09171ce4eaeb6b63be4e79752c07ab63946dc966b574ec3e371133421542920f217a30fbf586c25950cf7bb20e694818e09fbc265c39b1dcad996c2c16305f058f1cc0af9d62bc42854e65140d6f3fd46ca504824b665d551f90c329e18a7eab39efe27b70c7bf0833211b304dcdcbf61e8c3dd25e20547d4f26b405107eda1a82b570ef2d00e74973663e40c0a735485a08db737d1771a998dc43655d4322077537dc356e";

	public String extractUsername(String token) {	
		return extractClaim(token, Claims::getSubject);
	}
	
	
	public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
		
	}
	
	
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}
	
	public String generateToken(
			Map<String, Object> extractClaims,
			UserDetails userDetails
			) {
		return Jwts
				.builder()
				.setClaims(extractClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256 )
				.compact();
	}
	
	public boolean isTokenValid(String token , UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
		
	}
	
	
	private boolean isTokenExpired(String token) {

		return extractExpiration(token).before(new Date());
	}


	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getExpiration);
	}


	private Claims extractAllClaims(String token) {
		return Jwts
			.parserBuilder()
			.setSigningKey(getSignInKey())
			.build()
			.parseClaimsJws(token)
			.getBody();
	}

	private SecretKey getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);		
		return Keys.hmacShaKeyFor(keyBytes);
	}
 
}
 