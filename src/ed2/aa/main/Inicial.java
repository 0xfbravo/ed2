package ed2.aa.main;

import ed2.aa.model.Autor;
import ed2.aa.struct.Pagina;

public class Inicial {

	public static void main(String args[]){
		Pagina<Autor> arvoreAutor = new Pagina<Autor>();
		for(int i = 0; i < 16; i ++){
			String nome = "Autor";
			if( i < 10) { nome = nome+"0"+i; }
			else { nome = nome+i; }
			Autor autor = new Autor(i,nome,"Brasileiro","e@mail.com");
			arvoreAutor = arvoreAutor.inserir(autor);
		}
		
		arvoreAutor.visualizarArvore();
	}
	
}
