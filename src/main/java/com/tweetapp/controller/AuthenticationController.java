package com.tweetapp.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import com.tweetapp.entities.UsersEntity;
import com.tweetapp.repository.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class AuthenticationController {
	@Autowired
	UsersRepo userRepository;

	@GetMapping("/authenticate")
	@CrossOrigin(origins = "http://localhost:3000")
	public HashMap<String, String> authenticate(@RequestHeader(value = "Authorization") String authHeader) {
		HashMap<String, String> map = new HashMap<>();
		String user = getUser(authHeader);
		String[] userDetails = user.split(":");
		String token = generateJwt(user);
		map.put("user", userDetails[0]);
		UsersEntity users = userRepository.findByLoginId(userDetails[0]);
		users.setLoggedIn(true);
		userRepository.save(users);
		map.put("Role", users.getRoles().get(0));
		map.put("token", token);
		return map;
	}

	private String getUser(String authHeader) {
		String encoded = authHeader.substring(6).toString();
		Base64.Decoder decoder = Base64.getMimeDecoder();
		String decoded = new String(decoder.decode(encoded));
		return decoded;
	}

	private String generateJwt(String user) {

		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 3600000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;

	}
}
