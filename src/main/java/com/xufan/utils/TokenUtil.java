package com.xufan.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;

/**
 * @author XuFan
 * @create 2023-04-20-16:25
 */
@SuppressWarnings("AlibabaAvoidCommentBehindStatement")
public class TokenUtil {
    /**
     * 密钥明文
     */
    private static final String SECRET_CLEARTEXT = "xuFannnn";

    /**
     * 过期时间默认为半小时后过期
     */
    private static final long EXPIRATION_TIME = 1000 * 60L;
//    private static final long EXPIRATION_TIME = 1000 * 60 * 30L;


    public static SecretKey getSecretKey() {
        //以Base64编码获取到明文密钥的字节  以该数组生成一个AES算法的的密钥
        return new SecretKeySpec(Base64.getDecoder().decode(SECRET_CLEARTEXT) ,  "AES");
    }


    public static String getuuid() {
        return UUID.randomUUID().toString().replaceAll("-" , "");
    }


    public static String getToken(String str) {
        return getJwtBuilder(str).compact();
    }

    public static String getToken(String str , long mills) {
        return getJwtBuilder(str , mills).compact();
    }



    public static JwtBuilder getJwtBuilder(String str) {
        if(str == null){
            throw new RuntimeException("实体数据为空");
        }

        //获取到AES算法的密钥
        long nowMills = System.currentTimeMillis();
        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.put("msg" , str);
        return Jwts.builder()
                .setId(getuuid())          //唯一的ID
                .setSubject("token")       // 数据
                .setIssuer("PeterPan")     // 签发者
                .setClaims(defaultClaims)  //数据
                .setIssuedAt(new Date(nowMills))      // 签发时间设置为当前
                .signWith(SignatureAlgorithm.HS256, getSecretKey()) //使用HS256对称加密算法签名, 第二个参数为秘钥
                .setExpiration(new Date(nowMills + EXPIRATION_TIME));//设置为超时时间
    }


    public static JwtBuilder getJwtBuilder(String str , long mills) {
        if(str == null){
            throw new RuntimeException("实体数据为空");
        }
        //获取到AES算法的密钥
        long nowMills = System.currentTimeMillis();
        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.put("msg" , str);
        return Jwts.builder()//一个构造器 下面为必要属性的设置
                .setId(getuuid())           //唯一的ID
                .setSubject("token")        //主题为token
                .setIssuer("PeterPan")      // 签发者
                .setClaims(defaultClaims)   //数据存放
                .setIssuedAt(new Date(nowMills))      // 签发时间设置为当前
                .signWith(SignatureAlgorithm.HS256, getSecretKey()) //使用HS256对称加密算法签名, 第二个参数为秘钥
                .setExpiration(new Date(nowMills + mills));//设置过期时间
    }


    public static String getMsgFromToken(String token)
            throws UnsupportedJwtException,//不支持的格式异常
            MalformedJwtException ,//平台jwt异常
            SignatureException,//签名异常
            ExpiredJwtException,//超时异常
            IllegalArgumentException { //非法参数异常
        return Jwts.parser()//token的语法分析器
                .setSigningKey(getSecretKey())//设置签名验证所用的密钥
                .parseClaimsJws(token)//处理token
                .getBody()//获取存入的token里的所有信息
                .get("msg").toString();//获取claims里面存放的msg数据
    }

    public static Map<String, Object> getTokenBody(String token) {
        return Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
    }

    public static boolean tokenIsExpire(String token) {
        try {
            Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return true;
        } catch (Exception ignored) {
            return false;
        }
        return false;
    }

    public static void main(String[] args)throws UnsupportedJwtException,//不支持的格式异常
            MalformedJwtException ,//平台jwt异常
            SignatureException,//签名异常
            ExpiredJwtException,//超时异常
            IllegalArgumentException { //非法参数异常
        String token = TokenUtil.getToken("xufan");
        System.out.println(token);

        try {
            token = "eyJhbGciOiJIUzI1NiJ9.eyJtc2ciOiJ4dWZhbiIsImlhdCI6MTY4MjQ5ODY3MCwiZXhwIjoxNjgyNDk4NzMwfQ.UdNpsLXRnb8TSqsI1DyzovzaWk_e5QiGEPAeRBsjPgs";
            System.out.println("msg: " + Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody());
        } catch (ExpiredJwtException e) {
            System.out.println("超时异常");
        } catch (IllegalArgumentException e) {
            System.out.println("非法参数异常");
        } catch (Exception ignored) {

        }

    }


}
