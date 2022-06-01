package gerenciador.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gerenciador.model.Book;

public class BookRepositoryTest {

	@Mock
	private BookRepository repository;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void deve_recuperar_um_livro_no_banco_de_dados_pelo_id() throws Exception {
		repository.findById(2);
	}

	@Test
	void deve_recuperar_todos_os_livro_no_banco_de_dados() throws Exception {
		repository.findAll();
	}

	@Test
	void deve_salvar_um_livro_no_banco_de_dados() throws Exception {
		repository.save(new Book(null, "Nome teste", "Autor Teste"));
	}

	@Test
	void deve_atualizar_um_livro_no_banco_de_dados() throws Exception {
		repository.update(new Book(5, "Nome Atualizado", "Autor Atualizado"));
	}

	@Test
	void deve_deletar_um_livro_no_banco_de_dados() throws Exception {
		repository.delete(1);
	}

}
