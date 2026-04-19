
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 文档：认证流程.pdf
 * <p>
 * 作用：用于获取OPEN-ACCESS-TOKEN认证方式的AccessToken
 */
public class HeaderAuthorizationTokenUtil {

	/**
	 * appId,appKey在上线的时候，由柳工另外提供 
	 * 
	 */
	final String appId = "10037ca764636bbc01647d1ef4e10009";
	final String appkey = "389d830dcc0c46a58b0ea1962041e497";
	String timestamp ;
	String nonce ;

	public static void main(String[] args) {
		
		HeaderAuthorizationTokenUtil headerAuthorizationTokenUtil = new HeaderAuthorizationTokenUtil();
		System.out.println(headerAuthorizationTokenUtil.getHeaderAuthorization("{\"remark\":\"a\",\"oldPartLabLink\":\"a\",\"oemClaimNumber\":\"11\",\"claimSfid\":\"123\",\"auditResult\":\"1\"}"));

	}

	/**
	 * 得到http header Authorization的值
	 * @param json
	 * @return
	 */
	public String getHeaderAuthorization(String json) {
		setTimestamp("20231114160439");
		setNonce("ac3c72f3dc1c283418d251ceab5d932e");
		String signature = getSignature(json);
		final String template = "OPEN-BODY-SIG appId=\"%s\",timestamp=\"%s\",nonce=\"%s\",signature=\"%s\"";
		return String.format(template,appId,this.getTimestamp(),this.getNonce(),signature);
	}

	/**
	 * 得到body签名
	 * 
	 * @return
	 */
	public String getSignature(String json) {
		String bodyDigest = bodyDigest(json);
		String all = appId + this.getTimestamp() + this.getNonce() + bodyDigest;
		String signature = sha256_HMAC(all,appkey);
		System.out.println(all);
		System.out.println("signature"+signature);
		return signature;
	}

	/* 获取系统当前时间 */
	public  String getCurSystemTime() {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = date.format(System.currentTimeMillis());
		return time;
	}

	/* 获取随机数 */
	public  String getRandomUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

    /**
     * @Description: 加密算法sha256
     * @Param: [message]
     * @return: java.lang.String
     */
	private  String bodyDigest(String json) {
		MessageDigest messageDigest;
		String encodestr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(json.getBytes("UTF-8"));
			encodestr = byte2Hex(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException("签名过程中出现错误");
		}
		return encodestr;
	}

	private  String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
    /**
     * @Description: 加密算法HmacSHA256
     * @Param: [message,secret]
     * @return: java.lang.String
     */
    private  String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = java.util.Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
        	throw new RuntimeException("签名过程中出现错误");
        }
        return hash;

    }

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	
	public String getNonce() {
		return nonce;
	}

    
}
