package ed2.aa.struct;

import ed2.aa.model.Editora;

public class Hash{
	
	public static int m = 11;
	private Ponteiro[] tabelaNomes;
	private Ponteiro[] tabelaIds;
	
	public Hash(){
		this.setTabelaIds(new Ponteiro[m]);
		this.setTabelaNomes(new Ponteiro[m]);
		
		for(int i = 0; i < m; i++){
			this.getTabelaIds()[i] = new Ponteiro();
			this.getTabelaNomes()[i] = new Ponteiro();
		}
	}
	
	public void inserir(Editora e){
		int dispersaoId = dispersao(e.getId());
		int dispersaoNome = dispersao(tratarNome(e.getNome()));
		this.getTabelaIds()[dispersaoId].getLista().add(e);
		this.getTabelaNomes()[dispersaoNome].getLista().add(e);
	}
	
	public Editora buscarEditora(String nome){
		int dispersao = dispersao(tratarNome(nome));
		for(Editora e: this.tabelaNomes[dispersao].getLista()){
			if(e.getNome() == nome) return e;
		}
		return null;
	}
	
	public Editora buscarEditora(int id){
		int dispersao = dispersao(id);
		for(Editora e: this.tabelaIds[dispersao].getLista()){
			if(e.getId() == id) return e;
		}
		return null;
	}
	
	public int tratarNome(String n){
		int valor = 0;
		for(char c : n.toCharArray())
			valor += Character.getNumericValue(c);
		return valor;
	}
	
	public int dispersao(int i){
		return i % m;
	}

	public Ponteiro[] getTabelaNomes() {
		return tabelaNomes;
	}

	public void setTabelaNomes(Ponteiro[] tabelaNomes) {
		this.tabelaNomes = tabelaNomes;
	}

	public Ponteiro[] getTabelaIds() {
		return tabelaIds;
	}

	public void setTabelaIds(Ponteiro[] tabelaIds) {
		this.tabelaIds = tabelaIds;
	}
}
