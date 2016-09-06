package hlju.edu.index;

import hlju.edu.domain.Types;
import hlju.edu.types.TypeService;
import hlju.edu.utils.BaseServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends BaseServlet {
	private TypeService service = new TypeService();
	/*
	 * 显示主页，要查询出所有的图书分类
	 * */
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		List<Types> types = service.queryAll();
		req.setAttribute("types",types);
		return "index";
	}
}
