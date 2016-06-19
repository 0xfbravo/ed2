package ed2.aa.model;

public class Livro {
	private int isbn;
	private String titulo;
	private int idAutor;
	private int idEditora;

	public Livro(int isbn, String titulo, int idAutor, int idEditora){
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setIdAutor(idAutor);
		this.setIdEditora(idEditora);
	}
	
	@Override
	public String toString(){
		return this.getTitulo();
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}
	
	
}
