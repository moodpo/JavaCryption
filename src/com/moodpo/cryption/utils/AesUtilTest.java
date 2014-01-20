package com.moodpo.cryption.utils;

public class AesUtilTest {
    private static final String IV = "F27D5C9927726BCEFE7510B1BDD3D137";
    private static final String SALT = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
    private static final String PLAIN_TEXT = "123";
    
    private static final String PASSPHRASE = "the quick brown fox jumps over the lazy dog";
    
    public static void main(String[] args) {
    	 AesUtil util = new AesUtil();
         String encrypt = util.encrypt(SALT, IV, PASSPHRASE, PLAIN_TEXT);
         
         System.out.println("encrypt: " + encrypt);
         
         String decrypt = util.decrypt(SALT, IV, PASSPHRASE, encrypt);
         
         System.out.println("decrypt: " + decrypt);
         
         System.out.println(PLAIN_TEXT.equals(decrypt));
         
         if(PLAIN_TEXT.equals(decrypt)) {
        	 System.out.println("Successfull");
         }
	}
}
