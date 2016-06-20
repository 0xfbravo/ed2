package ed2.aa.model;

import java.util.HashMap;
import java.util.Map;

public class Autor {
	private int id;
	private String nome;
	private String nacionalidade;
	private String email;
	private Map<String,Integer> modelo = new HashMap<String,Integer>();
	
	public Autor(){
		// Autor (id, nome, nacionalidade, email)
		this.getModelo().put("id", 0);
		this.getModelo().put("nome", 1);
		this.getModelo().put("nacionalidade", 2);
		this.getModelo().put("email", 3);
	}
	
	public Autor(int id, String nome, String nacionalidade, String email){
		this.setId(id);
		this.setNome(nome);
		this.setNacionalidade(nacionalidade);
		this.setEmail(email);
	}
	
	@Override
	public String toString(){
		return this.getNome();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String,Integer> getModelo() {
		return modelo;
	}

	public void setModelo(Map<String,Integer> modelo) {
		this.modelo = modelo;
	}
}
