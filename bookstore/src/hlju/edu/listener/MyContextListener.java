package hlju.edu.listener;
import hlju.edu.utils.PageUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
 * 读取用户配置的信息： configLocation
 * */
public class MyContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent e) {
		ServletContext ctx = e.getServletContext();
		String configFile = ctx.getInitParameter("configLocation");
		if (configFile == null) {
			configFile = "view.properties";
		}
		InputStream in = null;
		if(configFile.startsWith("/")){
			String path = ctx.getRealPath(configFile);
			try {
				in = new FileInputStream(path);
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}else{
			in = MyContextListener.class.getClassLoader()
					.getResourceAsStream(configFile);
		}
		 
		PageUtils.setIn(in);
	}
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
