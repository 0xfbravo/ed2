package ed2.aa.main;

import ed2.aa.model.Autor;
import ed2.aa.struct.Pagina;

public class Inicial {

	public static void main(String args[]){
		Autor autor = new Autor(0,"Autor Teste","Brasileiro","e@mail.com");
		Pagina<Autor> p = new Pagina<Autor>();
		p.inserir(autor);
		p.inserir(autor);
		p.inserir(autor);
		p.inserir(autor);
		p.inserir(autor);
	}
	
}
