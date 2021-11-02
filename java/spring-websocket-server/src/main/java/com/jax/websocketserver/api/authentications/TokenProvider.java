package com.jax.websocketserver.api.authentications;

import com.jax.websocketserver.data.DTO.UserPrincipal;
import com.jax.websocketserver.data.common.EncryptionUtil;
import com.jax.websocketserver.data.response.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenProvider {

    @Autowired
    TokenKeyProvider tokenKeyProvider;

    @Value("${authentication.token.jwt.expire}")
    private int tokenTimeout;

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    @Value("${authentication.token.encrypt.password}")
    private String encryptPassword;

    @Value("${authentication.token.encrypt.salt}")
    private String salt;

    @SneakyThrows
    public UserPrincipal getUserPrincipalFromJWT(String token) {
        SecretKey SK = EncryptionUtil.getKeyFromPassword(encryptPassword, salt);
//		IvParameterSpec iv = EncryptionUtil.generateIv();
//		String algorithm = "AES/CBC/PKCS5Padding";


        Claims claims = this.decodeJWT(token);
        @SuppressWarnings("unchecked")
        List<GrantedAuthority> authorities = ((List<String>) claims.get("scopes")).stream().map((scope) -> new SimpleGrantedAuthority(scope)).collect(Collectors.toList());

        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setAuthorities(authorities);
        userPrincipal.setId(claims.getSubject());
        userPrincipal.setUserInfo(new UserInfo());

//        if (claims.get("cif") != null) {
//            userPrincipal.getTokenUser().setCif(EncryptionUtil.decryptWithPrefixIV((String) claims.get("cif"), SK));
//        }
//        if (claims.get("fullname") != null) {
//            userPrincipal.getTokenUser().setFullname(EncryptionUtil.decryptWithPrefixIV((String) claims.get("fullname"), SK));
//        }
//        if (claims.get("dob") != null) {
//            userPrincipal.getTokenUser().setDob(EncryptionUtil.decryptWithPrefixIV((String) claims.get("dob"), SK));
//        }
//        if (claims.get("idCardNo") != null) {
//            userPrincipal.getTokenUser().setIdCardNo(EncryptionUtil.decryptWithPrefixIV((String) claims.get("idCardNo"), SK));
//        }
//        if (claims.get("mobile") != null){
//            userPrincipal.getTokenUser().setMobile(EncryptionUtil.decryptWithPrefixIV((String) claims.get("mobile"), SK));
//        }
//        if (claims.get("email") != null) {
//            userPrincipal.getTokenUser().setEmail(EncryptionUtil.decryptWithPrefixIV((String) claims.get("email"), SK));
//        }


//        userPrincipal.getTokenUser().setFullname((String) claims.get("fullname"));
//        userPrincipal.getTokenUser().setDob((String) claims.get("dob"));
//        userPrincipal.getTokenUser().setIdCardNo((String) claims.get("idCardNo"));
//        userPrincipal.getTokenUser().setMobile((String) claims.get("mobile"));
//        userPrincipal.getTokenUser().setEmail((String) claims.get("email"));


        return userPrincipal;
    }

    public Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(tokenKeyProvider.getPublicKey())
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    @SneakyThrows
    public String issueToken(UserPrincipal userPrincipal, boolean power) {

        SecretKey SK = EncryptionUtil.getKeyFromPassword(encryptPassword, salt);
        byte[] iv = EncryptionUtil.getRandomNonce();
//		String algorithm = "AES/CBC/PKCS5Padding";


        Claims claims = Jwts.claims().setSubject(userPrincipal.getId());
        claims.put("scopes", userPrincipal.getAuthorities().stream().map(s -> s.toString()).collect(Collectors.toList()));
//        claims.put("userInfo", userPrincipal.getTokenUser());
//        if (userPrincipal.getTokenUser().getCif() != null) {
//            claims.put("cif", EncryptionUtil.encryptWithPrefixIV(userPrincipal.getTokenUser().getCif(), SK, iv));
//        }
//        if (userPrincipal.getTokenUser().getFullname() != null) {
//            claims.put("fullname", EncryptionUtil.encryptWithPrefixIV(userPrincipal.getTokenUser().getFullname(), SK, iv));
//        }
//        if (userPrincipal.getTokenUser().getDob() != null) {
//            claims.put("dob", EncryptionUtil.encryptWithPrefixIV(userPrincipal.getTokenUser().getDob(), SK, iv));
//        }
//        if (userPrincipal.getTokenUser().getIdCardNo() != null) {
//            claims.put("idCardNo", EncryptionUtil.encryptWithPrefixIV(userPrincipal.getTokenUser().getIdCardNo(), SK, iv));
//        }
//        if (userPrincipal.getTokenUser().getMobile() != null) {
//            claims.put("mobile", EncryptionUtil.encryptWithPrefixIV(userPrincipal.getTokenUser().getMobile(), SK, iv));
//        }
//        if (userPrincipal.getTokenUser().getEmail() != null) {
//            claims.put("email", EncryptionUtil.encryptWithPrefixIV(userPrincipal.getTokenUser().getEmail(), SK, iv));
//        }
//        claims.put("fullname", userPrincipal.getTokenUser().getFullname());
//        claims.put("dob", userPrincipal.getTokenUser().getDob());
//        claims.put("idCardNo", userPrincipal.getTokenUser().getIdCardNo());
//        claims.put("mobile", userPrincipal.getTokenUser().getMobile());
//        claims.put("email", userPrincipal.getTokenUser().getEmail());

        String token = Jwts.builder()
        		.setClaims(claims)
        		.setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.RS256, tokenKeyProvider.getPrivateKey())
                .compressWith(CompressionCodecs.GZIP)
        		.setExpiration(new Date(System.currentTimeMillis() + tokenTimeout * 1000))
                .compact();

        return token;
    }
}
