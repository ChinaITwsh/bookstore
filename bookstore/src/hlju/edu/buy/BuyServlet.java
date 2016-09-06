package hlju.edu.buy;

import hlju.edu.book.BookService;
import hlju.edu.domain.Book;
import hlju.edu.utils.BaseServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BuyServlet extends BaseServlet {
	private BookService bookService = new BookService();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String bookid = req.getParameter("bookid");
		System.err.println("bookid is:"+bookid);
		Map<String,Book> car = (Map<String, Book>) req.getSession().getAttribute("car");
		if(car==null){
			car = new HashMap<String, Book>();
			req.getSession().setAttribute("car", car);
		}
		if(car.get(bookid)==null){
			Book book = bookService.detail(bookid);
			book.setSum(1);
			car.put(book.getId(), book);
		}else{
			Book bk = car.get(bookid);
			bk.setSum(bk.getSum()+1);
		}
		return "302:car";
	}
}
