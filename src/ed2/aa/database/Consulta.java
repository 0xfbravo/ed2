package ed2.aa.database;

import java.util.ArrayList;

import ed2.aa.model.Autor;
import ed2.aa.model.Editora;
import ed2.aa.model.Livro;

public interface Consulta{
	public ArrayList<Livro> buscarLivros(String autor);
	public String buscarEditora(String telefone);
	public void buscarAutorEditora(String titulo); // TODO: Alterar tipo de retorno
	public Autor buscarAutor(int id);
	public Editora buscarEditora(int id);
}
