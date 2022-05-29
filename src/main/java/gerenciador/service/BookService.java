package gerenciador.service;

import java.util.List;

import gerenciador.model.Book;
import gerenciador.repository.BookRepository;

public class BookService {

	private BookRepository repository;

	public BookService() {
		repository = new BookRepository();
	}

	public Book findById(Integer id) {
		return repository.findById(id);
	}

	public List<Book> findByAll() {
		return repository.findByAll();
	}

	public void save(Book book) {
		repository.save(book);
	}

	public void update(Book book) {
		repository.update(book);
	}

	public void delete(Integer id) {
		repository.delete(id);
	}

}
