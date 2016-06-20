package ed2.aa.model;

import java.util.HashMap;
import java.util.Map;

public class Editora {

	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private Map<String,Integer> modelo = new HashMap<String,Integer>();
	
	public Editora(){
		// Editora (id_editora, nome, endereco, telefone)
		this.getModelo().put("id_editora", 0);
		this.getModelo().put("nome", 1);
		this.getModelo().put("endereco", 2);
		this.getModelo().put("telefone", 3);
	}
	
	public Editora(int id, String nome, String endereco, String telefone){
		this.setId(id);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
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

	public Map<String,Integer> getModelo() {
		return modelo;
	}

	public void setModelo(Map<String,Integer> modelo) {
		this.modelo = modelo;
	}
}
