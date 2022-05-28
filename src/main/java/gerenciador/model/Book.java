package gerenciador.model;

public class Book {

	private Integer id;
	private String name;
	private String author;

	public Book() {
		super();
	}

	public Book(Integer id, String nome, String autor) {
		super();
		this.id = id;
		this.name = nome;
		this.author = autor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getAutor() {
		return author;
	}

	public void setAutor(String autor) {
		this.author = autor;
	}

}
