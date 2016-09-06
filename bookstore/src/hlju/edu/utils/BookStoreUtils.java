package hlju.edu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*
 * 随机生成订单号，生成生成订单时的时间
 * */
public class BookStoreUtils {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String order(Object o) {
		return "" + o.hashCode();
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String date() {
		return sdf.format(new Date());
	}
}
