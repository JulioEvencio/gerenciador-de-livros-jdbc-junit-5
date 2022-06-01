package gerenciador.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gerenciador.model.Book;

public class BookServiceTest {

	@Mock
	private BookService service;

	@BeforeEach
	void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		service.save(new Book(null, "Livro 1", "Autor 1"));
		service.save(new Book(null, "Livro 2", "Autor 2"));
		service.save(new Book(null, "Livro 3", "Autor 3"));
	}

	@Test
	void deve_recuperar_um_livro_no_banco_de_dados_pelo_id() throws Exception {
		service.findById(1);
	}

	@Test
	void deve_recuperar_todos_os_livro_no_banco_de_dados() throws Exception {
		service.findAll();
	}

	@Test
	void deve_salvar_um_livro_no_banco_de_dados() throws Exception {
		service.save(new Book(null, "Nome teste", "Autor Teste"));
	}

	@Test
	void deve_atualizar_um_livro_no_banco_de_dados() throws Exception {
		service.update(new Book(2, "Nome Atualizado", "Autor Atualizado"));
	}

	@Test
	void deve_deletar_um_livro_no_banco_de_dados() throws Exception {
		service.delete(1);
	}

}
