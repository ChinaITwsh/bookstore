package hlju.edu.book;

import hlju.edu.domain.Book;
import hlju.edu.utils.BaseServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookServlet extends BaseServlet {
	private BookService service = new BookService();
	/*
	 * 转发到books.jsp,查询某些图书
	 * */
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String typeid=req.getParameter("typeid");
		//查询
		List<Book> list = service.query(typeid);
		//封装到req
		req.setAttribute("list",list);
		//转发到books.jsp
		return "books";
	}
	/*
	 * 查询一本书的明细
	 * */
	public String detail(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		//接收这本书的id
		String bookid = req.getParameter("bookid");
		//调用service查询这个id对就应书
		Book book = service.detail(bookid);
		//封装到req
		req.setAttribute("book", book);
		//转发到book.jsp
		return "book";
	}

}
