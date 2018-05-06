package jcloader;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Use3DES {
    private static final String ALGORIHM = "DESede";

    public static byte[] encrypt(byte[] key,byte[] src){
        byte[] value=null;
        try {
            /* 生成密约 */
            SecretKey deskey= new SecretKeySpec(key,ALGORIHM);
            Cipher cipher=Cipher.getInstance(ALGORIHM);
            cipher.init(Cipher.ENCRYPT_MODE,deskey);
            value=cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static byte[] decrypt(byte[] key,byte[] src){
        byte[] value  = null;
        try {
            SecretKey deskey = new SecretKeySpec(key,ALGORIHM);
            Cipher cipher = Cipher.getInstance(ALGORIHM);
            cipher.init(Cipher.DECRYPT_MODE,deskey);
            value = cipher.doFinal(src);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args){
        BufferedInputStream in=null;

        try {
            byte[] key = "01234567899876543210abcd".getBytes();
            String src="aaabbb2211";
            byte[] enc=encrypt(key,src.getBytes());
            byte[] dec=decrypt(key,enc);
            String result=new String(dec);
            System.out.println(result);


        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
