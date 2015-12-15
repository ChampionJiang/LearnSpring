package test.service;

import java.util.List;

import test.domain.Book;
import test.domain.Category;

public interface BookService {

	public List<Category> getAllCategories() ;

	public Book get(long id);

	public Category getCategory(int id);

	public Book save(Book book);

	public Book update(Book book);

	public List<Book> getAllBooks();
	
	long getNextId();

}
