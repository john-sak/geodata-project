package com.devdynasty.CrowdCritic.service;


import com.devdynasty.CrowdCritic.exception.TokenNotFoundException;
import com.devdynasty.CrowdCritic.model.Token;
import com.devdynasty.CrowdCritic.repository.TokenRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;


@Service
public class TokenService {


    private final PasswordEncoder encoder;

    private final TokenRepository tokenRepository;


    private String secretKey="11adsfasfasdfasfasfasfasfas431asdasdasdasd234123412kjdknaaidfioajdoifjaoidjfoiabaifioaiodfjjafasdfasfasdfas341241234";


    private Long expiration = 3600000L;

    private Long refreshExpiration = 86400000L;


    public TokenService(PasswordEncoder encoder,TokenRepository tokenRepository) {
        this.encoder = encoder;
        this.tokenRepository=tokenRepository;
    }


    public Token storeToken(Token token){

        return  this.tokenRepository.save(token);

    }


    public String generateToken(UserDetails userDetails){
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }


    public String generateRefreshToken(UserDetails userDetails){
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }





    private Claims extractAllClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

   private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }



    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);


        return (username.equals(userDetails.getUsername()))
                && !isTokenExpired(token);



    }

    public boolean isTokenStored(String token) {

        return tokenRepository
                   .findByTokenLikeAndExpiredFalse(token)
                   .isPresent();

    }


    public boolean isRefreshTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);


        return (username.equals(userDetails.getUsername()))
                && !isTokenExpired(token) && isRefreshTokenStored(token);



    }


    public void expireToken(Integer id) {
        tokenRepository.updateTokensByIdSetExpiredTrue(id);
    }


    public boolean isRefreshTokenStored(String refreshToken){
        return tokenRepository
                .findByRefreshTokenLikeAndExpiredFalse(refreshToken)
                .isPresent();
    }

    public Optional<Token> getToken(String token) throws TokenNotFoundException {

        return tokenRepository
                .findByTokenLikeAndExpiredFalse(token);
    }



    public Token save(Token token){
      return   tokenRepository.save(token);
    }
}
