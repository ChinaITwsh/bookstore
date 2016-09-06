package hlju.edu.test;

import hlju.edu.utils.PasswordUtils;

import org.junit.Test;


public class MyTest {
	@Test
	public void aaa(){
		String name = "张三";
		String pwd = "7777777";
		pwd = PasswordUtils.encodePassword(name, pwd);
		System.err.println(pwd);
	}
}
