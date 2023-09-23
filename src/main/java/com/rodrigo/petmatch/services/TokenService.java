package com.rodrigo.petmatch.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rodrigo.petmatch.entities.Usuarios;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {


    public String encode(Usuarios usuarios) {
        try {

            var algorithm = Algorithm.HMAC256("secret");

            var token = JWT
                    .create()
                    .withIssuer("PetMatch")
                    .withSubject(usuarios.getUsername())
                    .withExpiresAt(generateExpiresDate())
                    .sign(algorithm);

            return token    ;
        } catch (JWTCreationException e) {
            return e.getMessage();
        }
    }

    public String validateToken(String token) {
        try {
            var algorithm = Algorithm.HMAC256("secret");
            return JWT.require(algorithm).withIssuer("PetMatch").build().verify(token).getSubject();
        } catch (JWTCreationException e) {
            return e.getMessage();
        }
    }

    public DecodedJWT decode(String token) {
        return JWT.decode(token);
    }

    public Instant generateExpiresDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
