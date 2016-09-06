package hlju.edu.book;

import hlju.edu.domain.Book;

import java.util.List;


public class BookService {
	private BookDao dao = new BookDao();
	public List<Book> query(String typeid){
		return dao.query(typeid);
	}
	public Book detail(String bookid) {
		return dao.detail(bookid);
	}
}
