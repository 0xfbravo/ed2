package ed2.aa.model;

public class Autor {
	private int id;
	private String nome;
	private String nacionalidade;
	private String email;
	
	public Autor(int id, String nome, String nacionalidade, String email){
		this.setId(id);
		this.setNome(nome);
		this.setNacionalidade(nacionalidade);
		this.setEmail(email);
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
}
