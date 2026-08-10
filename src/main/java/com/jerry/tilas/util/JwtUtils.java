package com.jerry.tilas.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类：生成与解析 Token
 * 依赖：com.auth0:java-jwt:4.4.0
 */
public class JwtUtils {

    // 密钥，生产环境应放到配置文件中
    private static final String SECRET = "jerry-tilas-secret-key";
    // 过期时间：24小时（毫秒）
    private static final long EXPIRATION = 24 * 60 * 60 * 1000L;

    /**
     * 生成 JWT
     *
     * @param claims 自定义声明（业务数据，如 userId、username）
     * @return JWT 字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)           // 自定义载荷
                .withIssuedAt(new Date())              // 签发时间
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION)) // 过期时间
                .sign(Algorithm.HMAC256(SECRET));      // 签名算法
    }

    /**
     * 解析 JWT，返回自定义声明
     *
     * @param token JWT 字符串
     * @return 声明 Map
     * @throws com.auth0.jwt.exceptions.JWTVerificationException token 无效或过期时抛出
     */
    public static Map<String, Object> parseToken(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token); // 验证签名 + 过期时间
        Claim claim = jwt.getClaim("claims");
        if (claim.isNull()) {
            return Map.of();
        }
        return claim.asMap();
    }

    /**
     * 校验 token 是否有效（未过期且签名正确）
     *
     * @param token JWT 字符串
     * @return true 有效，false 无效
     */
    public static boolean isValid(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
