package wang;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private List<Book> books;
	private List<Author> authors;
	private BookService bookService = new BookService();
	private String ISBN;
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public BookService getBookService() {
		return this.bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	// private Book book;

	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public String list() {
		books = bookService.list(name);
		return "success";
	}

	public String delete() {
		bookService.deleteByISBN(ISBN);
		return "success";
	}
	
	public String detail(){
		books=bookService.detailByISBN(ISBN);
		authors=bookService.audetailByISBN(ISBN);
		return "success";
	}

	
	

}
