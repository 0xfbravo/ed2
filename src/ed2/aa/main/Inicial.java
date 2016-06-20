package ed2.aa.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ed2.aa.database.Arquivo;
import ed2.aa.model.Autor;
import ed2.aa.model.Editora;
import ed2.aa.model.Livro;
import ed2.aa.struct.Hash;

public class Inicial {

	public static void main(String args[]){
		Arquivo.converter("autor.txt", "autor.dat");
		Arquivo.converter("editora.txt", "editora.dat");
		Arquivo.converter("livro.txt", "livro.dat");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bemVindo();
		menu();
		try {
			String temp;
			while((temp = br.readLine().toLowerCase()) != null){
				switch(temp){
					case "sair":
						System.exit(0);
						break;
					default:
						System.out.println(":: Opção não conhecida.");
						menu();
						break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*Pagina<Autor> arvoreAutor = new Pagina<Autor>();
		for(int i = 0; i < 16; i ++){
			String nome = "Autor";
			if( i < 10) { nome = nome+"0"+i; }
			else { nome = nome+i; }
			Autor autor = new Autor(i,nome,"Brasileiro","e@mail.com");
			arvoreAutor = arvoreAutor.inserir(autor);
		}
		
		arvoreAutor.visualizarArvore();*/
		
		Hash hashEditora = new Hash();
		hashEditora.inserir(new Editora(457,"Ed1","sei la","555-2323"));
		hashEditora.inserir(new Editora(452,"Ed2","se la","552-2323"));
		hashEditora.inserir(new Editora(445,"Ed3","s la","555-4785"));
		hashEditora.inserir(new Editora(458,"Ed4","se l","555-2222"));
		
		System.out.println(hashEditora.buscarEditora("555-2323"));
	}
	
	public static void bemVindo(){
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t\tBem-vindo(a) à AA de Ed2!");
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\tIntegrantes: \n\t\t• Bianca Albuquerque\n\t\t• Fellipe Bravo\n\t\t• Reinaldo Moraes");
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\tDigite ''sair'' para encerrar a execução do Programa.");
	}
	
	public static void menu(){
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t1. Buscar Livros por Autor");
		System.out.println("\t\t2. Buscar Telefone de Editora");
		System.out.println("\t\t3. Buscar Autor e Editora");
		System.out.println("\t\t4. Informações de um Autor");
		System.out.println("\t\t5. Informações de uma Editora");
		System.out.println("\t-----------------------------------------------------");
	}
	
	public static void verLivro(Livro l){
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t\t"+l.getTitulo());
		System.out.println("\t-----------------------------------------------------");
		
	}
	
	public static void verEditora(Editora e){
		
	}
	
	public static void verAutor(Autor a){
		
	}
	
}
