package com.example.demo.security.auth;

import lombok.*;

@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	private String token;

}
