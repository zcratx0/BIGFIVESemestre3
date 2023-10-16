package com.bigfive.funciones;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bigfive.beans.UsuarioBeanRemote;
import com.bigfive.entities.Usuario;

public class BFJWT {
	
    // Secret used for signing and verifying the token (keep this secret in a secure manner in a real environment).
    private static final String SECRET = "BooggyMillypilliMatute";

    // Method to create a JWT token
    public static String createToken(Usuario user) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        // Create a JWT builder
        String token = JWT.create()
                .withIssuer("your_application") // Issuer of the token
                .withSubject(user.getMailInstitucional()) // Subject (username)
                .withClaim("role", "ANALISTA") // Cambiar por el rol que corresponde                
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000)) // Expires in 1 hour
                .sign(algorithm);

        return token;
    }

    // Method to decode a JWT token and retrieve the username
    public static String decodeToken(String token) {
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
        BFJWT jwtExample = new BFJWT();

        // Example of creating and decoding a token
        Usuario user = new Usuario();
        
        user.setMailInstitucional("matias.sanchez.b@estudiantes.utec.edu.uy");
        String token = jwtExample.createToken(user);
        System.out.println("Generated Token: " + token);

        String usuarioDecodificado = jwtExample.decodeToken(token);
        System.out.println("Decoded Username: " + usuarioDecodificado);
        
    }
}
