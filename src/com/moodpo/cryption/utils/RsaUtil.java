package com.moodpo.cryption.utils;

import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RsaUtil {
	private static Charset PLAIN_TEXT_ENCODING = Charset.forName("UTF-8");
	private int KEY_SIZE_BITS = 1024;

	/**
	 * 产生一个RSA密钥对
	 * @param keyLength 密钥长度
	 * @return
	 * @throws Exception
	 */
	public KeyPair generateKeypair() {
		KeyPairGenerator keyPairGen;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(KEY_SIZE_BITS);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			return keyPair;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/** 
     * 得到密钥字符串（经过base64编码） 
     * @return 
     */ 
	public static String getKeyString(Key key){  
        byte[] keyBytes = key.getEncoded();
        return base64(keyBytes);
	}
	
	public static String base64(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

	public static byte[] base64(String str) {
		return Base64.decodeBase64(str);
	}
	
	/**
	 * 解密
	 * @param encrypted
	 * @param keyPair
	 * @return
	 */
	public static String decrypt(String encrypted, KeyPair keyPair){
		try {
			byte[] enBytes = base64(encrypted);
			Cipher cipher = Cipher.getInstance("RSA");
			PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] deBytes = cipher.doFinal(enBytes);
			return new String(deBytes, PLAIN_TEXT_ENCODING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 加密
	 * @param encrypted
	 * @param keyPair
	 * @return
	 */
	public static String encrypt(String password, KeyPair keyPair){
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] enBytes = cipher.doFinal(password.getBytes());
			return base64(enBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
