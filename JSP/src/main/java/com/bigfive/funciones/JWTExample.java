package com.bigfive.funciones;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTExample {

    // Secret used for signing and verifying the token (keep this secret in a secure manner in a real environment).
    private static final String SECRET = "BooggyMillypilliMatute";

    // Method to create a JWT token
    public String createToken(String username, String role) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        // Create a JWT builder
        String token = JWT.create()
                .withIssuer("your_application") // Issuer of the token
                .withSubject(username) // Subject (username)
                .withClaim("role", role)                
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000)) // Expires in 1 hour
                .sign(algorithm);

        return token;
    }

    // Method to decode a JWT token and retrieve the username
    public String decodeToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            // Decode the token
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);

            // Get the subject claim (username)
            Claim usuarioClaim = jwt.getClaim("sub");
            Claim roleClaim = jwt.getClaim("role");
            return usuarioClaim.asString() + " " + roleClaim.asString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        JWTExample jwtExample = new JWTExample();

        // Example of creating and decoding a token
        String username = "matias.sanchez.b";
        String role= "ANALISTA";
        
        String token = jwtExample.createToken(username, role);
        System.out.println("Generated Token: " + token);

        String usuarioDecodificado = jwtExample.decodeToken(token);
        System.out.println("Decoded Username: " + usuarioDecodificado);
        
    }
}
