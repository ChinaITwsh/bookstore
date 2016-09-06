package hlju.edu.user;

import hlju.edu.domain.User;
import hlju.edu.utils.BaseServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


public class UserServlet extends BaseServlet {
	
	private UserService service = new UserService();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		User user = new User();
		
		BeanUtils.populate(user,req.getParameterMap());
		
		service.save(user);
		
		req.getSession().setAttribute("msg","你已经注册成功，请登录");
		return "302:login";
	}
	/*
	 * 提供用户登录
	 * */
	public String login(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = new User();
		BeanUtils.populate(user,req.getParameterMap());
		
		User user2 = service.login(user);
		if(user2==null){
			req.setAttribute("user",user);
			req.getSession().setAttribute("msg", "你的用户名或是密码错误");
			return "login";
		}else{
			req.getSession().setAttribute("user", user2);
			return "302:succ";
		}
	}

}
