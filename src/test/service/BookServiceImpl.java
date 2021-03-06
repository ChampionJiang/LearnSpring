package test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import test.domain.Book;
import test.domain.Category;

@Service
public class BookServiceImpl implements BookService {

	private List<Category> categories;
	private List<Book> books;
	
	public BookServiceImpl() {
		categories = new ArrayList<Category>();
		Category category1 = new Category(1, "Computing");
		Category category2 = new Category(2, "Travel");
		Category category3 = new Category(3, "Helth");
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		books = new ArrayList<Book>();
		books.add(new Book(1L, "9780980839623",
				"Servlet & JSP: A Tutorial",
				category1, "Budi Kurniawa"));
		
		books.add(new Book(2L, "97809839630",
				"C#: A Beginner's Tutorial",
				category1, "Jayden Ky"));
	}
	
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Book get(long id) {
		for (Book book : books) {
			if (id == book.getId()) {
				return book;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(int id) {
		for (Category category: categories) {
			if (id == category.getId()) {
				return category;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		book.setId(getNextId());
		books.add(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		int bookCount = books.size();
		for (int i = 0; i < bookCount; i++) {
			Book savedBook = books.get(i);
			if (savedBook.getId() == book.getId()) {
				books.set(i,  book);
				return book;
			}
		}
		// TODO Auto-generated method stub
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public long getNextId() {
		long id = 0L;
		for (Book book : books) {
			long bookId = book.getId();
			if (bookId > id) {
				id = bookId;
			}
		}
		return id + 1;
	}

}
