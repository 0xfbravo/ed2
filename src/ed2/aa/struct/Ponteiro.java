package ed2.aa.struct;

import java.util.ArrayList;

import ed2.aa.model.Editora;

public class Ponteiro {
	private ArrayList<Editora> lista;
	
	public Ponteiro(){
		this.setLista(new ArrayList<Editora>());
	}

	public ArrayList<Editora> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Editora> lista) {
		this.lista = lista;
	}
}
