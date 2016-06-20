package ed2.aa.database;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Map;

import ed2.aa.model.Autor;
import ed2.aa.model.Editora;
import ed2.aa.model.Livro;

public class Arquivo {

	public static void converterEmBytes(String entrada, String saida){
		try{
			RandomAccessFile leitura = new RandomAccessFile(entrada,"rw");
			RandomAccessFile escrita = new RandomAccessFile(saida,"rw");
			
			String linha = new String();
			while((linha = leitura.readLine()) != null)
				escrita.writeUTF(linha+"\n");
			
			leitura.close();
			escrita.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Object> converterEmObjeto(String tabela, File arquivo){
		try{
			String t = tabela.toLowerCase();
			ArrayList<Object> objetos = new ArrayList<Object>();
			Map<String,Integer> modelo = Consulta.buscarModelo(t);
			RandomAccessFile leitura = new RandomAccessFile(arquivo,"rw");
			
			while(leitura.getFilePointer() < leitura.length()){
				// Ler uma linha inteira, em UTF
				String linha = leitura.readUTF();
				
				// Separar Colunas do Arquivo
				String[] colunas = linha.split("\t");
				
				// Tratar Autores do Arquivo
				if(t == "autor"){
					// Acessar coluna correta do modelo
					int id = Integer.parseInt(colunas[modelo.get("id")]);
					String nome = colunas[modelo.get("nome")];
					String nacionalidade = colunas[modelo.get("nacionalidade")];
					String email = colunas[modelo.get("email")];
					objetos.add(new Autor(id,nome,nacionalidade,email));
				}
				// Tratar Editoras do Arquivo
				else if(t == "editora"){
					// Acessar coluna correta do modelo
					int id_editora = Integer.parseInt(colunas[modelo.get("id_editora")]);
					String nome = colunas[modelo.get("nome")];
					String endereco = colunas[modelo.get("endereco")];
					String telefone = colunas[modelo.get("telefone")];
					objetos.add(new Editora(id_editora,nome,endereco,telefone));
				}
				// Tratar Livros do Arquivo
				else if(t == "livro"){
					// Acessar coluna correta do modelo
					int isbn = Integer.parseInt(colunas[modelo.get("isbn")]);
					String titulo = colunas[modelo.get("titulo")];
					int id_autor = Integer.parseInt(colunas[modelo.get("id_autor")]);
					int id_editora = Integer.parseInt(colunas[modelo.get("id_editora")]);
					objetos.add(new Livro(isbn,titulo,id_autor,id_editora));
				}
			}
			
			leitura.close();
			// Remove arquivo de Consulta
			arquivo.delete();
			return objetos;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
}