package ed2.aa.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		//buscarTelefoneEditora("Editora Orleans");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bemVindo();
		menu();
		try {
			String temp;
			while((temp = br.readLine().toLowerCase()) != null){
				switch(temp){
					case "2":
						System.out.print("Digite o Nome da Editora: ");
						buscarTelefoneEditora(br.readLine());
						break;
					case "4":
						System.out.print("Digite o ID do Autor: ");
						buscarAutor(br.readLine());
						break;
					case "5":
						System.out.print("Digite o ID da Editora: ");
						buscarEditora(br.readLine());
						break;
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
		System.out.print("Digite a opção que deseja: ");
	}
	
	public static void verLivro(Livro l){
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t\t"+l.getTitulo());
		System.out.println("\t-----------------------------------------------------");
		
	}
	
	public static void buscarLivrosAutor(String nome){
		File selecao = Consulta.selecao("autor", "nome", nome);
		String tabelaSelecao = selecao.getName().replaceAll(".dat", "");
		File projecao = Consulta.projecao(tabelaSelecao, "id");
		Arquivo.visualizar(projecao);
	}
	
	public static void buscarEditora(String id_editora){
		ArrayList<Object> objetos = Arquivo.converterEmObjeto("editora", Consulta.selecao("editora", "id_editora",id_editora));
		if(!objetos.isEmpty()){ verEditora((Editora) objetos.get(0)); }
		else{
			System.out.println("");
			menu();
		}
	}
	
	public static void verEditora(Editora e){
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t\tInformações de Editora");
		System.out.println("\t-----------------------------------------------------");
		System.out.println("Nome: "+e.getNome());
		System.out.println("Endereço: "+e.getEndereco());
		System.out.println("Telefone: "+e.getTelefone());
		System.out.println("");
		menu();
	}
	
	public static void buscarTelefoneEditora(String nome){
		File selecao = Consulta.selecao("editora", "nome", nome);
		String tabelaSelecao = selecao.getName().replaceAll(".dat", "");
		File projecao = Consulta.projecao(tabelaSelecao, "telefone");
		System.out.println("Telefone da "+nome);
		Arquivo.visualizar(projecao);
		System.out.println("");
		menu();
	}
	
	public static void buscarAutor(String id){
		ArrayList<Object> objetos = Arquivo.converterEmObjeto("autor", Consulta.selecao("autor", "id",id));
		if(!objetos.isEmpty()){ verAutor((Autor) objetos.get(0)); }
		else{
			System.out.println("");
			menu();
		}
	}
	
	public static void verAutor(Autor a){
		System.out.println("\t-----------------------------------------------------");
		System.out.println("\t\t\tInformações de Autor");
		System.out.println("\t-----------------------------------------------------");
		System.out.println("Nome: "+a.getNome());
		System.out.println("Nacionalidade: "+a.getNacionalidade());
		System.out.println("E-mail: "+a.getEmail());
		System.out.println("");
		menu();
	}
	
}
