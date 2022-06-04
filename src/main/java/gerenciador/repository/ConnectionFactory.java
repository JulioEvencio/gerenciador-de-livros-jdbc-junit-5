package gerenciador.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import gerenciador.exception.ConnectionFailedException;

public class ConnectionFactory {

	public Connection getConnection() throws ConnectionFailedException {
		try {
			String url = "jdbc:mysql://localhost/gerenciador_de_livros";
			String user = "julio";
			String password = "123";

			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new ConnectionFailedException("Não foi possível conectar com o banco de dados!");
		}
	}

}
