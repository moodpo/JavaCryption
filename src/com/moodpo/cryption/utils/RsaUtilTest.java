package com.moodpo.cryption.utils;

import java.security.KeyPair;

public class RsaUtilTest {
	
	public static void main(String[] args) {
		RsaUtil util = new RsaUtil();
		KeyPair keyPair = util.generateKeypair();
		
		String plainText = "123";
		
		String encrypt = RsaUtil.encrypt(plainText, keyPair);
		
		System.out.println("Encrypt: " + encrypt);
		
		String decrypt = RsaUtil.decrypt(encrypt, keyPair);
		
		System.out.println("Decrypt: " + decrypt);
		
	}
	
	
}
