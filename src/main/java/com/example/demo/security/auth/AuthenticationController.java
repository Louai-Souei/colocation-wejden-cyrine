package com.example.demo.security.auth;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(AuthenticationController.class);
	private final AuthenticationService service;

	public AuthenticationController(AuthenticationService service) {
		this.service = service;
	}


	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest request
	) {
		System.out.println("Received annonceDto: {}");
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> authentication(
			@RequestBody AuthenticationRequest request

	) {
		return ResponseEntity.ok(service.authenticate(request));
	}


}
