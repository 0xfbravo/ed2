package ed2.aa.model;

import java.util.HashMap;
import java.util.Map;

public class Livro {
	private int isbn;
	private String titulo;
	private int idAutor;
	private int idEditora;
	private Map<String,Integer> modelo = new HashMap<String,Integer>();
	
	public Livro(){
		// Livro (isbn, título, id_autor, id_editora)
		this.getModelo().put("isbn", 0);
		this.getModelo().put("titulo", 1);
		this.getModelo().put("id_autor", 2);
		this.getModelo().put("id_editora", 3);
	}

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

	public Map<String,Integer> getModelo() {
		return modelo;
	}

	public void setModelo(Map<String,Integer> modelo) {
		this.modelo = modelo;
	}
	
	
}
