package gerenciador.service;

import java.util.List;

import gerenciador.exception.ConnectionFailedException;
import gerenciador.exception.DeleteBookFailedException;
import gerenciador.exception.FindBookFailedException;
import gerenciador.exception.SaveBookFailedException;
import gerenciador.exception.UpdateBookFailedException;
import gerenciador.model.Book;
import gerenciador.repository.BookRepository;

public class BookService {

	private BookRepository repository;

	public BookService() {
		repository = new BookRepository();
	}

	public Book findById(Integer id) throws ConnectionFailedException, FindBookFailedException {
		return repository.findById(id);
	}

	public List<Book> findAll() throws ConnectionFailedException, FindBookFailedException {
		return repository.findAll();
	}

	public void save(Book book) throws ConnectionFailedException, SaveBookFailedException {
		repository.save(book);
	}

	public void update(Book book) throws ConnectionFailedException, UpdateBookFailedException {
		repository.update(book);
	}

	public void delete(Integer id) throws ConnectionFailedException, DeleteBookFailedException {
		repository.delete(id);
	}

}
