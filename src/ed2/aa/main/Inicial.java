package ed2.aa.main;

import java.util.ArrayList;

import ed2.aa.database.Arquivo;
import ed2.aa.database.Consulta;
import ed2.aa.model.Autor;
import ed2.aa.model.Editora;
import ed2.aa.model.Livro;

public class Inicial {
	public static boolean DEBUG = true;
	
	public static void main(String args[]){
		// Conversão de Arquivos Txt -> Byte
		//Arquivo.converterEmBytes("autor.txt", "autor.dat");
		//Arquivo.converterEmBytes("editora.txt", "editora.dat");
		//Arquivo.converterEmBytes("livro.txt", "livro.dat");
		
		String tabela = "livro";
		String coluna = "*";
		String comparador = "";
		ArrayList<Object> resultados = Arquivo.converterEmObjeto(tabela, Consulta.selecao(tabela, coluna, comparador));
		resultados.forEach(a -> {
			System.out.println(a);
		});
		
		/*
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
						System.out.println(":: Op��o n�o conhecida.");
						menu();
						break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
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
