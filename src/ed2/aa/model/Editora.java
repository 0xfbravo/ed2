package ed2.aa.model;

public class Editora {

	private int idEditora;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Editora(int idEditora, String nome, String endereco, String telefone){
		this.setIdEditora(idEditora);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
	}
	
	@Override
	public String toString(){
		return this.getNome();
	}

	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
