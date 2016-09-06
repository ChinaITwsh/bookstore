package hlju.edu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;
/*
 * 密码加密算法
 * */
public class PasswordUtils {
	public static String encodePassword(String userName,String password){
		String pwd = "";
		try {
			int nameHash = userName.hashCode();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bs= md.digest(password.getBytes());
			for(byte b:bs){
				int res = b+nameHash;
				int a = res & 0xff;
				if(a<16){
					a+=16;
				}
				String hex = Integer.toHexString(a);
				pwd+=hex;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}
}
