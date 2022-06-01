package gerenciador.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gerenciador.exception.ConnectionFailedException;
import gerenciador.exception.DeleteBookFailedException;
import gerenciador.exception.FindBookFailedException;
import gerenciador.exception.SaveBookFailedException;
import gerenciador.exception.UpdateBookFailedException;
import gerenciador.model.Book;

public class BookRepository {

	public Book findById(Integer id) throws ConnectionFailedException, FindBookFailedException {
		try (Connection con = new ConnectionFactory().getConnection()) {
			String sql = "SELECT nome, autor FROM tb_livro WHERE id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			Book book = null;

			while (rs.next()) {
				book = new Book(id, rs.getString("nome"), rs.getString("autor"));
			}

			stmt.close();

			return book;
		} catch (SQLException e) {
			throw new FindBookFailedException("Erro ao recuperar o livro pelo id!");
		}
	}

	public List<Book> findAll() throws ConnectionFailedException, FindBookFailedException {
		try (Connection con = new ConnectionFactory().getConnection()) {
			String sql = "SELECT * FROM tb_livro;";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			List<Book> list = new ArrayList<>();

			while (rs.next())
				list.add(new Book(rs.getInt("id"), rs.getString("nome"), rs.getString("autor")));

			stmt.close();

			return list;
		} catch (SQLException e) {
			throw new FindBookFailedException("Erro ao recuperar todos os livros!");
		}
	}

	public void save(Book book) throws ConnectionFailedException, SaveBookFailedException {
		try (Connection con = new ConnectionFactory().getConnection()) {
			String sql = "INSERT INTO tb_livro (nome, autor) VALUES (?, ?);";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthor());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new SaveBookFailedException("Erro ao salvar um livro no banco de dados!");
		}
	}

	public void update(Book book) throws ConnectionFailedException, UpdateBookFailedException {
		try (Connection con = new ConnectionFactory().getConnection()) {
			String sql = "UPDATE tb_livro SET nome = ?, autor = ? WHERE id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthor());
			stmt.setInt(3, book.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new UpdateBookFailedException("Erro ao atualizar um livro no banco de dados!");
		}
	}

	public void delete(Integer id) throws ConnectionFailedException, DeleteBookFailedException {
		try (Connection con = new ConnectionFactory().getConnection()) {
			String sql = "DELETE FROM tb_livro WHERE id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DeleteBookFailedException("Erro ao deletar um livro no banco de dados!");
		}
	}

}
