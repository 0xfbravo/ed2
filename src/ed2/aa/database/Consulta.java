package ed2.aa.database;

import java.util.ArrayList;

import ed2.aa.model.Autor;
import ed2.aa.model.Livro;

public interface Consulta{
	public ArrayList<Livro> buscarLivros(String autor);
	public void buscarAutorEditora(String titulo); // TODO: Alterar tipo de retorno
	public Autor buscarAutor(int id);
}
